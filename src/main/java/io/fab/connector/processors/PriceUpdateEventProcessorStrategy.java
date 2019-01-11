
package io.fab.connector.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import br.com.gaveteiro.ifood.client.api.ProductsApi;
import br.com.gaveteiro.ifood.client.model.ProductPrice;
import io.fab.connector.converters.ProductPriceConverter;
import io.fab.connector.data.CatalogEventMessage;

@Component
public class PriceUpdateEventProcessorStrategy implements CatalogEventProcessorStrategy {

	private static final Logger LOG = LoggerFactory.getLogger(PriceUpdateEventProcessorStrategy.class);

	private static final Integer MINIMUM_ORDER_QUANTITY = 1;

	@Autowired
	private ProductPriceConverter productPriceConverter;

	@Autowired
	private ProductsApi productsApi;

	@Override
	public void processCatalogEvent(final CatalogEventMessage message) {
		try {
			final String sku = message.getProduct().getSku();
			final ProductPrice productPrice = productPriceConverter.toProductPrice(message.getProduct());

			productsApi.updatePrice(sku, MINIMUM_ORDER_QUANTITY, productPrice);

		} catch (final RestClientException e) {
			LOG.error("Error while deleting price from message {}", message, e);
		}

	}

}
