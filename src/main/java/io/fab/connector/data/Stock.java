
package io.fab.connector.data;

import java.io.Serializable;

public class Stock implements Serializable {

	private static final long serialVersionUID = -3711011883307433085L;

	private Integer quantity;

	Stock() {}

	public Stock(final Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (quantity == null ? 0 : quantity.hashCode());
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
		final Stock other = (Stock) obj;
		if (quantity == null) {
			if (other.quantity != null) {
				return false;
			}
		} else if (!quantity.equals(other.quantity)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Stock [quantity=" + quantity + "]";
	}

}
