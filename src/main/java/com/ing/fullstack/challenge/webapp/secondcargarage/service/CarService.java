package com.ing.fullstack.challenge.webapp.secondcargarage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.fullstack.challenge.webapp.secondcargarage.dto.CarDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.repository.WarehouseRepository;

@Service
public class CarService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarService.class);

	@Autowired
	private WarehouseRepository warehouseRepository;

	public Iterable<CarDto> getAllWraehouseCars() {
		LOGGER.info("CarService.getAllWraehouseCars() invocation started");
		List<CarDto> theCarDtos = new ArrayList<>();
		warehouseRepository.findAll().forEach(inWareHouse -> inWareHouse.getCar().getVehicles().forEach(v -> {
			CarDto e = new CarDto(inWareHouse.getName(), v.getMake(), v.getModel(), String.valueOf(v.getYear_model()),
					String.valueOf(v.getPrice()), String.valueOf(v.isLicensed()), v.getDate_added());
			theCarDtos.add(e);
		}));
		return theCarDtos.stream().sorted((a, b) -> {
			return a.getDate_added().compareTo(b.getDate_added());
		}).collect(Collectors.toList());
	}

}
