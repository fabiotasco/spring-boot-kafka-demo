
package io.fab.connector.configurations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.fab.connector.data.CatalogEventType;
import io.fab.connector.processors.CatalogEventProcessorStrategy;
import io.fab.connector.processors.OrderUpdateEventProcessorStrategy;
import io.fab.connector.processors.PriceUpdateEventProcessorStrategy;
import io.fab.connector.processors.StockUpdateEventProcessorStrategy;

/**
 * Configuração das estratégias de processamento dos eventos do catálogo.
 *
 * @author fabio.tasco
 */
@Configuration
public class CatalogEventProcessorStrategyConfiguration {

	@Autowired
	private StockUpdateEventProcessorStrategy stockUpdateEventProcessorStrategy;

	@Autowired
	private PriceUpdateEventProcessorStrategy priceUpdateEventProcessorStrategy;

	@Autowired
	private OrderUpdateEventProcessorStrategy orderUpdateEventProcessorStrategy;

	@Bean
	public Map<CatalogEventType, CatalogEventProcessorStrategy> strategiesMap() {
		final Map<CatalogEventType, CatalogEventProcessorStrategy> strategiesMap = new HashMap<>(2);

		strategiesMap.put(CatalogEventType.STOCK_UPDATE, stockUpdateEventProcessorStrategy);
		strategiesMap.put(CatalogEventType.PRICE_UPDATE, priceUpdateEventProcessorStrategy);
		strategiesMap.put(CatalogEventType.ORDER_UPDATE, orderUpdateEventProcessorStrategy);

		return strategiesMap;
	}

}
