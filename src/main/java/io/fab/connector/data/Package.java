
package io.fab.connector.data;

import java.io.Serializable;

/**
 * Pacote do produto.
 *
 * @author fabio.tasco
 */
public class Package implements Serializable {

	private static final long serialVersionUID = 4668688365569552049L;

	private Double weigth;
	private Double height;
	private Double width;
	private Double depth;

	Package() {}

	public Package(final Double weigth, final Double height, final Double width, final Double depth) {
		this.weigth = weigth;
		this.height = height;
		this.width = width;
		this.depth = depth;
	}

	public Double getWeigth() {
		return weigth;
	}

	public Double getHeight() {
		return height;
	}

	public Double getWidth() {
		return width;
	}

	public Double getDepth() {
		return depth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (depth == null ? 0 : depth.hashCode());
		result = prime * result + (height == null ? 0 : height.hashCode());
		result = prime * result + (weigth == null ? 0 : weigth.hashCode());
		result = prime * result + (width == null ? 0 : width.hashCode());
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
		final Package other = (Package) obj;
		if (depth == null) {
			if (other.depth != null) {
				return false;
			}
		} else if (!depth.equals(other.depth)) {
			return false;
		}
		if (height == null) {
			if (other.height != null) {
				return false;
			}
		} else if (!height.equals(other.height)) {
			return false;
		}
		if (weigth == null) {
			if (other.weigth != null) {
				return false;
			}
		} else if (!weigth.equals(other.weigth)) {
			return false;
		}
		if (width == null) {
			if (other.width != null) {
				return false;
			}
		} else if (!width.equals(other.width)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ProductPackage [weigth=" + weigth
			+ ", height="
			+ height
			+ ", width="
			+ width
			+ ", depth="
			+ depth
			+ "]";
	}

}
