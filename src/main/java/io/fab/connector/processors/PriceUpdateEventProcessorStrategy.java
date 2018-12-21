
package io.fab.connector.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gaveteiro.ifood.client.api.ProductsApi;
import br.com.gaveteiro.ifood.client.model.ProductPrice;
import io.fab.connector.data.CatalogEventMessage;
import io.fab.connector.utils.CurrencyUtils;

@Component
public class PriceUpdateEventProcessorStrategy implements CatalogEventProcessorStrategy {

	private static final Integer MINIMUM_ORDER_QUANTITY = 1;

	@Autowired
	private ProductsApi productsApi;

	@Override
	public void processCatalogEvent(final CatalogEventMessage message) {
		productsApi.updateProductPriceUsingPUT(message.getProduct().getSku(),
			MINIMUM_ORDER_QUANTITY,
			buildProductPrice(message));
	}

	private ProductPrice buildProductPrice(final CatalogEventMessage message) {
		final ProductPrice productPrice = new ProductPrice();
		productPrice.setPrice(CurrencyUtils.toLong(message.getProduct().getPrice().getTotal()));
		productPrice.setMaximumOrderQuantity(message.getProduct().getStock().getQuantity());

		return productPrice;
	}

}
