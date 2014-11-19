/**
 * 
 */
package com.sungale.dropship.data.basic;

/**
 * @author Julia Sun
 * 2013 12 18
 */
public class Package {

	private String pkgType; //Package, Express Box, Letter, PAK, Tub
	private Double pkgWeight;
	private String reference1;
	private String reference2;
	private Integer quantity;
	private Product product;
	private String singleOrderId;
	private String shipmentId;
	public String getPkgType() {
		return pkgType;
	}
	public void setPkgType(String pkgType) {
		this.pkgType = pkgType;
	}
	public Double getPkgWeight() {
		return pkgWeight;
	}
	public void setPkgWeight(Double pkgWeight) {
		this.pkgWeight = pkgWeight;
	}
	public String getReference1() {
		return reference1;
	}
	public void setReference1(String reference1) {
		this.reference1 = reference1;
	}
	public String getReference2() {
		return reference2;
	}
	public void setReference2(String reference2) {
		this.reference2 = reference2;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getSingleOrderId() {
		return singleOrderId;
	}
	public void setSingleOrderId(String singleOrderId) {
		this.singleOrderId = singleOrderId;
	}
	public String getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}
	
}
