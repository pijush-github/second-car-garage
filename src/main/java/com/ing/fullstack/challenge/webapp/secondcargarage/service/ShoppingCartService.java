package com.ing.fullstack.challenge.webapp.secondcargarage.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Vehicle;
import com.ing.fullstack.challenge.webapp.secondcargarage.dto.CarDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.dto.ShoppingCartDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.util.ShoppingCartCacheUtil;

@Service
public class ShoppingCartService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartService.class);

	//private static final Map<String, Vehicle> shoppingCartCache = new HashMap<>();

	/*
	 * This method is used to populates the entire cart-cache detail
	 */
	public ShoppingCartDto getItemDetailFromCart() {
		final Map<String, Vehicle> shoppingCartCache = ShoppingCartCacheUtil.getInstance().getShoppingCartCache();
		LOGGER.info("ShoppingCartService.getCartDetail() invocation started");
		List<String> items = new ArrayList<>();
		List<BigDecimal> priceList = new ArrayList<>();
		shoppingCartCache.entrySet().forEach(v -> {
			items.add(v.getValue().getMake() + "-" + v.getValue().getModel());
			priceList.add(BigDecimal.valueOf(v.getValue().getPrice()));
		});
		final String totalPrice = priceList.stream().reduce(BigDecimal.ZERO, BigDecimal::add).toPlainString();
		ShoppingCartDto theShoppingCartDto = new ShoppingCartDto(totalPrice, items);
		return theShoppingCartDto;
	}

	/*
	 * This method is used to add individual Car into cart-cache
	 */
	public Optional<Vehicle> addToCart(final CarDto inCar) {
		final Map<String, Vehicle> shoppingCartCache = ShoppingCartCacheUtil.getInstance().getShoppingCartCache();
		LOGGER.info("ShoppingCartService.getCartDetail() invocation started");
		final Vehicle theVehicle = new Vehicle(Long.valueOf(inCar.getId()), inCar.getMake(), inCar.getModel(),
				Long.valueOf(inCar.getYear_model()), Double.valueOf(inCar.getPrice()),
				Boolean.valueOf(inCar.getLicensed()).booleanValue(), inCar.getDate_added());
		final Vehicle theStoredVehicle = shoppingCartCache.put(inCar.getParentId()+inCar.getId(), theVehicle);
		return Optional.ofNullable(theStoredVehicle);
	}

	/*
	 * This method is used to remove individual Car from cart-cache
	 */
	public Optional<Vehicle> removeFromCart(final String parent, final String child) {
		final Map<String, Vehicle> shoppingCartCache = ShoppingCartCacheUtil.getInstance().getShoppingCartCache();
		LOGGER.info("ShoppingCartService.getCartDetail() invocation started");
		final Vehicle theVehicle = shoppingCartCache.remove(parent+child);
		return Optional.ofNullable(theVehicle);
	}

	/*
	 * This method is used to find specific Car is already stored under cart-cache
	 */
	public boolean isPresentUnderCart(final String inKey) {
		final Map<String, Vehicle> shoppingCartCache = ShoppingCartCacheUtil.getInstance().getShoppingCartCache();
		return shoppingCartCache.keySet().stream().anyMatch(k -> k.equals(inKey));
	}

	/*
	 * This method is used to empty the cart-cache
	 */
	public @NotNull ShoppingCartDto emptyCart() {
		final Map<String, Vehicle> shoppingCartCache = ShoppingCartCacheUtil.getInstance().getShoppingCartCache();
		shoppingCartCache.clear();
		return new ShoppingCartDto(String.valueOf(0),new ArrayList<>());
	}
	
}
