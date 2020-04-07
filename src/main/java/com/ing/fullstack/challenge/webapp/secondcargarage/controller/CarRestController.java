package com.ing.fullstack.challenge.webapp.secondcargarage.controller;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.fullstack.challenge.webapp.secondcargarage.dto.CarDetailDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.dto.CarDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.service.WarehouseCarService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CarRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarRestController.class);
	
	@Autowired
	private WarehouseCarService carService;

	/*
	 * This GET method is exposed as REST-Api to get all Car resource
	 */
    @GetMapping(value = { "", "/cars" })
    public @NotNull Iterable<CarDto> getAllCars() {
    	LOGGER.info("CarRestController.getAllCars() invocation started");
	    Iterable<CarDto> theCarDtos = carService.getAllWraehouseCars();
	    LOGGER.info("CarRestController.getAllCars() invocation ended");
	    return theCarDtos;
    }
    
    /*
	 * This GET method is exposed as REST-Api to get individual Car resource
	 */
    @GetMapping(value = { "", "/cars/{parent}/{id}" })
    public @NotNull CarDetailDto getCarDetail(@PathVariable("parent") String parent, @PathVariable("id") String id) {
    	LOGGER.info("CarRestController.getCarDetail() invocation started");
    	CarDetailDto theCarDetailDto = carService.getCarDetail(parent, id);
    	LOGGER.info("CarRestController.getCarDetail() invocation ended");
    	return theCarDetailDto;
    }
	
}
