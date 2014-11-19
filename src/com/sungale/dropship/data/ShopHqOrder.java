/**
 * 
 */
package com.sungale.dropship.data;

/**
 * @author Julia Sun
 *
 */
public class ShopHqOrder {

	private String trxId;
	private String trxDate;
	private String poNumber;
	private Double unitCost;
	private String merchantLineNumber;
	private Integer qtyOrdered;
	private String vendorSku;
	private String merchantSku;
//	private Integer trxQty;
	private String personName;
	private String address;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String country;
	private String customOrderNumber;
	private String shippingCode;
	
	
	
	public String getShippingCode() {
		return shippingCode;
	}
	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public Integer getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(Integer qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	public String getCustomOrderNumber() {
		return customOrderNumber;
	}
	public void setCustomOrderNumber(String customOrderNumber) {
		this.customOrderNumber = customOrderNumber;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMerchantSku() {
		return merchantSku;
	}
	public void setMerchantSku(String merchantSku) {
		this.merchantSku = merchantSku;
	}
	public String getVendorSku() {
		return vendorSku;
	}
	public void setVendorSku(String vendorSku) {
		this.vendorSku = vendorSku;
	}

	public String getTrxId() {
		return trxId;
	}
	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}
	public String getTrxDate() {
		return trxDate;
	}
	public void setTrxDate(String trxDate) {
		this.trxDate = trxDate;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public Double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}
	public String getMerchantLineNumber() {
		return merchantLineNumber;
	}
	public void setMerchantLineNumber(String merchantLineNumber) {
		this.merchantLineNumber = merchantLineNumber;
	}
	
	
	
}
