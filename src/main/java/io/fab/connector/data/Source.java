
package io.fab.connector.data;

import com.fasterxml.jackson.annotation.JsonValue;

import io.fab.connector.utils.JsonUtils;

public enum Source {

	GAVETEIRO,
	NEI,
	IFOOD;

	@JsonValue
	public String toJsonValue() {
		return JsonUtils.formatEnumName(name());
	}

}
