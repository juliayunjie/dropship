/**
 * 
 */
package com.sungale.dropship.data.basic;

/**
 * @author Julia Sun
 * 2013 12 19
 */
public class Merchant {

	private String name;
	private String description;
	private Address address;
	//following are useless for now
	private String upsAccountNumber;
	private String taxIdNumber;
	private String taxIdType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getUpsAccountNumber() {
		return upsAccountNumber;
	}
	public void setUpsAccountNumber(String upsAccountNumber) {
		this.upsAccountNumber = upsAccountNumber;
	}
	public String getTaxIdNumber() {
		return taxIdNumber;
	}
	public void setTaxIdNumber(String taxIdNumber) {
		this.taxIdNumber = taxIdNumber;
	}
	public String getTaxIdType() {
		return taxIdType;
	}
	public void setTaxIdType(String taxIdType) {
		this.taxIdType = taxIdType;
	}
	
}
