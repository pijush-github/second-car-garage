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
import com.ing.fullstack.challenge.webapp.secondcargarage.error.APIRequestProcessingException;
import com.ing.fullstack.challenge.webapp.secondcargarage.service.CarService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CarRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarRestController.class);
	
	@Autowired
	private CarService carService;

	/*
	 * This GET method is exposed as REST-Api to get all Car resource
	 */
    @GetMapping(value = { "", "/cars" })
    public @NotNull Iterable<CarDto> getAllCars() {
    	LOGGER.info("CarRestController.getAllCars() invocation started");
    	try {
	    	Iterable<CarDto> theCarDtos = carService.getAllWraehouseCars();
	        return theCarDtos;
    	} catch (final Exception inEx) {
			LOGGER.error("Error occurred at CarRestController.getAllCars(): {0}", inEx);
			throw new APIRequestProcessingException(inEx);
		}
    }
    
    /*
	 * This GET method is exposed as REST-Api to get individual Car resource
	 */
    @GetMapping(value = { "", "/cars/{parent}/{id}" })
    public @NotNull CarDetailDto getCarDetail(@PathVariable("parent") String parent, @PathVariable("id") String id) {
    	LOGGER.info("CarRestController.getCarDetail() invocation started");
    	try {
    		CarDetailDto theCarDetailDto = carService.getCarDetail(parent, id);
    		return theCarDetailDto;
    	} catch (final Exception inEx) {
			LOGGER.error("Error occurred at CarRestController.getCarDetail(): {0}", inEx);
			throw new APIRequestProcessingException(inEx);
		}
    }
	
}
