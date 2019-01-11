
package io.fab.connector.converters;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gaveteiro.ifood.client.model.ProductPrice;
import io.fab.connector.data.Price;
import io.fab.connector.data.Product;
import io.fab.connector.data.Stock;

/**
 * Testes da conversão para um preço de produto do iFood.
 *
 * @author fabio.tasco
 * @see ProductPriceConverter
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductPriceConverterTest {

	@Autowired
	private ProductPriceConverter converter;

	@Test
	public void testSuccessfulConversion() {
		final Price price = new Price(0.00);
		final Stock stock = new Stock(0, 0);
		final Product product = createProduct(price, stock);

		final ProductPrice productPrice = converter.toProductPrice(product);

		assertNotNull(productPrice);
		assertNotNull(productPrice.getPrice());
		assertNotNull(productPrice.getMaximumOrderQuantity());
	}

	@Test
	public void testNullProduct() {
		final Product product = null;
		final ProductPrice productPrice = converter.toProductPrice(product);

		assertNotNull(productPrice);
		assertNull(productPrice.getPrice());
		assertNull(productPrice.getMaximumOrderQuantity());
	}

	@Test
	public void testNullPrice() {
		final Price price = null;
		final Stock stock = new Stock(0, 0);

		final Product product = createProduct(price, stock);

		final ProductPrice productPrice = converter.toProductPrice(product);

		assertNotNull(productPrice);
		assertNull(productPrice.getPrice());
		assertNotNull(productPrice.getMaximumOrderQuantity());
	}

	@Test
	public void testNullStock() {
		final Price price = new Price(0.00);
		final Stock stock = null;

		final Product product = createProduct(price, stock);

		final ProductPrice productPrice = converter.toProductPrice(product);

		assertNotNull(productPrice);
		assertNotNull(productPrice.getPrice());
		assertNull(productPrice.getMaximumOrderQuantity());
	}

	private Product createProduct(final Price price, final Stock stock) {
		return new Product(null, null, null, price, stock, null, null, null, null, null);
	}

}
