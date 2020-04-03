package com.ing.fullstack.challenge.webapp.secondcargarage.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "warehouses")
public class Warehouse {

	@Id private Long _id;	
	private String name;
	private Location location;
	@Field("cars")
	@JsonProperty("cars")
	private Car car;
	
	public Warehouse(final Long _id, final String name, final Location location, final Car car) {
		this.set_id(_id);
		this.setName(name);
		this.setLocation(location);
		this.setCar(car);
	}
	
	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
