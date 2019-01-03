
package io.fab.connector.data;

import java.io.Serializable;

public class Stock implements Serializable {

	private static final long serialVersionUID = -3711011883307433085L;

	private Integer quantity;
	private Integer reserved;

	Stock() {}

	public Stock(final Integer quantity, final Integer reserved) {
		this.quantity = quantity;
		this.reserved = reserved;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getReserved() {
		return reserved;
	}

	public void setReserved(final Integer reserved) {
		this.reserved = reserved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (quantity == null ? 0 : quantity.hashCode());
		result = prime * result + (reserved == null ? 0 : reserved.hashCode());
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
		if (reserved == null) {
			if (other.reserved != null) {
				return false;
			}
		} else if (!reserved.equals(other.reserved)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Stock [quantity=" + quantity + ", reserved=" + reserved + "]";
	}

}
