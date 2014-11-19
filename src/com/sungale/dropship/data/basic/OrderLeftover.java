/**
 * 
 */
package com.sungale.dropship.data.basic;

/**
 * @author Julia Sun
 * 2013 12 18
 */
public class OrderLeftover {

	private Product product;
	private Integer qty;
	private String reason;
	private String singleOrderId;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSingleOrderId() {
		return singleOrderId;
	}
	public void setSingleOrderId(String singleOrderId) {
		this.singleOrderId = singleOrderId;
	}
}
