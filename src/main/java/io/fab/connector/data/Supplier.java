
package io.fab.connector.data;

import java.io.Serializable;

public class Supplier implements Serializable {

	private static final long serialVersionUID = -7686183058415712239L;

	private SupplierType name;
	private String productCode;
	private SupplierDelivery delivery;

	Supplier() {}

	public Supplier(final SupplierType name, final String productCode, final SupplierDelivery delivery) {
		this.name = name;
		this.productCode = productCode;
		this.delivery = delivery;
	}

	public SupplierType getName() {
		return name;
	}

	public String getProductCode() {
		return productCode;
	}

	public SupplierDelivery getDelivery() {
		return delivery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (delivery == null ? 0 : delivery.hashCode());
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + (productCode == null ? 0 : productCode.hashCode());
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
		final Supplier other = (Supplier) obj;
		if (delivery == null) {
			if (other.delivery != null) {
				return false;
			}
		} else if (!delivery.equals(other.delivery)) {
			return false;
		}
		if (name != other.name) {
			return false;
		}
		if (productCode == null) {
			if (other.productCode != null) {
				return false;
			}
		} else if (!productCode.equals(other.productCode)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Supplier [name=" + name + ", productCode=" + productCode + ", delivery=" + delivery + "]";
	}

}
