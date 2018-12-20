
package io.fab.connector.data;

import java.io.Serializable;

public class Price implements Serializable {

	private static final long serialVersionUID = 2276219524999466173L;

	private Double unit;
	private Double total;

	Price() {}

	public Price(final Double unit, final Double total) {
		this.unit = unit;
		this.total = total;
	}

	public Double getUnit() {
		return unit;
	}

	public Double getTotal() {
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (total == null ? 0 : total.hashCode());
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
		final Price other = (Price) obj;
		if (total == null) {
			if (other.total != null) {
				return false;
			}
		} else if (!total.equals(other.total)) {
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
		return "Price [unit=" + unit + ", total=" + total + "]";
	}

}
