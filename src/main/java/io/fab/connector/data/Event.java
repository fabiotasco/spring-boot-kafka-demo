
package io.fab.connector.data;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {

	private static final long serialVersionUID = 1362947731029899481L;

	private String id;
	private EventType type;
	private Date createdAt;

	Event() {}

	public Event(final String id, final EventType type, final Date createdAt) {
		this.id = id;
		this.type = type;
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public EventType getType() {
		return type;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (createdAt == null ? 0 : createdAt.hashCode());
		result = prime * result + (id == null ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", type=" + type + ", createdAt=" + createdAt + "]";
	}

}
