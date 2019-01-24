
package io.fab.connector.data;

import com.fasterxml.jackson.annotation.JsonValue;

import io.fab.connector.utils.JsonUtils;

public enum ProductStatus {

	PROVISORY, // Situação não identificada
	ACTIVE, // Ativo
	ON_DEMAND, // Sob Encomenda
	DISCONTINUED, // Saindo de Linha
	DROP_SHIPPING, // Drop Shipping
	INACTIVE, // Inativo
	OTHER, // Outros
	TEMPORARILY_UNAVAILABLE, // Temporariamente Indisponivel
	ERROR, // Erro Cadastro
	INTERNAL_SALE, // Venda Interna
	CLEARANCE_SALE; // Queima de Estoque

	@JsonValue
	public String toJsonValue() {
		return JsonUtils.formatEnumName(name());
	}

}
