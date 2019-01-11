
package io.fab.connector.processors;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.fab.connector.consumers.AbstractBaseKafkaTest;
import io.fab.connector.data.EventType;

public class PriceUpdateEventProcessorStrategyTest extends AbstractBaseKafkaTest {

	@Test
	public void testEventProcessment() throws Exception {
		producer.produce(buildBaseCatalogEventMessage(EventType.PRICE_UPDATE));
		assertTrue(assertThatMessageWasConsumed());
	}

}
