
package io.fab.connector.data;

import java.io.Serializable;

public class UnitOfMeasurementConversionFactor implements Serializable {

	private static final long serialVersionUID = 7749361954777540612L;

	private Integer order;
	private Integer value;
	private UnitOfMeasurementType type;

	UnitOfMeasurementConversionFactor() {}

	public UnitOfMeasurementConversionFactor(
		final Integer order,
		final Integer value,
		final UnitOfMeasurementType type) {
		this.order = order;
		this.value = value;
		this.type = type;
	}

	public Integer getOrder() {
		return order;
	}

	public Integer getValue() {
		return value;
	}

	public UnitOfMeasurementType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (type == null ? 0 : type.hashCode());
		result = prime * result + (value == null ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final UnitOfMeasurementConversionFactor other = (UnitOfMeasurementConversionFactor) obj;
		if (type != other.type) {
			return false;
		}
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "UnitOfMeasurementConversionFactor [order=" + order + ", value=" + value + ", type=" + type + "]";
	}

}
