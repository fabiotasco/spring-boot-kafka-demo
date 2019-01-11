
package io.fab.connector.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Testes da classe utilitária para JSON.
 *
 * @author fabio.tasco
 * @see JsonUtils
 */
public class JsonUtilsTest {

	@Test
	public void testFormatSingleName() {
		final String formatted = JsonUtils.formatEnumName("SINGLE");
		assertEquals("Single", formatted);
	}

	@Test
	public void testFormatCompositeName() {
		final String formatted = JsonUtils.formatEnumName("COMPOSITE_NAME");
		assertEquals("Composite Name", formatted);
	}

	@Test
	public void testFormatTripleName() {
		final String formatted = JsonUtils.formatEnumName("THE_TRIPLE_NAME");
		assertEquals("The Triple Name", formatted);
	}

	@Test
	public void testNullName() {
		final String formatted = JsonUtils.formatEnumName(null);
		assertNull(formatted);
	}

	@Test
	public void testEmptyName() {
		final String formatted = JsonUtils.formatEnumName("");
		assertEquals("", formatted);
	}

}
