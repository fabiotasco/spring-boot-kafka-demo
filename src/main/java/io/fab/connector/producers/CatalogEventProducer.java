
package io.fab.connector.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import io.fab.connector.data.CatalogEventMessage;

@Service
public class CatalogEventProducer {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogEventProducer.class);

	@Autowired
	private KafkaTemplate<String, CatalogEventMessage> kafkaTemplate;

	@Value("${app.kafka.topic.catalog-event}")
	private String catalogEventTopic;

	/**
	 * Envia uma mensagem para o Kafka.
	 *
	 * @param message Conteúdo da mensagem original.
	 */
	public void produce(final CatalogEventMessage catalogEventMessage) {
		LOG.debug("Sending message {} to topic {}.", catalogEventMessage, catalogEventTopic);
		kafkaTemplate.send(catalogEventTopic, catalogEventMessage);
	}

}
