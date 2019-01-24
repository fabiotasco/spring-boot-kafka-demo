
package io.fab.connector.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Product implements Serializable {

	private static final long serialVersionUID = -1342300056449001396L;

	private String sku;

	private String name;

	private String description;

	private Price price;

	private Stock stock;

	@JsonAlias("package")
	private Package pack;

	private UnitOfMeasurement unitOfMeasurement;

	private Brand brand;

	private Manufacturer manufacturer;

	private Media media;

	private ProductStatus status;

	Product() {}

	public Product(
		final String sku,
		final String name,
		final String description,
		final Price price,
		final Stock stock,
		final Package pack,
		final UnitOfMeasurement unitOfMeasurement,
		final Brand brand,
		final Manufacturer manufacturer,
		final Media media,
		final ProductStatus status) {
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.pack = pack;
		this.unitOfMeasurement = unitOfMeasurement;
		this.brand = brand;
		this.manufacturer = manufacturer;
		this.media = media;
		this.status = status;
	}

	public String getSku() {
		return sku;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Price getPrice() {
		return price;
	}

	public Stock getStock() {
		return stock;
	}

	public Package getPack() {
		return pack;
	}

	public UnitOfMeasurement getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public Brand getBrand() {
		return brand;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public Media getMedia() {
		return media;
	}

	public ProductStatus getStatus() {
		return status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (brand == null ? 0 : brand.hashCode());
		result = prime * result + (description == null ? 0 : description.hashCode());
		result = prime * result + (manufacturer == null ? 0 : manufacturer.hashCode());
		result = prime * result + (media == null ? 0 : media.hashCode());
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + (pack == null ? 0 : pack.hashCode());
		result = prime * result + (price == null ? 0 : price.hashCode());
		result = prime * result + (sku == null ? 0 : sku.hashCode());
		result = prime * result + (status == null ? 0 : status.hashCode());
		result = prime * result + (stock == null ? 0 : stock.hashCode());
		result = prime * result + (unitOfMeasurement == null ? 0 : unitOfMeasurement.hashCode());
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
		final Product other = (Product) obj;
		if (brand == null) {
			if (other.brand != null) {
				return false;
			}
		} else if (!brand.equals(other.brand)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (manufacturer == null) {
			if (other.manufacturer != null) {
				return false;
			}
		} else if (!manufacturer.equals(other.manufacturer)) {
			return false;
		}
		if (media == null) {
			if (other.media != null) {
				return false;
			}
		} else if (!media.equals(other.media)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (pack == null) {
			if (other.pack != null) {
				return false;
			}
		} else if (!pack.equals(other.pack)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		if (sku == null) {
			if (other.sku != null) {
				return false;
			}
		} else if (!sku.equals(other.sku)) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		if (stock == null) {
			if (other.stock != null) {
				return false;
			}
		} else if (!stock.equals(other.stock)) {
			return false;
		}
		if (unitOfMeasurement == null) {
			if (other.unitOfMeasurement != null) {
				return false;
			}
		} else if (!unitOfMeasurement.equals(other.unitOfMeasurement)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Product [sku=" + sku
			+ ", name="
			+ name
			+ ", description="
			+ description
			+ ", price="
			+ price
			+ ", stock="
			+ stock
			+ ", pack="
			+ pack
			+ ", unitOfMeasurement="
			+ unitOfMeasurement
			+ ", brand="
			+ brand
			+ ", manufacturer="
			+ manufacturer
			+ ", media="
			+ media
			+ ", status="
			+ status
			+ "]";
	}

}
