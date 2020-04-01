package com.ing.fullstack.challenge.webapp.secondcargarage.domain;

import java.util.List;

import lombok.ToString;

@ToString
public class Car {
	
	private String location;
	private List<Vehicle> vehicles;
	
	public Car(final String location, final List<Vehicle> vehicles) {
		this.setLocation(location);
		this.setVehicles(vehicles);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
