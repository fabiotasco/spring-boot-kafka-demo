
package io.fab.connector.processors;

import org.junit.Test;

import io.fab.connector.AbstractBaseKafkaTest;
import io.fab.connector.data.CatalogEventType;

public class PriceUpdateEventProcessorStrategyTest extends AbstractBaseKafkaTest {

	@Test
	public void testEventProcessment() {
		producer.produce(buildBaseCatalogEventMessage(CatalogEventType.PRICE_UPDATE));
	}

}
