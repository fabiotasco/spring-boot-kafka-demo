
package io.fab.connector.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class Event implements Serializable {

	private static final long serialVersionUID = 1362947731029899481L;

	private EventType type;
	private Map<String, Object> data;
	private Date createdAt;

	Event() {}

	public Event(final EventType type, final Map<String, Object> data, final Date createdAt) {
		this.type = type;
		this.data = data;
		this.createdAt = createdAt;
	}

	public EventType getType() {
		return type;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (createdAt == null ? 0 : createdAt.hashCode());
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
		final Event other = (Event) obj;
		if (createdAt == null) {
			if (other.createdAt != null) {
				return false;
			}
		} else if (!createdAt.equals(other.createdAt)) {
			return false;
		}
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
		return "Event [type=" + type + ", data=" + data + ", createdAt=" + createdAt + "]";
	}

}
