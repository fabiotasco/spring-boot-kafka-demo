
package io.fab.connector.data;

import java.io.Serializable;
import java.util.List;

public class UnitOfMeasurement implements Serializable {

	private static final long serialVersionUID = 5218353807844929088L;

	private Integer baseUnit;
	private UnitOfMeasurementType baseType;
	private List<UnitOfMeasurementConversionFactor> conversionFactors;

	UnitOfMeasurement() {}

	public UnitOfMeasurement(
		final Integer baseUnit,
		final UnitOfMeasurementType baseType,
		final List<UnitOfMeasurementConversionFactor> conversionFactors) {
		this.baseUnit = baseUnit;
		this.baseType = baseType;
		this.conversionFactors = conversionFactors;
	}

	public Integer getBaseUnit() {
		return baseUnit;
	}

	public UnitOfMeasurementType getBaseType() {
		return baseType;
	}

	public List<UnitOfMeasurementConversionFactor> getConversionFactors() {
		return conversionFactors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (baseType == null ? 0 : baseType.hashCode());
		result = prime * result + (baseUnit == null ? 0 : baseUnit.hashCode());
		result = prime * result + (conversionFactors == null ? 0 : conversionFactors.hashCode());
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
		final UnitOfMeasurement other = (UnitOfMeasurement) obj;
		if (baseType != other.baseType) {
			return false;
		}
		if (baseUnit == null) {
			if (other.baseUnit != null) {
				return false;
			}
		} else if (!baseUnit.equals(other.baseUnit)) {
			return false;
		}
		if (conversionFactors == null) {
			if (other.conversionFactors != null) {
				return false;
			}
		} else if (!conversionFactors.equals(other.conversionFactors)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "UnitOfMeasurement [baseUnit=" + baseUnit
			+ ", baseType="
			+ baseType
			+ ", conversionFactors="
			+ conversionFactors
			+ "]";
	}

}
