
package io.fab.connector.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import io.fab.connector.rules.SyncOrderRules;

@Service
public class SyncOrderTask {

	private static final Logger LOG = LoggerFactory.getLogger(SyncOrderTask.class);

	@Autowired
	private SyncOrderRules syncOrderRules;

	@Scheduled(cron = "${app.ifood.tasks.sync-order.cron}")
	public void run() {
		try {
			syncOrderRules.sync();
		} catch (final Exception e) {
			LOG.error("Error while syncing iFood orders!", e);
		}
	}

}
