package com.sungale.dropship.data;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;

import com.sungale.dropship.data.basic.Shipment;
import com.sungale.dropship.data.basic.SingleOrder;

/**
 * 
 * @author Julia Sun
 */
public class NmrCsv {
//	private Shipment shipment;
//	private SingleOrder order;
	private String reference_id;
	private String order_id;
	private String shipment_id;
	private String shipment_tracking_id;
	private String shipment_sent_on;//maybe Date
	private String shipment_cost;
	private String shipping_first_name;
	private String shipping_last_name;
	private String shipping_address_street;
	private String shipping_address_street_cont;
	private String shipping_city;
	private String shipping_state;
	private String shipping_postal_code;
	private String shipping_country;
	private String shipping_country_name;
	private String product_sku;
	private String warehouse_sku;
	private String warehouse_id;
	private String warehouse_name;
	private Integer product_quantity;
	private String product_name;
	private String product_description;
	private Double product_cost;
	private String customer_phone_number;
	private String order_date;	//maybe date
	private String carrier;
	
	
	
	
	@Override
	public String toString() {
		return "NomorerackCsv [reference_id=" + reference_id + ", order_id="
				+ order_id + ", shipment_id=" + shipment_id
				+ ", shipment_tracking_id=" + shipment_tracking_id
				+ ", shipment_sent_on=" + shipment_sent_on + ", shipment_cost="
				+ shipment_cost + ", shipping_first_name="
				+ shipping_first_name + ", shipping_last_name="
				+ shipping_last_name + ", shipping_address_street="
				+ shipping_address_street + ", shipping_address_street_cont="
				+ shipping_address_street_cont + ", shipping_city="
				+ shipping_city + ", shipping_state=" + shipping_state
				+ ", shipping_postal_code=" + shipping_postal_code
				+ ", shipping_country=" + shipping_country
				+ ", shipping_country_name=" + shipping_country_name
				+ ", product_sku=" + product_sku + ", warehouse_sku="
				+ warehouse_sku + ", warehouse_id=" + warehouse_id
				+ ", warehouse_name=" + warehouse_name + ", product_quantity="
				+ product_quantity + ", product_name=" + product_name
				+ ", product_description=" + product_description
				+ ", product_cost=" + product_cost + ", customer_phone_number="
				+ customer_phone_number + ", order_date=" + order_date
				+ ", carrier=" + carrier + "]";
	}


	public NmrCsv(String reference_id, String order_id,
			String shipment_id, String shipment_tracking_id,
			String shipment_sent_on, String shipment_cost,
			String shipping_fist_name, String shipping_last_name,
			String shipping_address_street,
			String shipping_address_street_cont, String shipping_city,
			String shipping_state, String shipping_postal_code,
			String shipping_county, String shipping_country_name, String product_sku, String warehouse_sku,
			String warehouse_id, String warehouse_name,
			Integer product_quantity, String product_name,
			String product_description, Double product_cost,
			String customer_phone_number, String order_date, String carrier) {
		super();
		this.reference_id = reference_id;
		this.order_id = order_id;
		this.shipment_id = shipment_id;
		this.shipment_tracking_id = shipment_tracking_id;
		this.shipment_sent_on = shipment_sent_on;
		this.shipment_cost = shipment_cost;
		this.shipping_first_name = shipping_fist_name;
		this.shipping_last_name = shipping_last_name;
		this.shipping_address_street = shipping_address_street;
		this.shipping_address_street_cont = shipping_address_street_cont;
		this.shipping_city = shipping_city;
		this.shipping_state = shipping_state;
		this.shipping_postal_code = shipping_postal_code;
		this.shipping_country = shipping_county;
		this.shipping_country_name = shipping_country_name;
		this.product_sku = product_sku;
		this.warehouse_sku = warehouse_sku;
		this.warehouse_id = warehouse_id;
		this.warehouse_name = warehouse_name;
		this.product_quantity = product_quantity;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_cost = product_cost;
		this.customer_phone_number = customer_phone_number;
		this.order_date = order_date;
		this.carrier = carrier;
	}


