
package io.fab.connector.data;

import java.io.Serializable;

public class Stock implements Serializable {

	private static final long serialVersionUID = -3711011883307433085L;

	private Integer quantity;
	private Integer reserved;
	private Supplier supplier;

	Stock() {}

	public Stock(final Integer quantity, final Integer reserved, final Supplier supplier) {
		this.quantity = quantity;
		this.reserved = reserved;
		this.supplier = supplier;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getReserved() {
		return reserved;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (quantity == null ? 0 : quantity.hashCode());
		result = prime * result + (reserved == null ? 0 : reserved.hashCode());
		result = prime * result + (supplier == null ? 0 : supplier.hashCode());
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
		if (supplier == null) {
			if (other.supplier != null) {
				return false;
			}
		} else if (!supplier.equals(other.supplier)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Stock [quantity=" + quantity + ", reserved=" + reserved + ", supplier=" + supplier + "]";
	}

}
