
package io.fab.connector.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.fab.connector.data.CatalogEventMessage;
import io.fab.connector.producers.CatalogEventProducer;

/**
 * Controller somente utilizado para fins de testes de envio de mensagens para o tópico do Kafka.
 *
 * @author fabio.tasco
 */
@RestController
public class DummyController {

	@Autowired
	private CatalogEventProducer catalogEventProducer;

	@PostMapping("/produce")
	public ResponseEntity<Void> produce(@RequestBody final CatalogEventMessage message) {
		catalogEventProducer.produce(message);
		return ResponseEntity.ok().build();
	}

}
