
package io.fab.connector.processors;

import org.springframework.stereotype.Component;

import io.fab.connector.data.CatalogEventMessage;

@Component
public class OrderDelayEventProcessorStrategy implements CatalogEventProcessorStrategy {

	@Override
	public void processCatalogEvent(final CatalogEventMessage message) {
		// TODO Auto-generated method stub

	}

}
