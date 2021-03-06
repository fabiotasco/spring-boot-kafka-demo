
package io.fab.connector.configurations;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.fab.connector.data.EventType;
import io.fab.connector.processors.CatalogEventProcessorStrategy;
import io.fab.connector.processors.OrderDelayEventProcessorStrategy;
import io.fab.connector.processors.OrderUpdateEventProcessorStrategy;
import io.fab.connector.processors.PriceDeleteEventProcessorStrategy;
import io.fab.connector.processors.PriceUpdateEventProcessorStrategy;
import io.fab.connector.processors.StockUpdateEventProcessorStrategy;

/**
 * Configuração das estratégias de processamento dos eventos do catálogo.
 *
 * @author fabio.tasco
 */
@Configuration
public class CatalogEventProcessorStrategiesConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogEventProcessorStrategiesConfiguration.class);

	@Autowired
	private StockUpdateEventProcessorStrategy stockUpdateEventProcessorStrategy;

	@Autowired
	private PriceUpdateEventProcessorStrategy priceUpdateEventProcessorStrategy;

	@Autowired
	private PriceDeleteEventProcessorStrategy priceDeleteEventProcessorStrategy;

	@Autowired
	private OrderUpdateEventProcessorStrategy orderUpdateEventProcessorStrategy;

	@Autowired
	private OrderDelayEventProcessorStrategy orderDelayEventProcessorStrategy;

	@Bean
	public Map<EventType, CatalogEventProcessorStrategy> strategiesMap() {
		LOG.info("Mapping catalog events processor strategies...");
		final Map<EventType, CatalogEventProcessorStrategy> strategiesMap = new HashMap<>(EventType.values().length);

		addStrategy(strategiesMap, EventType.PRODUCT_STOCK_UPDATE, stockUpdateEventProcessorStrategy);
		addStrategy(strategiesMap, EventType.PRODUCT_PRICE_UPDATE, priceUpdateEventProcessorStrategy);
		addStrategy(strategiesMap, EventType.PRODUCT_PRICE_DELETE, priceDeleteEventProcessorStrategy);
		addStrategy(strategiesMap, EventType.ORDER_UPDATE, orderUpdateEventProcessorStrategy);
		addStrategy(strategiesMap, EventType.ORDER_DELAY, orderDelayEventProcessorStrategy);

		LOG.info("Strategies mapped successfully to a total of {}!", strategiesMap.size());

		return strategiesMap;
	}

	private void addStrategy(
		final Map<EventType, CatalogEventProcessorStrategy> strategiesMap,
		final EventType eventType,
		final CatalogEventProcessorStrategy strategy) {

		strategiesMap.put(eventType, strategy);
		LOG.info("Strategy {} mapped.", eventType);
	}

}
