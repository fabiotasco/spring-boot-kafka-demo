
package io.fab.connector.converters;

import org.springframework.stereotype.Component;

import br.com.gaveteiro.ifood.client.model.ProductStock;
import io.fab.connector.data.Product;

@Component
public class ProductStockConverter {

	public ProductStock toProductStock(final Product product) {
		final ProductStock productStock = new ProductStock();

		if (product != null && product.getStock() != null) {
			productStock.setStock(product.getStock().getQuantity());
			productStock.setStockBeingHold(product.getStock().getReserved());
		}
		return productStock;
	}

}
