
package io.fab.connector.rules;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import br.com.gaveteiro.ifood.client.api.AuthApi;
import br.com.gaveteiro.ifood.client.invoker.ApiClient;
import br.com.gaveteiro.ifood.client.model.AuthInfo;
import io.fab.connector.ifood.IFoodApiAccessTokenStorage;

@Component
public class AuthenticationRules {

	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationRules.class);

	@Autowired
	private IFoodApiAccessTokenStorage iFoodApiAccessTokenStorage;

	@Autowired
	private AuthApi authApi;

	@Value("${app.ifood.auth.username}")
	private String username;

	@Value("${app.ifood.auth.password}")
	private String password;

	@Value("${app.ifood.auth.access-token-expiration-time}")
	private Long accessTokenExpirationTime;

	/**
	 * Carrega um token de acesso válido. A verificação da existência do token de acesso é feito em memória e, caso não
	 * exista, é solicitado para o iFood e registrado no cliente de API.
	 *
	 * @see ApiClient
	 */
	public void loadIFoodApiAccessToken() {
		String accessToken = null;
		if (iFoodApiAccessTokenStorage.getAccessToken() != null && !isAccessTokenExpired()) {
			accessToken = iFoodApiAccessTokenStorage.getAccessToken();

			LOG.debug("Using in-memory IFood API access token!");

		} else {
			accessToken = requestAccessToken();
			iFoodApiAccessTokenStorage.setAccessToken(accessToken);
			iFoodApiAccessTokenStorage.setCreatedAt(new Date());

			LOG.debug("IFood API access token requested!");
		}
		authApi.getApiClient().setAccessToken(accessToken);
	}

	/**
	 * Verifica se o token de acesso expirou. O token expira quando a diferença entre a data que ele foi criado e a data
	 * atual é maior que o tempo configurado!
	 *
	 * @return Verdadeiro, se expirou. Falso, caso contrário.
	 */
	private boolean isAccessTokenExpired() {
		final Date now = new Date();
		final Long expirationTimeDelta = now.getTime() - iFoodApiAccessTokenStorage.getCreatedAt().getTime();

		return expirationTimeDelta >= accessTokenExpirationTime;
	}

	/**
	 * Realiza a requisição do token de acesso à API do iFood.
	 *
	 * @return Token de acesso.
	 */
	private String requestAccessToken() {
		authApi.authLoginPost(buildAuthInfo());
		return authApi.getApiClient().getResponseHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
	}

	private AuthInfo buildAuthInfo() {
		final AuthInfo authInfo = new AuthInfo();
		authInfo.setUsername(username);
		authInfo.setPassword(password);

		return authInfo;
	}

}
