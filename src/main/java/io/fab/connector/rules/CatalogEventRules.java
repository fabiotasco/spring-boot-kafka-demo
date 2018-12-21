
package io.fab.connector.rules;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.fab.connector.data.CatalogEventMessage;
import io.fab.connector.data.CatalogEventType;
import io.fab.connector.processors.CatalogEventProcessorStrategy;

@Component
public class CatalogEventRules {

	@Autowired
	private Map<CatalogEventType, CatalogEventProcessorStrategy> strategiesMap;

	public void processMessage(final CatalogEventMessage message) {
		final CatalogEventProcessorStrategy strategy = findStrategy(message.getEvent().getType());
		strategy.processCatalogEvent(message);
	}

	private CatalogEventProcessorStrategy findStrategy(final CatalogEventType type) {
		return strategiesMap.entrySet()
			.parallelStream()
			.filter(entry -> entry.getKey() == type)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("Catalog event unknown: " + type))
			.getValue();
	}

}
