package com.ing.fullstack.challenge.webapp.secondcargarage.dto;

import java.util.List;

import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Vehicle;

public class CarDto {

	private List<Vehicle> cars;

	public List<Vehicle> getCars() {
		return cars;
	}

	public void setCars(List<Vehicle> cars) {
		this.cars = cars;
	}
	
}
