package com.ing.fullstack.challenge.webapp.secondcargarage.dto;

import java.util.Optional;

import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Location;
import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Vehicle;

public class CarDetailDto {

	private String parentId;
	private String id;
	private String make;
	private String model;
	private String year_model;
	private String price;
	private String licensed;
	private String date_added;
	
	private String location;
	private String name;
	
	public CarDetailDto(final String parentId, final String name, final Location location, final Optional<Vehicle> vehicle) {
		if(vehicle.isPresent()) {
			this.setParentId(parentId);
			this.setName(name);
			this.setId(String.valueOf(vehicle.get().get_id()));
			this.setMake(vehicle.get().getMake());
			this.setModel(vehicle.get().getModel());
			this.setYear_model(String.valueOf(vehicle.get().getYear_model()));
			this.setPrice(String.valueOf(vehicle.get().getPrice()));
			this.setLicensed(String.valueOf(vehicle.get().isLicensed()));
			this.setDate_added(String.valueOf(vehicle.get().getDate_added()));
			this.setLocation(String.valueOf(location.getLattitude())+"/"+String.valueOf(location.getLongitude()));
		}
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
