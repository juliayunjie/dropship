package com.sungale.dropship.data.basic;

import java.util.Date;

/**
 * 
 * @author Julia Sun
 * 2013 12 19
 */
public class BatchOrder {

	private String batchOrderNumber;
	private Integer numberOfOrders;
	private Date placedDate;
	private Merchant placedBy;
	public String getBatchOrderNumber() {
		return batchOrderNumber;
	}
	public void setBatchOrderNumber(String batchOrderNumber) {
		this.batchOrderNumber = batchOrderNumber;
	}
	public Integer getNumberOfOrders() {
		return numberOfOrders;
	}
	public void setNumberOfOrders(Integer numberOfOrders) {
		this.numberOfOrders = numberOfOrders;
	}
	public Date getPlacedDate() {
		return placedDate;
	}
	public void setPlacedDate(Date placedDate) {
		this.placedDate = placedDate;
	}
	public Merchant getPlacedBy() {
		return placedBy;
	}
	public void setPlacedBy(Merchant placedBy) {
		this.placedBy = placedBy;
	}
	
}
