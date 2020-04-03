package com.ing.fullstack.challenge.webapp.secondcargarage.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vehicle {

	@Id private Long _id;
	private String make;
	private String model;
	private Long year_model;
	private Double price;
	private boolean licensed;
	private String date_added;
	
	public Vehicle(final Long _id, final String make, final String model, final Long year_model, final Double price, final boolean licensed, final String date_added) {
		this.set_id(_id);
		this.setMake(make);
		this.setModel(model);
		this.setYear_model(year_model);
		this.setPrice(price);
		this.setLicensed(licensed);
		this.setDate_added(date_added);
	}
	
	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
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

	public Long getYear_model() {
		return year_model;
	}

	public void setYear_model(Long year_model) {
		this.year_model = year_model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isLicensed() {
		return licensed;
	}

	public void setLicensed(boolean licensed) {
		this.licensed = licensed;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}
	
	@Override
	  public String toString() {
	    return "vehicle : {_id=" + get_id() + ", make=" + getMake() + ", model=" + getModel() + ", year_model=" + getYear_model() + ", price=" + getPrice() + ", licensed=" + isLicensed() + ", date_added=" + getDate_added() +"}";
	  }
}
