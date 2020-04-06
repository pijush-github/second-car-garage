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
import com.ing.fullstack.challenge.webapp.secondcargarage.dto.ShoppingCartDto;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecondCarGarageApplicationTests {

	@Autowired 
	private TestRestTemplate testRestTemplate;

    @LocalServerPort 
    private int thePort;

    @Autowired 
    private CarRestController theCarRestController;
    
    @Autowired 
    private CarRestController theShoppingCartRestController;
    
	@Test
	void contextLoads() {
		Assertions
        .assertThat(theCarRestController)
        .isNotNull();
		
		Assertions
        .assertThat(theShoppingCartRestController)
        .isNotNull();
	}

	@Test
    public void testGivenGetCarsApiCallWhenListofCarsRetrievedThenSizeMatch() {
        ResponseEntity<Iterable<CarDto>> responseEntity = testRestTemplate.exchange("http://localhost:" + thePort + "/api/cars", HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<CarDto>>() {
        });
        Iterable<CarDto> cars = responseEntity.getBody();
        Assertions
          .assertThat(cars)
          .hasSize(9);

    }
	
	
	@Test
    public void testGivenGetShoppingCartApiCallWhenCartDetailsRetrievedThenInitialSizeZero() {
        ResponseEntity<ShoppingCartDto> responseEntity = testRestTemplate.exchange("http://localhost:" + thePort + "/api/shopping/cart", HttpMethod.GET, null, new ParameterizedTypeReference<ShoppingCartDto>() {
        });
        ShoppingCartDto shoppingCart = responseEntity.getBody();
        Assertions
          .assertThat(shoppingCart.getAllCartItems())
          .hasSize(0);

    }
}
