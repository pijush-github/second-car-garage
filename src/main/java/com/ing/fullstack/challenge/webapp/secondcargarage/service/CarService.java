package com.ing.fullstack.challenge.webapp.secondcargarage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Vehicle;
import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Warehouse;
import com.ing.fullstack.challenge.webapp.secondcargarage.dto.CarDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.repository.WarehouseRepository;

@Service
public class CarService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarService.class);
			
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	public CarDto getAllWraehouseCars() {
		LOGGER.info("CarService.getAllWraehouseCars() invocation started");
		List<Vehicle> result = new ArrayList<>();
		for(Warehouse inWareHouse : warehouseRepository.findAll()) {
			result.addAll(inWareHouse.getCar().getVehicles());
		}
		CarDto theCarDto = new CarDto();
		theCarDto.setCars(result.stream().sorted((a,b) -> {return a.getDate_added().compareTo(b.getDate_added());}).collect(Collectors.toList()));
		return theCarDto;
	}

	
}