	public String getShipping_country_name() {
		return shipping_country_name;
	}


	public void setShipping_country_name(String shipping_country_name) {
		this.shipping_country_name = shipping_country_name;
	}


	public String getShipping_first_name() {
		return shipping_first_name;
	}


	public void setShipping_first_name(String shipping_first_name) {
		this.shipping_first_name = shipping_first_name;
	}


	public String getReference_id() {
		return reference_id;
	}


	public void setReference_id(String reference_id) {
		this.reference_id = reference_id;
	}


	public String getOrder_id() {
		return order_id;
	}


	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}


	public String getShipment_id() {
		return shipment_id;
	}


	public void setShipment_id(String shipment_id) {
		this.shipment_id = shipment_id;
	}


	public String getShipment_tracking_id() {
		return shipment_tracking_id;
	}


	public void setShipment_tracking_id(String shipment_tracking_id) {
		this.shipment_tracking_id = shipment_tracking_id;
	}


	public String getShipment_sent_on() {
		return shipment_sent_on;
	}


	public void setShipment_sent_on(String shipment_sent_on) {
		this.shipment_sent_on = shipment_sent_on;
	}


	public String getShipment_cost() {
		return shipment_cost;
	}


	public void setShipment_cost(String shipment_cost) {
		this.shipment_cost = shipment_cost;
	}

	public String getShipping_last_name() {
		return shipping_last_name;
	}


	public void setShipping_last_name(String shipping_last_name) {
		this.shipping_last_name = shipping_last_name;
	}


	public String getShipping_address_street() {
		return shipping_address_street;
	}


	public void setShipping_address_street(String shipping_address_street) {
		this.shipping_address_street = shipping_address_street;
	}


	public String getShipping_address_street_cont() {
		return shipping_address_street_cont;
	}


	public void setShipping_address_street_cont(String shipping_address_street_cont) {
		this.shipping_address_street_cont = shipping_address_street_cont;
	}


	public String getShipping_city() {
		return shipping_city;
	}


	public void setShipping_city(String shipping_city) {
		this.shipping_city = shipping_city;
	}


	public String getShipping_state() {
		return shipping_state;
	}


	public void setShipping_state(String shipping_state) {
		this.shipping_state = shipping_state;
	}


	public String getShipping_postal_code() {
		return shipping_postal_code;
	}


	public void setShipping_postal_code(String shipping_postal_code) {
		this.shipping_postal_code = shipping_postal_code;
	}



	public String getShipping_country() {
		return shipping_country;
	}


	public void setShipping_country(String shipping_country) {
		this.shipping_country = shipping_country;
	}


	public String getProduct_sku() {
		return product_sku;
	}


	public void setProduct_sku(String product_sku) {
		this.product_sku = product_sku;
	}


	public String getWarehouse_sku() {
		return warehouse_sku;
	}


	public void setWarehouse_sku(String warehouse_sku) {
		this.warehouse_sku = warehouse_sku;
	}


	public String getWarehouse_id() {
		return warehouse_id;
	}


	public void setWarehouse_id(String warehouse_id) {
		this.warehouse_id = warehouse_id;
	}


	public String getWarehouse_name() {
		return warehouse_name;
	}


	public void setWarehouse_name(String warehouse_name) {
		this.warehouse_name = warehouse_name;
	}


	public Integer getProduct_quantity() {
		return product_quantity;
	}


	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public String getProduct_description() {
		return product_description;
	}


	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}


	public Double getProduct_cost() {
		return product_cost;
	}


	public void setProduct_cost(Double product_cost) {
		this.product_cost = product_cost;
	}


	public String getCustomer_phone_number() {
		return customer_phone_number;
	}


	public void setCustomer_phone_number(String customer_phone_number) {
		this.customer_phone_number = customer_phone_number;
	}


	public String getOrder_date() {
		return order_date;
	}


	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}


	public String getCarrier() {
		return carrier;
	}


	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}


	public NmrCsv(){
		
	}
	
	
}
