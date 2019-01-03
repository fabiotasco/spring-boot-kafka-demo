
package io.fab.connector.data;

import com.fasterxml.jackson.annotation.JsonValue;

import io.fab.connector.utils.JsonUtils;

/**
 * Tipos de eventos do catálogo.
 *
 * @author fabio.tasco
 */
public enum EventType {

	STOCK_UPDATE,
	PRICE_UPDATE,
	ORDER_UPDATE,
	GET_PRODUCT_PRICE;

	@JsonValue
	public String toJsonValue() {
		return JsonUtils.formatEnumName(name());
	}

}
