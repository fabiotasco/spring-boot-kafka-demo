
package io.fab.connector.converters;

import org.springframework.stereotype.Component;

import br.com.gaveteiro.ifood.client.model.ProductPrice;
import io.fab.connector.data.Product;
import io.fab.connector.utils.CurrencyUtils;

@Component
public class ProductPriceConverter {

	public ProductPrice toProductPrice(final Product product) {
		final ProductPrice productPrice = new ProductPrice();

		if (product != null) {
			if (product.getPrice() != null) {
				productPrice.setPrice(CurrencyUtils.toLong(product.getPrice().getAmount()));
			}
			if (product.getStock() != null) {
				productPrice.setMaximumOrderQuantity(product.getStock().getQuantity());
			}
		}
		return productPrice;
	}

}
