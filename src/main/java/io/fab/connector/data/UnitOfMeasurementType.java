
package io.fab.connector.data;

import com.fasterxml.jackson.annotation.JsonValue;

import io.fab.connector.utils.JsonUtils;

public enum UnitOfMeasurementType {

	UNIT,
	PACKAGE,
	BOX,
	REAM;

	@JsonValue
	public String toJsonValue() {
		return JsonUtils.formatEnumName(name());
	}

}
