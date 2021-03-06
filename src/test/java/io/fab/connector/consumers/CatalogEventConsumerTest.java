
package io.fab.connector.consumers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import io.fab.connector.data.CatalogEventMessage;
import io.fab.connector.data.Event;
import io.fab.connector.data.EventType;
import io.fab.connector.data.Product;
import io.fab.connector.data.Source;
import io.fab.connector.data.Stock;
import io.fab.connector.producers.CatalogEventProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class CatalogEventConsumerTest {

	@Autowired
	private CatalogEventProducer sender;

	@Autowired
	private CatalogEventConsumer consumer;

	@ClassRule
	public static EmbeddedKafkaRule embeddedKafkaRule = new EmbeddedKafkaRule(1, true, "test.t");

	@Test
	public void testReceive() throws Exception {
		sender.produce(createMessage());

		consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
		assertThat(consumer.getLatch().getCount()).isEqualTo(0);
	}

	private CatalogEventMessage createMessage() {
		return new CatalogEventMessage(
			new Product("12345678", "Teste", null, null, new Stock(100, 0, null), null, null, null, null, null, null),
			new Event(UUID.randomUUID().toString(), EventType.PRODUCT_STOCK_UPDATE, new Date()),
			Source.GAVETEIRO);
	}

}
