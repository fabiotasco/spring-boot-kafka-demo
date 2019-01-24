
package io.fab.connector.data;

import java.io.Serializable;

public class SupplierDelivery implements Serializable {

	private static final long serialVersionUID = 7587063469810680533L;

	private Integer timeframe;
	private SupplierPurchase purchase;

	SupplierDelivery() {}

	public SupplierDelivery(final Integer timeframe, final SupplierPurchase purchase) {
		this.timeframe = timeframe;
		this.purchase = purchase;
	}

	public Integer getTimeframe() {
		return timeframe;
	}

	public SupplierPurchase getPurchase() {
		return purchase;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (purchase == null ? 0 : purchase.hashCode());
		result = prime * result + (timeframe == null ? 0 : timeframe.hashCode());
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
		final SupplierDelivery other = (SupplierDelivery) obj;
		if (purchase == null) {
			if (other.purchase != null) {
				return false;
			}
		} else if (!purchase.equals(other.purchase)) {
			return false;
		}
		if (timeframe == null) {
			if (other.timeframe != null) {
				return false;
			}
		} else if (!timeframe.equals(other.timeframe)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SupplierDelivery [timeframe=" + timeframe + ", purchase=" + purchase + "]";
	}

}
