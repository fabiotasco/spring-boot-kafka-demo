
package io.fab.connector.processors;

import org.junit.Test;

import io.fab.connector.AbstractBaseKafkaTest;
import io.fab.connector.data.EventType;

public class PriceUpdateEventProcessorStrategyTest extends AbstractBaseKafkaTest {

	@Test
	public void testEventProcessment() {
		producer.produce(buildBaseCatalogEventMessage(EventType.PRICE_UPDATE));
	}

}