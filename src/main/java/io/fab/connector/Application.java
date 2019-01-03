
package io.fab.connector;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.fab.connector.data.Brand;
import io.fab.connector.data.CatalogEventMessage;
import io.fab.connector.data.Event;
import io.fab.connector.data.EventType;
import io.fab.connector.data.Manufacturer;
import io.fab.connector.data.Package;
import io.fab.connector.data.Photo;
import io.fab.connector.data.Price;
import io.fab.connector.data.Product;
import io.fab.connector.data.Source;
import io.fab.connector.data.Stock;
import io.fab.connector.producers.CatalogEventProducer;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private CatalogEventProducer producer;

	@Override
	public void run(final String... args) throws Exception {
		final CatalogEventMessage message = buildBaseCatalogEventMessage(EventType.GET_PRODUCT_PRICE);
		producer.produce(message);

		message.getProduct().setSku("4321");
		producer.produce(message);
	}

	protected CatalogEventMessage buildBaseCatalogEventMessage(final EventType catalogEventType) {
		final String sku = "1234";
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

		final Event event = new Event(catalogEventType, null, new Date());

		final Source source = Source.GAVETEIRO;

		return new CatalogEventMessage(product, event, source);
	}

}
