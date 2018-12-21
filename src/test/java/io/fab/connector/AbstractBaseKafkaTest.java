
package io.fab.connector;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import io.fab.connector.consumers.CatalogEventConsumer;
import io.fab.connector.data.Brand;
import io.fab.connector.data.CatalogEvent;
import io.fab.connector.data.CatalogEventMessage;
import io.fab.connector.data.CatalogEventType;
import io.fab.connector.data.Manufacturer;
import io.fab.connector.data.Package;
import io.fab.connector.data.Photo;
import io.fab.connector.data.Price;
import io.fab.connector.data.Product;
import io.fab.connector.data.Source;
import io.fab.connector.data.Stock;
import io.fab.connector.producers.CatalogEventProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public abstract class AbstractBaseKafkaTest {

	@Autowired
	protected CatalogEventProducer producer;

	@Autowired
	protected CatalogEventConsumer consumer;

	@ClassRule
	public static EmbeddedKafkaRule embeddedKafkaRule = new EmbeddedKafkaRule(1, true, "test.t");

	protected CatalogEventMessage buildBaseCatalogEventMessage(final CatalogEventType catalogEventType) {
		final String sku = "0085300076";
		final String name = "CHAVE DE IMPACTO PNEUMATICA 1/2\" 66KGFM";
		final String description
			= "A Chave impacto pneumática Puma AT-2810/16 possui movimento rotativo com golpes ampliados.";

		final Price price = new Price(534.11, 534.11);

		final Stock stock = new Stock(500);

		final Package pack = new Package(2.81, 0.20, 0.70, 0.18);

		final Brand brand = new Brand("PUMA");

		final Manufacturer manufacturer = new Manufacturer("AT-2810/16", "00811571013579");

		final Photo photo = new Photo(
			"https://res-2.cloudinary.com/gaveteiro/image/upload/c_pad,h_283,w_283/v1498683102/z0qo3xvdnj5sytuzfzk9.jpg");

		final Product product = new Product(sku, name, description, price, stock, pack, brand, manufacturer, photo);

		final CatalogEvent event = new CatalogEvent(catalogEventType, null);

		final Source source = Source.GAVETEIRO;

		return new CatalogEventMessage(product, event, source);
	}

}