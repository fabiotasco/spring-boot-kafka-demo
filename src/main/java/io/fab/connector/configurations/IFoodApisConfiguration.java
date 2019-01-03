
package io.fab.connector.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.gaveteiro.ifood.client.api.AuthApi;
import br.com.gaveteiro.ifood.client.api.EventsApi;
import br.com.gaveteiro.ifood.client.api.OrdersApi;
import br.com.gaveteiro.ifood.client.api.ProductsApi;
import br.com.gaveteiro.ifood.client.invoker.ApiClient;

@Configuration
public class IFoodApisConfiguration {

	@Autowired
	private ApiClient apiClient;

	@Bean
	public AuthApi authApi() {
		return new AuthApi(apiClient);
	}

	@Bean
	public ProductsApi productsApi() {
		return new ProductsApi(apiClient);
	}

	@Bean
	public EventsApi eventsApi() {
		return new EventsApi(apiClient);
	}

	@Bean
	public OrdersApi ordersApi() {
		return new OrdersApi(apiClient);
	}

}
