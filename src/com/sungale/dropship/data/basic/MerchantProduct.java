package com.sungale.dropship.data.basic;

/**
 * 
 * @author Julia Sun
 * 2013 12 19
 */
public class MerchantProduct {

	private String upc;
	private String merchantSku;
	private String merchantAssignedOurSku;
	private Double merchantPrice;
	private Double merchantCost;	//our price to the specific merchant
	private Product product;
	private Merchant merchant;
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getMerchantSku() {
		return merchantSku;
	}
	public void setMerchantSku(String merchantSku) {
		this.merchantSku = merchantSku;
	}
	public String getMerchantAssignedOurSku() {
		return merchantAssignedOurSku;
	}
	public void setMerchantAssignedOurSku(String merchantAssignedOurSku) {
		this.merchantAssignedOurSku = merchantAssignedOurSku;
	}
	public Double getMerchantPrice() {
		return merchantPrice;
	}
	public void setMerchantPrice(Double merchantPrice) {
		this.merchantPrice = merchantPrice;
	}
	public Double getMerchantCost() {
		return merchantCost;
	}
	public void setMerchantCost(Double merchantCost) {
		this.merchantCost = merchantCost;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	
}
