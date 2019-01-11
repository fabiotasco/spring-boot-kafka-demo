
package io.fab.connector.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import br.com.gaveteiro.ifood.client.api.OrdersApi;
import io.fab.connector.data.CatalogEventMessage;

@Component
public class OrderUpdateEventProcessorStrategy implements CatalogEventProcessorStrategy {

	private static final Logger LOG = LoggerFactory.getLogger(OrderUpdateEventProcessorStrategy.class);

	@Autowired
	private OrdersApi ordersApi;

	@Override
	public void processCatalogEvent(final CatalogEventMessage message) {
		try {
			// FIXME: Não pode enviar null!
			ordersApi.updateOrderStatus(null, null);

		} catch (final RestClientException e) {
			LOG.error("Error while updating order from message {}", message, e);
		}
	}

}
