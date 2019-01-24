
package io.fab.connector.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.gaveteiro.ifood.client.api.EventsApi;
import br.com.gaveteiro.ifood.client.model.OrdersReference;
import br.com.gaveteiro.ifood.client.model.PageImplOrdersReference;
import io.fab.connector.rules.IFoodAuthenticationRules;

@Service
public class IFoodEventListenerTask {

	private static final Logger LOG = LoggerFactory.getLogger(IFoodEventListenerTask.class);

	@Autowired
	private IFoodAuthenticationRules authenticationRules;

	@Autowired
	private EventsApi eventsApi;

	@Scheduled(cron = "${app.ifood.tasks.event-listener.cron}")
	public void run() {
		authenticationRules.loadIFoodApiAccessToken();

		final int page = 0;
		final PageImplOrdersReference events = eventsApi.getEvents(page);
		if (events == null || events.getContent() == null || events.getContent().isEmpty()) {
			LOG.warn("Resultado vazio!");
		}
		for (final OrdersReference orderReference : events.getContent()) {
			LOG.info("Order: {}", orderReference.getId());
		}
	}

}
