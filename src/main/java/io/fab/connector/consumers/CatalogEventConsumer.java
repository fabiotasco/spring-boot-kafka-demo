
package io.fab.connector.consumers;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import io.fab.connector.data.CatalogEventMessage;

/**
 * Consome os eventos ocorridos no catálogo da Gaveteiro.
 *
 * @author fabio.tasco
 */
@Service
public class CatalogEventConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogEventConsumer.class);

	private final CountDownLatch latch = new CountDownLatch(1);

	/**
	 * Consome uma mensagem do Kafka.
	 *
	 * @param message Conteúdo da mensagem serializada.
	 */
	@KafkaListener(topics = "${app.kafka.topic.catalog-event}")
	public void consume(@Payload final CatalogEventMessage message) {
		LOG.debug("Consuming Gaveteito catalog event: {}", message);
		// TODO: Implementar regras de negócio!
		latch.countDown();
	}

	CountDownLatch getLatch() {
		return latch;
	}

}
