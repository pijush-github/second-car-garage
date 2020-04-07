package com.ing.fullstack.challenge.webapp.secondcargarage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ing.fullstack.challenge.webapp.secondcargarage.controller.CarRestController;
import com.ing.fullstack.challenge.webapp.secondcargarage.controller.ShoppingCartRestController;
import com.ing.fullstack.challenge.webapp.secondcargarage.dto.CarDetailDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.dto.CarDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.dto.ShoppingCartDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecondCarGarageApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int thePort;

	@Autowired
	private CarRestController theCarRestController;

	@Autowired
	private ShoppingCartRestController theShoppingCartRestController;

	@Test
	void contextLoads() {
		Assertions.assertThat(theCarRestController).isNotNull();
		Assertions.assertThat(theShoppingCartRestController).isNotNull();
	}

	@Test
	public void testGivenGetCarsApiCallWhenListofCarsRetrievedThenSizeMatch() {
		ResponseEntity<Iterable<CarDto>> responseEntity = testRestTemplate.exchange(
				"http://localhost:" + thePort + "/api/cars", HttpMethod.GET, null,
				new ParameterizedTypeReference<Iterable<CarDto>>() {
				});
		Iterable<CarDto> cars = responseEntity.getBody();
		Assertions.assertThat(cars).hasSize(9);
	}

	@Test
	public void testGivenGetCarDetailCallWhenListofCarsRetrievedThenNotNull() {
		ResponseEntity<CarDetailDto> responseEntity = testRestTemplate.exchange(
				"http://localhost:" + thePort + "/api/cars/1/1", HttpMethod.GET, null,
				new ParameterizedTypeReference<CarDetailDto>() {
				});
		CarDetailDto car = responseEntity.getBody();
		Assertions.assertThat(car).hasFieldOrPropertyWithValue("id", "1");
	}

	@Test
	public void testGivenGetCarDetailCallWhenListofCarsRetrievedThenReturnErrorMessage() {
		ResponseEntity<String> responseEntity = testRestTemplate.exchange(
				"http://localhost:" + thePort + "/api/cars/4/1", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				});
		String msg = responseEntity.getBody();
		Assertions.assertThat(msg).contains("Wearhouse is not found");
	}

	@Test
	public void testGivenGetShoppingCartApiCallWhenCartDetailsRetrievedThenInitialSizeMatch() {
		final CarDto theCar01 = new CarDto("2", "2", "Isuzu", "Rodeo", "1998", "6303.99", "false", "2017-12-03",
				"false");
		ResponseEntity<Void> responseEntity01 = testRestTemplate.exchange(
				"http://localhost:" + thePort + "/api/shopping/cart", HttpMethod.POST, new HttpEntity<>(theCar01),
				new ParameterizedTypeReference<Void>() {
				});
		HttpStatus status01 = responseEntity01.getStatusCode();
		Assertions.assertThat(status01.value()).isEqualTo(HttpStatus.OK.value());

		ResponseEntity<ShoppingCartDto> responseEntity02 = testRestTemplate.exchange(
				"http://localhost:" + thePort + "/api/shopping/cart", HttpMethod.GET, null,
				new ParameterizedTypeReference<ShoppingCartDto>() {
				});
		ShoppingCartDto shoppingCart = responseEntity02.getBody();
		Assertions.assertThat(shoppingCart.getAllCartItems()).hasSize(1);

	}

	@Test
	public void testGivenAddCarItemApiCallWhenCarAddedToCartNoErrorOccurs() {
		final CarDto theCar = new CarDto("1", "2", "Maserati", "Coupe", "2005", "19957.71", "false", "2017-11-14",
				"false");
		ResponseEntity<Void> responseEntity = testRestTemplate.exchange(
				"http://localhost:" + thePort + "/api/shopping/cart", HttpMethod.POST, new HttpEntity<>(theCar),
				new ParameterizedTypeReference<Void>() {
				});
		HttpStatus status = responseEntity.getStatusCode();
		Assertions.assertThat(status.value()).isEqualTo(HttpStatus.OK.value());

	}

	@Test
	public void testGivenRemoveCarItemApiCallWhenCarRemovedFromCartNoErrorOccurs() {
		final CarDto theCar = new CarDto("1", "1", "Volkswagen", "Jetta III", "1995", "12947.52", "true", "2018-09-18",
				"false");
		ResponseEntity<Void> responseEntity01 = testRestTemplate.exchange(
				"http://localhost:" + thePort + "/api/shopping/cart", HttpMethod.POST, new HttpEntity<>(theCar),
				new ParameterizedTypeReference<Void>() {
				});
		HttpStatus status01 = responseEntity01.getStatusCode();
		Assertions.assertThat(status01.value()).isEqualTo(HttpStatus.OK.value());

		ResponseEntity<Void> responseEntity02 = testRestTemplate.exchange(
				"http://localhost:" + thePort + "/api/shopping/cart/1/1", HttpMethod.DELETE, null,
				new ParameterizedTypeReference<Void>() {
				});
		HttpStatus status02 = responseEntity02.getStatusCode();
		Assertions.assertThat(status02.value()).isEqualTo(HttpStatus.OK.value());

	}

	@Test
	public void testGivenClearAllCartItemsApiCallWhenCarRemovedFromCartNoErrorOccurs() {
		final CarDto theCar01 = new CarDto("3", "1", "Ford", "Expedition EL", "2008", "27323.42", "false", "2018-07-03",
				"false");
		ResponseEntity<Void> responseEntity01 = testRestTemplate.exchange(
				"http://localhost:" + thePort + "/api/shopping/cart", HttpMethod.POST, new HttpEntity<>(theCar01),
				new ParameterizedTypeReference<Void>() {
				});
		HttpStatus status01 = responseEntity01.getStatusCode();
		Assertions.assertThat(status01.value()).isEqualTo(HttpStatus.OK.value());
		final CarDto theCar02 = new CarDto("2", "1", "Chevrolet", "Corvette", "2004", "20019.64", "true", "2018-01-27",
				"false");
		ResponseEntity<Void> responseEntity02 = testRestTemplate.exchange(
				"http://localhost:" + thePort + "/api/shopping/cart", HttpMethod.POST, new HttpEntity<>(theCar02),
				new ParameterizedTypeReference<Void>() {
				});
		HttpStatus status02 = responseEntity02.getStatusCode();
		Assertions.assertThat(status02.value()).isEqualTo(HttpStatus.OK.value());

		ResponseEntity<ShoppingCartDto> responseEntity03 = testRestTemplate.exchange(
				"http://localhost:" + thePort + "/api/shopping/cart/delete/all", HttpMethod.DELETE, null,
				new ParameterizedTypeReference<ShoppingCartDto>() {
				});
		HttpStatus status03 = responseEntity03.getStatusCode();
		ShoppingCartDto shoppingCart = responseEntity03.getBody();
		Assertions.assertThat(status03.value()).isEqualTo(HttpStatus.OK.value());
		Assertions.assertThat(shoppingCart.getTotalCartAmount()).isEqualTo("0");
		Assertions.assertThat(shoppingCart.getAllCartItems()).hasSize(0);

	}
}
