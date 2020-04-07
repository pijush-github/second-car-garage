/**
 * 
 */
package com.ing.fullstack.challenge.webapp.secondcargarage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Vehicle;
import com.ing.fullstack.challenge.webapp.secondcargarage.dto.CarDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.error.APIRequestProcessingException;
import com.ing.fullstack.challenge.webapp.secondcargarage.error.ResourceStorageException;
import com.ing.fullstack.challenge.webapp.secondcargarage.util.ShoppingCartCacheUtil;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ShoppingCartServiceTest {

	@InjectMocks
	private ShoppingCartService theShoppingCartService = new ShoppingCartService();

	@BeforeEach
	public void setUp() {
		prepareCache();
	}

	private void prepareCache() {
		final Vehicle wAv1 = new Vehicle(Long.valueOf(1l), "Volkswagen", "Jetta III", Long.valueOf(1995),
				Double.valueOf(12947.52), true, "2018-09-18");
		final Vehicle wAv2 = new Vehicle(Long.valueOf(2l), "Chevrolet", "Corvette", Long.valueOf(2004),
				Double.valueOf(20019.64), true, "2018-01-27");
		ShoppingCartCacheUtil.getInstance().getShoppingCartCache().put(String.valueOf(1l)+String.valueOf(1l), wAv1);
		ShoppingCartCacheUtil.getInstance().getShoppingCartCache().put(String.valueOf(1l)+String.valueOf(2l), wAv2);
	}


	@AfterEach
	public void resetSingleton() throws Exception {
		ShoppingCartCacheUtil.getInstance().getShoppingCartCache().clear();
	}
	
	@Test
	void testGivenAddToCartCallAssertionTrueAsAddedSuccessfully() {
		CarDto theCar3 = new CarDto("3","1","Ford","Expedition EL","2008","27323.42","false","2018-07-03","false");
		assertTrue(theShoppingCartService.addToCart(theCar3));
	}
	
	@Test
	void testGivenAddToCartCallAssertionThrowsExceptionAsTriedToAddDuplicateItem() {
		CarDto theCar3 = new CarDto("3","1","Ford","Expedition EL","2008","27323.42","false","2018-07-03","false");
		assertTrue(theShoppingCartService.addToCart(theCar3));
		assertThrows(ResourceStorageException.class, () -> theShoppingCartService.addToCart(theCar3));
	}
	
	@Test
	void testGivenRemoveFromCartCallAssertionTrueAsRemovedSuccessfully() {
		assertTrue(theShoppingCartService.removeFromCart("1", "2"));
	}
	
	@Test
	void testGivenRemoveFromCartCallAssertionThrowsExceptionAsTriedToAddDuplicateItem() {
		assertTrue(theShoppingCartService.removeFromCart("1", "2"));
		assertThrows(APIRequestProcessingException.class, () -> theShoppingCartService.removeFromCart("1", "2"));
	}
	
	@Test
	void testGivenGetItemDetailFromCartCallAssertionNotNullAndAssertionEqualsTotalPriceAndMatchListSize() {
		assertNotNull(theShoppingCartService.getItemDetailFromCart());
		assertEquals("32967.16", theShoppingCartService.getItemDetailFromCart().getTotalCartAmount());
		assertEquals(2, theShoppingCartService.getItemDetailFromCart().getAllCartItems().size());
	}
	
	@Test
	void testGivenIsPresentUnderCartCallAssertionTrueAsItemPresent() {
		assertTrue(theShoppingCartService.isPresentUnderCart("11"));
	}

	
	@Test
	void testGivenEmptyCartCallAssertionNotNullAndSizeZeroAsMatched() {
		assertNotNull(theShoppingCartService.emptyCart());
		assertEquals(0, theShoppingCartService.emptyCart().getAllCartItems().size());
	}

}
