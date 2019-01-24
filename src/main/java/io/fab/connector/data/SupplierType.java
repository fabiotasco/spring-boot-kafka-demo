
package io.fab.connector.data;

import com.fasterxml.jackson.annotation.JsonValue;

import io.fab.connector.utils.JsonUtils;

/**
 * Fornecedor.
 *
 * @author fabio.tasco
 */
public enum SupplierType {

	GAVETEIRO,
	CONSTRUJA,
	DUFRIO,
	ELETRICA_PJ,
	MC_TINTAS;

	@JsonValue
	public String toJsonValue() {
		return JsonUtils.formatEnumName(name());
	}

}
