
package io.fab.connector.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gaveteiro.ifood.client.api.EventsApi;
import br.com.gaveteiro.ifood.client.api.OrdersApi;
import br.com.gaveteiro.ifood.client.model.Order;
import br.com.gaveteiro.ifood.client.model.OrdersReference;
import br.com.gaveteiro.ifood.client.model.PageImplOrdersReference;

@Component
public class SyncOrderRules {

	private static final Logger LOG = LoggerFactory.getLogger(SyncOrderRules.class);

	@Autowired
	private AuthenticationRules authenticationRules;

	@Autowired
	private EventsApi eventsApi;

	@Autowired
	private OrdersApi ordersApi;

	public void sync() {
		authenticationRules.loadIFoodApiAccessToken();

		int page = 0;
		boolean isLastPage = false;
		while (!isLastPage) {
			final PageImplOrdersReference pageOrdersReference = eventsApi.getEvents(page);

			if (hasOrders(pageOrdersReference)) {
				pageOrdersReference.getContent().forEach(orderReference -> fetchOrderDetails(orderReference));
			} else {
				LOG.warn("No events were found at iFood!");
			}

			isLastPage = pageOrdersReference.isLast();
			page++;
		}
	}

	private boolean hasOrders(final PageImplOrdersReference pageOrdersReference) {
		return pageOrdersReference != null && pageOrdersReference.getContent() != null;
	}

	private void fetchOrderDetails(final OrdersReference orderReference) {
		// Definir o que fazer quando for boleto e quando for cartão
		// Definir o que fazer quando estiver aguardando pagamento
		// Definir quando estiver pago
		// Definir quando for cancelado
		final Order order = ordersApi.getOrder(orderReference.getNumber());
		LOG.info("### New Order ###");
		LOG.info(order.toString());
		LOG.info("\n\n\n\n\n");

		// TODO: Acknowledge the event
	}

}
