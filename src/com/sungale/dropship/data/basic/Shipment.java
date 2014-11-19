/**
 * 
 */
package com.sungale.dropship.data.basic;

import java.util.Date;

/**
 * @author Julia Sun
 * 2013 12 18
 */
public class Shipment {
	
	private Integer shipmentId;
	private Integer singleOrderId;
	private String carrier;
	private String trackingNumber;
	private Date sentDate;
	private Double shippingCost;
	private String serviceType;//Ground, Air, Next-day, etc.
	private String billingOption; //Shipper, Receiver, ThirdParty, etc.
	private Merchant billTo;
	//following are useless for now.
	private String qvnOption;	
	private String qvnShipmentNotification1Option;
	private String notificationRecipientType;
	private String notificationRecipient1FaxorEmail;
	public Integer getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(Integer shipmentId) {
		this.shipmentId = shipmentId;
	}
	public Integer getSingleOrderId() {
		return singleOrderId;
	}
	public void setSingleOrderId(Integer singleOrderId) {
		this.singleOrderId = singleOrderId;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public Double getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getBillingOption() {
		return billingOption;
	}
	public void setBillingOption(String billingOption) {
		this.billingOption = billingOption;
	}
	public Merchant getBillTo() {
		return billTo;
	}
	public void setBillTo(Merchant billTo) {
		this.billTo = billTo;
	}
	public String getQvnOption() {
		return qvnOption;
	}
	public void setQvnOption(String qvnOption) {
		this.qvnOption = qvnOption;
	}
	public String getQvnShipmentNotification1Option() {
		return qvnShipmentNotification1Option;
	}
	public void setQvnShipmentNotification1Option(
			String qvnShipmentNotification1Option) {
		this.qvnShipmentNotification1Option = qvnShipmentNotification1Option;
	}
	public String getNotificationRecipientType() {
		return notificationRecipientType;
	}
	public void setNotificationRecipientType(String notificationRecipientType) {
		this.notificationRecipientType = notificationRecipientType;
	}
	public String getNotificationRecipient1FaxorEmail() {
		return notificationRecipient1FaxorEmail;
	}
	public void setNotificationRecipient1FaxorEmail(
			String notificationRecipient1FaxorEmail) {
		this.notificationRecipient1FaxorEmail = notificationRecipient1FaxorEmail;
	}
	
}
