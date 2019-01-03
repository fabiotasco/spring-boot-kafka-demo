
package io.fab.connector.processors;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gaveteiro.ifood.client.api.ProductsApi;
import br.com.gaveteiro.ifood.client.model.Product;
import io.fab.connector.data.CatalogEventMessage;

@Component
public class GetProductPriceEventProcessorStrategy implements CatalogEventProcessorStrategy {

	private static final Logger LOG = LoggerFactory.getLogger(GetProductPriceEventProcessorStrategy.class);

	@Autowired
	private ProductsApi productsApi;

	@Override
	public void processCatalogEvent(final CatalogEventMessage message) {
		final List<Product> products = productsApi.getPricesUsingGET(message.getProduct().getSku());
		products.forEach(product -> LOG.debug(product.toString()));
		// TODO: Complementar a lógica!
	}

}
