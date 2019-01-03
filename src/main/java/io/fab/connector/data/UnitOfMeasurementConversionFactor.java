
package io.fab.connector.data;

import java.io.Serializable;

public class UnitOfMeasurementConversionFactor implements Serializable {

	private static final long serialVersionUID = 7749361954777540612L;

	private Integer order;
	private Integer unit;
	private UnitOfMeasurementType type;

	UnitOfMeasurementConversionFactor() {}

	public UnitOfMeasurementConversionFactor(
		final Integer order,
		final Integer unit,
		final UnitOfMeasurementType type) {
		this.order = order;
		this.unit = unit;
		this.type = type;
	}

	public Integer getOrder() {
		return order;
	}

	public Integer getUnit() {
		return unit;
	}

	public UnitOfMeasurementType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (type == null ? 0 : type.hashCode());
		result = prime * result + (unit == null ? 0 : unit.hashCode());
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
		if (unit == null) {
			if (other.unit != null) {
				return false;
			}
		} else if (!unit.equals(other.unit)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "UnitOfMeasurementConversionFactor [order=" + order + ", unit=" + unit + ", type=" + type + "]";
	}

}
