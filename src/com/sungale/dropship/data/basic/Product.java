/**
 * 
 */
package com.sungale.dropship.data.basic;

/**
 * @author Julia Sun
 * 2013 12 18
 */
public class Product {

	private Integer unitWeight;
	private String name;
	private String description;
	private String modelNumber;
	public Integer getUnitWeight() {
		return unitWeight;
	}
	public void setUnitWeight(Integer unitWeight) {
		this.unitWeight = unitWeight;
	}
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
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	
}
