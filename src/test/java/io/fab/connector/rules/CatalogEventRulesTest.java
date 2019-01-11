
package io.fab.connector.rules;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.fab.connector.data.CatalogEventMessage;
import io.fab.connector.data.Event;
import io.fab.connector.data.EventType;

/**
 * @author fabio.tasco
 * @see CatalogEventRules
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CatalogEventRulesTest {

	@Autowired
	private CatalogEventRules catalogEventRules;

	@Test(expected = IllegalArgumentException.class)
	public void testUnknownStrategy() {
		final CatalogEventMessage message
			= new CatalogEventMessage(null, new Event(null, EventType.UNKNOWN, null), null);
		catalogEventRules.processMessage(message);
	}

}
