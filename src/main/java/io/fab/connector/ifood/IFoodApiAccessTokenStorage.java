
package io.fab.connector.ifood;

import java.util.Date;

/**
 * Armazena o token de acesso à API do iFood.
 *
 * @author fabio.tasco
 */
public class IFoodApiAccessTokenStorage {

	private String accessToken;
	private Date createdAt;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(final String accessToken) {
		this.accessToken = accessToken;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final Date createdAt) {
		this.createdAt = createdAt;
	}

}
