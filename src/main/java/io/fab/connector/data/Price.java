
package io.fab.connector.data;

import java.io.Serializable;

public class Price implements Serializable {

	private static final long serialVersionUID = 2276219524999466173L;

	private Double amount;

	Price() {}

	public Price(final Double amount) {
		this.amount = amount;
	}

	public Double getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (amount == null ? 0 : amount.hashCode());
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
		if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Price [amount=" + amount + "]";
	}

}
