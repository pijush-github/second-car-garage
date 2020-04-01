package com.ing.fullstack.challenge.webapp.secondcargarage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.fullstack.challenge.webapp.secondcargarage.dto.CarDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.error.APIRequestProcessingException;
import com.ing.fullstack.challenge.webapp.secondcargarage.service.CarService;


@RestController
@RequestMapping("/api/cars")
public class CarRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarRestController.class);
	
	@Autowired
	private CarService carService;


    @GetMapping(value = { "", "/" })
    public ResponseEntity<CarDto> getCars() {
    	
    	LOGGER.info("CarRestController.getCars() invocation started");
    	
    	try {
	    	final HttpHeaders theHeaders = new HttpHeaders();
	    	theHeaders.add("Processed -", "CarRestController.getCars()");
			CarDto theCarDto = carService.getAllWraehouseCars();
	        return new ResponseEntity<CarDto>(theCarDto, theHeaders, HttpStatus.OK);
    	} catch (final Exception inEx) {
			LOGGER.error("Error occurred at CarRestController.getCars(): {0}", inEx);
			throw new APIRequestProcessingException(inEx);
		}
    }
	
}
