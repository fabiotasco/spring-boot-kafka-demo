
package io.fab.connector.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.fab.connector.ifood.IFoodApiAccessTokenStorage;

/**
 * Configuração do armazenamento, em memória, do token de acesso à API do iFood.
 *
 * @author fabio.tasco
 * @see IFoodApiAccessTokenStorage
 */
@Configuration
public class IFoodApiAccessTokenStorageConfiguration {

	@Bean
	public IFoodApiAccessTokenStorage iFoodApiAccessTokenStorage() {
		return new IFoodApiAccessTokenStorage();
	}

}
