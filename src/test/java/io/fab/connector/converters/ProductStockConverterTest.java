
package io.fab.connector.converters;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gaveteiro.ifood.client.model.ProductStock;
import io.fab.connector.data.Product;
import io.fab.connector.data.Stock;

/**
 * Testes da conversão para um stoque de produto do iFood.
 *
 * @author fabio.tasco
 * @see ProductStockConverter
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductStockConverterTest {

	@Autowired
	private ProductStockConverter productStockConverter;

	@Test
	public void testSuccessfulConversion() {
		final Stock stock = new Stock(0, 0);
		final Product product = createProduct(stock);
		final ProductStock productStock = productStockConverter.toProductStock(product);

		assertNotNull(productStock);
		assertNotNull(productStock.getStock());
		assertNotNull(productStock.getStockBeingHold());
	}

	@Test
	public void testNullProduct() {
		final Product product = null;
		final ProductStock productStock = productStockConverter.toProductStock(product);

		assertNotNull(productStock);
		assertNull(productStock.getStock());
		assertNull(productStock.getStockBeingHold());
	}

	@Test
	public void testNullStock() {
		final Stock stock = null;
		final Product product = createProduct(stock);
		final ProductStock productStock = productStockConverter.toProductStock(product);

		assertNotNull(productStock);
		assertNull(productStock.getStock());
		assertNull(productStock.getStockBeingHold());
	}

	private Product createProduct(final Stock stock) {
		return new Product(null, null, null, null, stock, null, null, null, null, null);
	}

}
