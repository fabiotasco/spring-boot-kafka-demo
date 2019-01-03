
package io.fab.connector.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import br.com.gaveteiro.ifood.client.api.ProductsApi;
import br.com.gaveteiro.ifood.client.model.ProductStock;
import io.fab.connector.data.CatalogEventMessage;

@Component
public class StockUpdateEventProcessorStrategy implements CatalogEventProcessorStrategy {

	private static final Logger LOG = LoggerFactory.getLogger(StockUpdateEventProcessorStrategy.class);

	@Autowired
	private ProductsApi productsApi;

	@Override
	public void processCatalogEvent(final CatalogEventMessage message) {
		try {
			final ProductStock productStock = convertToProductStock(message);
			final String sku = message.getProduct().getSku();

			productsApi.updateProductStockUsingPATCH(sku, productStock);

		} catch (final RestClientException e) {
			LOG.error("Error while updating stock of {}.", message, e);
		}
	}

	private ProductStock convertToProductStock(final CatalogEventMessage message) {
		final ProductStock productStock = new ProductStock();

		productStock.setStock(message.getProduct().getStock().getQuantity());
		productStock.setStockBeingHold(message.getProduct().getStock().getReserved());

		return productStock;
	}

}
