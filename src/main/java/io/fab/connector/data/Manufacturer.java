
package io.fab.connector.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Manufacturer implements Serializable {

	private static final long serialVersionUID = -210819886125613580L;

	private String partNumber;

	@JsonAlias("gtin")
	private String globalTradeItemNumber; // GTIN-EAN

	@JsonAlias("ca")
	private String approvalCertificate; // CA (Certificado de Aprovação)

	Manufacturer() {}

	public Manufacturer(final String partNumber, final String globalTradeItemNumber, final String approvalCertificate) {
		this.partNumber = partNumber;
		this.globalTradeItemNumber = globalTradeItemNumber;
		this.approvalCertificate = approvalCertificate;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public String getGlobalTradeItemNumber() {
		return globalTradeItemNumber;
	}

	public String getApprovalCertificate() {
		return approvalCertificate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (approvalCertificate == null ? 0 : approvalCertificate.hashCode());
		result = prime * result + (globalTradeItemNumber == null ? 0 : globalTradeItemNumber.hashCode());
		result = prime * result + (partNumber == null ? 0 : partNumber.hashCode());
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
		if (approvalCertificate == null) {
			if (other.approvalCertificate != null) {
				return false;
			}
		} else if (!approvalCertificate.equals(other.approvalCertificate)) {
			return false;
		}
		if (globalTradeItemNumber == null) {
			if (other.globalTradeItemNumber != null) {
				return false;
			}
		} else if (!globalTradeItemNumber.equals(other.globalTradeItemNumber)) {
			return false;
		}
		if (partNumber == null) {
			if (other.partNumber != null) {
				return false;
			}
		} else if (!partNumber.equals(other.partNumber)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Manufacturer [partNumber=" + partNumber
			+ ", globalTradeItemNumber="
			+ globalTradeItemNumber
			+ ", approvalCertificate="
			+ approvalCertificate
			+ "]";
	}

}
