/**
 * 
 */
package com.sungale.dropship.data;

/**
 * @author Julia Sun
 * 2013 12 30
 */
public class MatchingCsv {

	private String sungaleModelNumber;
	private String nmrProductName;
	private String nmrSku;
	private Double productUnitWeight;
	
	public Double getProductUnitWeight() {
		return productUnitWeight;
	}
	public void setProductUnitWeight(Double productUnitWeight) {
		this.productUnitWeight = productUnitWeight;
	}
	public String getSungaleModelNumber() {
		return sungaleModelNumber;
	}
	public void setSungaleModelNumber(String sungaleModelNumber) {
		this.sungaleModelNumber = sungaleModelNumber;
	}
	public String getNmrProductName() {
		return nmrProductName;
	}
	public void setNmrProductName(String nmrProductName) {
		this.nmrProductName = nmrProductName;
	}
	public String getNmrSku() {
		return nmrSku;
	}
	public void setNmrSku(String nmrSku) {
		this.nmrSku = nmrSku;
	}

	@Override
	public String toString() {
		return "MatchingCsv [sungaleModelNumber=" + sungaleModelNumber
				+ ", nmrProductName=" + nmrProductName + ", nmrSku=" + nmrSku
				+ ", proudctUnitWeight=" + productUnitWeight + "]";
	}
	
	
}
