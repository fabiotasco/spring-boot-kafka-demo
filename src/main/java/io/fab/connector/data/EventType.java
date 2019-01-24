
package io.fab.connector.data;

import com.fasterxml.jackson.annotation.JsonValue;

import io.fab.connector.utils.JsonUtils;

/**
 * Tipos de eventos do catálogo.
 *
 * @author fabio.tasco
 */
public enum EventType {

	PRODUCT_PRICE_UPDATE,
	PRODUCT_PRICE_DELETE,
	PRODUCT_STOCK_UPDATE,
	PRODUCT_STATUS_UPDATE,
	ORDER_UPDATE,
	ORDER_DELAY,
	UNKNOWN;

	@JsonValue
	public String toJsonValue() {
		return JsonUtils.formatEnumName(name());
	}

}
