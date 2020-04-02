package com.ing.fullstack.challenge.webapp.secondcargarage.dto;

public class CarDto {

	private String parentId;
	private String make;
	private String model;
	private String year_model;
	private String price;
	private String licensed;
	private String date_added;
	
	public CarDto(final String parentId, final String make, final String model, final String year_model, final String price, final String licensed, final String date_added) {
		this.parentId = parentId;
		this.setMake(make);
		this.setModel(model);
		this.setYear_model(year_model);
		this.setPrice(price);
		this.setLicensed(licensed);
		this.setDate_added(date_added);
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear_model() {
		return year_model;
	}

	public void setYear_model(String year_model) {
		this.year_model = year_model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLicensed() {
		return licensed;
	}

	public void setLicensed(String licensed) {
		this.licensed = licensed;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}
}
