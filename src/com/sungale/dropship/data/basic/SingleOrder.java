/**
 * 
 */
package com.sungale.dropship.data.basic;

import java.util.Date;

/**
 * @author Julia Sun
 * 2013 12 18
 */
public class SingleOrder {
	
	private String merchantOrderId;
	private String merchantOrderNumber;
	private Integer quantity;
	private Product product;
	private Date placedDate;
	private Address shipTo;
	private Address shipFrom;
	private String status; //processing, shipped, partial-shipped, cancelled
	private String batchOrderNumber;
	public String getMerchantOrderId() {
		return merchantOrderId;
	}
	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}
	public String getMerchantOrderNumber() {
		return merchantOrderNumber;
	}
	public void setMerchantOrderNumber(String merchantOrderNumber) {
		this.merchantOrderNumber = merchantOrderNumber;
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
	public Date getPlacedDate() {
		return placedDate;
	}
	public void setPlacedDate(Date placedDate) {
		this.placedDate = placedDate;
	}
	public Address getShipTo() {
		return shipTo;
	}
	public void setShipTo(Address shipTo) {
		this.shipTo = shipTo;
	}
	public Address getShipFrom() {
		return shipFrom;
	}
	public void setShipFrom(Address shipFrom) {
		this.shipFrom = shipFrom;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBatchOrderNumber() {
		return batchOrderNumber;
	}
	public void setBatchOrderNumber(String batchOrderNumber) {
		this.batchOrderNumber = batchOrderNumber;
	}
	

}
