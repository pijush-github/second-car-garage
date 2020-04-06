package com.ing.fullstack.challenge.webapp.secondcargarage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Car;
import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Location;
import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Vehicle;
import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Warehouse;
import com.ing.fullstack.challenge.webapp.secondcargarage.error.ResourceNotFoundException;
import com.ing.fullstack.challenge.webapp.secondcargarage.repository.WarehouseRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class WarehouseCarServiceTest {

	@Mock
	private WarehouseRepository theWarehouseRepository;

	@Mock
	private ShoppingCartService theShoppingCartService;

	@InjectMocks
	private WarehouseCarService theWarehouseCarService = new WarehouseCarService();

	@BeforeEach
	void setUp() throws Exception {
		when(theWarehouseRepository.findAll()).thenReturn(prepareWarehouseList());
		when(theWarehouseRepository.findById(1l)).thenReturn(Optional.of(prepareWarehouseList().get(0)));
		when(theShoppingCartService.isPresentUnderCart(anyString())).thenReturn(false);
	}

	private List<Warehouse> prepareWarehouseList() {
		final List<Warehouse> wHouses = new ArrayList<>();
		final Vehicle wAv1 = new Vehicle(Long.valueOf(1l), "Volkswagen", "Jetta III", Long.valueOf(1995),
				Double.valueOf(12947.52), true, "2018-09-18");
		final Vehicle wAv2 = new Vehicle(Long.valueOf(2l), "Chevrolet", "Corvette", Long.valueOf(2004),
				Double.valueOf(20019.64), true, "2018-01-27");
		final Vehicle wAv3 = new Vehicle(Long.valueOf(3l), "Ford", "Expedition EL", Long.valueOf(2008),
				Double.valueOf(27323.42), false, "2018-07-03");
		final Car wAc = new Car("West wing", Arrays.asList(wAv1, wAv2, wAv3));
		final Location wAl = new Location(new BigDecimal("47.13111"), new BigDecimal("-61.54801"));
		final Warehouse wA = new Warehouse(Long.valueOf(1l), "Warehouse A", wAl, wAc);
		wHouses.add(wA);
		return wHouses;
	}

	@Test
	void testWhenGetAllWraehouseCarsCallAssertionEqualsMatchWithListSize() {
		assertEquals(3, ((Collection<?>) theWarehouseCarService.getAllWraehouseCars()).size());
	}

	@Test
	void testWhenGetCarDetailCallAssertionNotNullPassesAndAssertionEqualsMatchWithCarAttributes() {
		assertNotNull(theWarehouseCarService.getCarDetail("1", "1"));
		assertEquals("1", theWarehouseCarService.getCarDetail("1", "1").getId());
		assertEquals("Jetta III", theWarehouseCarService.getCarDetail("1", "1").getModel());
		assertEquals("Warehouse A", theWarehouseCarService.getCarDetail("1", "1").getName());
	}

	@Test
	void testWhenGetCarDetailCallAssertionThrowsCatchException() {
		ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
			theWarehouseCarService.getCarDetail("2", "2");
		});
		String expectedMessage = "Wearhouse is not found";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

}
