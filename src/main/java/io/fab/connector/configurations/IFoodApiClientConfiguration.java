
package io.fab.connector.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.gaveteiro.ifood.client.invoker.ApiClient;

@Configuration
public class IFoodApiClientConfiguration {

	@Bean
	public ApiClient apiClient() {
		return new ApiClient();
	}

}
