
package io.fab.connector;

import java.util.Arrays;
import java.util.Date;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import io.fab.connector.consumers.CatalogEventConsumer;
import io.fab.connector.data.Brand;
import io.fab.connector.data.CatalogEventMessage;
import io.fab.connector.data.Event;
import io.fab.connector.data.EventType;
import io.fab.connector.data.Manufacturer;
import io.fab.connector.data.Media;
import io.fab.connector.data.Package;
import io.fab.connector.data.Price;
import io.fab.connector.data.Product;
import io.fab.connector.data.Source;
import io.fab.connector.data.Stock;
import io.fab.connector.data.UnitOfMeasurement;
import io.fab.connector.data.UnitOfMeasurementConversionFactor;
import io.fab.connector.data.UnitOfMeasurementType;
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

	protected CatalogEventMessage buildBaseCatalogEventMessage(final EventType catalogEventType) {
		final String sku = "1234";
		final String name = "CHAVE DE IMPACTO PNEUMATICA 1/2\" 66KGFM";
		final String description
			= "A Chave impacto pneumática Puma AT-2810/16 possui movimento rotativo com golpes ampliados.";

		final Price price = new Price(534.11, 534.11);

		final Stock stock = new Stock(500, 10);

		final Package pack = new Package(2.81, 0.20, 0.70, 0.18);

		final UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement(
			1,
			UnitOfMeasurementType.UNIT,
			Arrays.asList(new UnitOfMeasurementConversionFactor[] {
				new UnitOfMeasurementConversionFactor(1, 50, UnitOfMeasurementType.PACKAGE),
				new UnitOfMeasurementConversionFactor(2, 100, UnitOfMeasurementType.BOX) }));

		final Brand brand = new Brand("PUMA");

		final Manufacturer manufacturer = new Manufacturer("AT-2810/16", null, "00811571013579");

		final Media media = new Media(
			"https://res-2.cloudinary.com/gaveteiro/image/upload/c_pad,h_283,w_283/v1498683102/z0qo3xvdnj5sytuzfzk9.jpg");

		final Product product
			= new Product(sku, name, description, price, stock, pack, unitOfMeasurement, brand, manufacturer, media);

		final Event event = new Event(catalogEventType, null, new Date());

		final Source source = Source.GAVETEIRO;

		return new CatalogEventMessage(product, event, source);
	}

}
