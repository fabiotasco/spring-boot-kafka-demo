
package io.fab.connector.data;

import com.fasterxml.jackson.annotation.JsonValue;

import io.fab.connector.utils.JsonUtils;

/**
 * Tipos de eventos do catálogo.
 *
 * @author fabio.tasco
 */
public enum EventType {

	PRICE_UPDATE,
	PRICE_DELETE,
	STOCK_UPDATE,
	ORDER_UPDATE,
	ORDER_DELAY,
	UNKNOWN;

	@JsonValue
	public String toJsonValue() {
		return JsonUtils.formatEnumName(name());
	}

}
