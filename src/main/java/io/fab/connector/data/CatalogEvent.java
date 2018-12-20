
package io.fab.connector.data;

import java.io.Serializable;
import java.util.Map;

public class CatalogEvent implements Serializable {

	private static final long serialVersionUID = 1362947731029899481L;

	private CatalogEventType type;
	private Map<String, Object> data;

	CatalogEvent() {}

	public CatalogEvent(final CatalogEventType type, final Map<String, Object> data) {
		this.type = type;
		this.data = data;
	}

	public CatalogEventType getType() {
		return type;
	}

	public Map<String, Object> getData() {
		return data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (data == null ? 0 : data.hashCode());
		result = prime * result + (type == null ? 0 : type.hashCode());
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
		final CatalogEvent other = (CatalogEvent) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ProductEvent [type=" + type + ", data=" + data + "]";
	}

}
