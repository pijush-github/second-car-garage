package com.ing.fullstack.challenge.webapp.secondcargarage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.ing.fullstack.challenge.webapp.secondcargarage.controller.CarRestController;
import com.ing.fullstack.challenge.webapp.secondcargarage.dto.CarDto;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecondCarGarageApplicationTests {

	@Autowired 
	private TestRestTemplate testRestTemplate;

    @LocalServerPort 
    private int port;

    @Autowired 
    private CarRestController carRestController;
    
	@Test
	void contextLoads() {
		Assertions
        .assertThat(carRestController)
        .isNotNull();
	}

	@Test
    public void givenGetCarsApiCallWhenListofCarsRetrievedThenSizeMatch() {
        ResponseEntity<Iterable<CarDto>> responseEntity = testRestTemplate.exchange("http://localhost:" + port + "/api/cars", HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<CarDto>>() {
        });
        Iterable<CarDto> cars = responseEntity.getBody();
        Assertions
          .assertThat(cars)
          .hasSize(9);

    }
}
