
package io.fab.connector.data;

import java.io.Serializable;

public class Photo implements Serializable {

	private static final long serialVersionUID = 7364130265431083844L;

	private String url;

	Photo() {}

	public Photo(final String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (url == null ? 0 : url.hashCode());
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
		final Photo other = (Photo) obj;
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Photo [url=" + url + "]";
	}

}
