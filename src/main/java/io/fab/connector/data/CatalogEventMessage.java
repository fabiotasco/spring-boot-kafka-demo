
package io.fab.connector.data;

import java.io.Serializable;

public class CatalogEventMessage implements Serializable {

	private static final long serialVersionUID = 5164970578419625835L;

	private Product product;
	private CatalogEvent event;
	private Source source;

	CatalogEventMessage() {}

	public CatalogEventMessage(final Product product, final CatalogEvent event, final Source source) {
		this.product = product;
		this.event = event;
		this.source = source;
	}

	public Product getProduct() {
		return product;
	}

	public CatalogEvent getEvent() {
		return event;
	}

	public Source getSource() {
		return source;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (event == null ? 0 : event.hashCode());
		result = prime * result + (product == null ? 0 : product.hashCode());
		result = prime * result + (source == null ? 0 : source.hashCode());
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
		final CatalogEventMessage other = (CatalogEventMessage) obj;
		if (event == null) {
			if (other.event != null) {
				return false;
			}
		} else if (!event.equals(other.event)) {
			return false;
		}
		if (product == null) {
			if (other.product != null) {
				return false;
			}
		} else if (!product.equals(other.product)) {
			return false;
		}
		if (source != other.source) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ProductEventMessage [product=" + product + ", event=" + event + ", source=" + source + "]";
	}

}
