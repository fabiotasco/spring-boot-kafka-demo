
package io.fab.connector.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import br.com.gaveteiro.ifood.client.api.ProductsApi;
import br.com.gaveteiro.ifood.client.model.ProductStock;
import io.fab.connector.converters.ProductStockConverter;
import io.fab.connector.data.CatalogEventMessage;

@Component
public class StockUpdateEventProcessorStrategy implements CatalogEventProcessorStrategy {

	private static final Logger LOG = LoggerFactory.getLogger(StockUpdateEventProcessorStrategy.class);

	@Autowired
	private ProductStockConverter productStockConverter;

	@Autowired
	private ProductsApi productsApi;

	@Override
	public void processCatalogEvent(final CatalogEventMessage message) {
		try {
			final ProductStock productStock = productStockConverter.toProductStock(message.getProduct());
			final String sku = message.getProduct().getSku();

			productsApi.updateStock(sku, productStock);

		} catch (final RestClientException e) {
			LOG.error("Error while updating stock from message {}.", message, e);
		}
	}

}
