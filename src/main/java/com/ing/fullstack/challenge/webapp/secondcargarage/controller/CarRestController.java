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


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CarRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarRestController.class);
	
	@Autowired
	private CarService carService;


    @GetMapping(value = { "", "/cars" })
    public @NotNull Iterable<CarDto> getCars() {
    	LOGGER.info("CarRestController.getCars() invocation started");
    	try {
	    	Iterable<CarDto> theCarDtos = carService.getAllWraehouseCars();
	        return theCarDtos;
    	} catch (final Exception inEx) {
			LOGGER.error("Error occurred at CarRestController.getCars(): {0}", inEx);
			throw new APIRequestProcessingException(inEx);
		}
    }
    
    @GetMapping(value = { "", "/cars/{parent}/{id}" })
    public @NotNull CarDetailDto getCarDetail(@PathVariable("parent") String parent, @PathVariable("id") String id) {
    	LOGGER.info("CarRestController.getCars() invocation started");
    	try {
    		CarDetailDto theCarDetailDto = carService.getCarDetail(parent, id);
    		return theCarDetailDto;
    	} catch (final Exception inEx) {
			LOGGER.error("Error occurred at CarRestController.getCarDetail(): {0}", inEx);
			throw new APIRequestProcessingException(inEx);
		}
    }
	
}
