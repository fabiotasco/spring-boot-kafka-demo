
package io.fab.connector.processors;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import br.com.gaveteiro.ifood.client.api.ProductsApi;
import br.com.gaveteiro.ifood.client.model.Product;
import io.fab.connector.data.CatalogEventMessage;

@Component
public class PriceDeleteEventProcessorStrategy implements CatalogEventProcessorStrategy {

	private static final Logger LOG = LoggerFactory.getLogger(PriceDeleteEventProcessorStrategy.class);

	@Autowired
	private ProductsApi productsApi;

	@Override
	public void processCatalogEvent(final CatalogEventMessage message) {
		try {
			final String sku = message.getProduct().getSku();
			final List<Product> products = productsApi.getPrices(sku);

			final Long priceId = products.get(0).getId();
			productsApi.deletePrice(sku, priceId);

		} catch (final RestClientException e) {
			LOG.error("Error while deleting price from {}", message, e);
		}
	}

}
