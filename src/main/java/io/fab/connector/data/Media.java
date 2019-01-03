
package io.fab.connector.data;

import java.io.Serializable;

public class Media implements Serializable {

	private static final long serialVersionUID = 7364130265431083844L;

	private String link;

	Media() {}

	public Media(final String link) {
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (link == null ? 0 : link.hashCode());
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
		final Media other = (Media) obj;
		if (link == null) {
			if (other.link != null) {
				return false;
			}
		} else if (!link.equals(other.link)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Photo [link=" + link + "]";
	}

}
