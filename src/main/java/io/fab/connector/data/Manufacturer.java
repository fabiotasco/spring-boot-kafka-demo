
package io.fab.connector.data;

import java.io.Serializable;

public class Manufacturer implements Serializable {

	private static final long serialVersionUID = -210819886125613580L;

	private String code;
	private String barCode;

	Manufacturer() {}

	public Manufacturer(final String code, final String barCode) {
		this.code = code;
		this.barCode = barCode;
	}

	public String getCode() {
		return code;
	}

	public String getBarCode() {
		return barCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (barCode == null ? 0 : barCode.hashCode());
		result = prime * result + (code == null ? 0 : code.hashCode());
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
		final Manufacturer other = (Manufacturer) obj;
		if (barCode == null) {
			if (other.barCode != null) {
				return false;
			}
		} else if (!barCode.equals(other.barCode)) {
			return false;
		}
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Manufacturer [code=" + code + ", barCode=" + barCode + "]";
	}

}
