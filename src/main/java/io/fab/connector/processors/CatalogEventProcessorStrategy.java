
package io.fab.connector.processors;

import io.fab.connector.data.CatalogEventMessage;

/**
 * Estratégia de processamento de eventos.
 *
 * @author fabio.tasco
 */
public interface CatalogEventProcessorStrategy {

	void processCatalogEvent(CatalogEventMessage message);

}
