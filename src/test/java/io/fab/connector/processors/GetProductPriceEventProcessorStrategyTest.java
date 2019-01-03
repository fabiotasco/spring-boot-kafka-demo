
package io.fab.connector.processors;

import org.junit.Test;

import io.fab.connector.AbstractBaseKafkaTest;
import io.fab.connector.data.EventType;

public class GetProductPriceEventProcessorStrategyTest extends AbstractBaseKafkaTest {

	@Test
	public void testEventProcessment() {
		producer.produce(buildBaseCatalogEventMessage(EventType.GET_PRODUCT_PRICE));
	}

}
