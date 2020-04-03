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
	
	@Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehicle))
            return false;
        Vehicle other = (Vehicle) o;
        boolean _idEquals = (this._id == null && other._id == null)
          || (this._id != null && this._id.equals(other._id));
        boolean makeEquals = (this.make == null && other.make == null)
          || (this.make != null && this.make.equals(other.make));
        boolean modelEquals = (this.model == null && other.model == null)
          || (this.model != null && this.model.equals(other.model));
        boolean year_modelEquals = (this.year_model == null && other.year_model == null)
          || (this.year_model != null && this.year_model.equals(other.year_model));
        boolean priceEquals = (this.price == null && other.price == null)
          || (this.price != null && this.price.equals(other.price));
        boolean licensedEquals = (this.licensed == other.licensed);
        boolean date_addedEquals = (this.date_added == null && other.date_added == null)
          || (this.date_added != null && this.make.equals(other.date_added));
        
        return _idEquals && makeEquals && modelEquals && year_modelEquals && priceEquals && licensedEquals && date_addedEquals;
    }
	
	
	@Override
	public final int hashCode() {
	    int intHashCode = 31;
	    if (_id != null) {
	    	intHashCode = 13 * intHashCode + _id.hashCode();
	    }
	    if (make != null) {
	    	intHashCode = 13 * intHashCode + make.hashCode();
	    }
	    if (model != null) {
	    	intHashCode = 13 * intHashCode + model.hashCode();
	    }
	    if (year_model != null) {
	    	intHashCode = 13 * intHashCode + year_model.hashCode();
	    }
	    if (price != null) {
	    	intHashCode = 13 * intHashCode + price.hashCode();
	    }
	    if (date_added != null) {
	    	intHashCode = 13 * intHashCode + date_added.hashCode();
	    }
	    intHashCode = 13 * intHashCode + Boolean.valueOf(this.licensed).hashCode();
	    
	    return intHashCode;
	}
}
