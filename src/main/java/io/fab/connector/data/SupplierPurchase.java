
package io.fab.connector.data;

import java.io.Serializable;
import java.util.Date;

public class SupplierPurchase implements Serializable {

	private static final long serialVersionUID = 1878312222280643823L;

	private Date date;
	private Integer quantity;

	SupplierPurchase() {}

	public SupplierPurchase(final Date date, final Integer quantity) {
		this.date = date;
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public Integer getQuantity() {
		return quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (date == null ? 0 : date.hashCode());
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
		final SupplierPurchase other = (SupplierPurchase) obj;
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
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
		return "SupplierPurchase [date=" + date + ", quantity=" + quantity + "]";
	}

}
