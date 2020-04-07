package com.ing.fullstack.challenge.webapp.secondcargarage.controller;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.fullstack.challenge.webapp.secondcargarage.dto.CarDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.dto.ShoppingCartDto;
import com.ing.fullstack.challenge.webapp.secondcargarage.service.ShoppingCartService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/shopping")
public class ShoppingCartRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartRestController.class);

	@Autowired
	private ShoppingCartService theShoppingCartService;

	/*
	 * This GET method is exposed as REST-Api to get ShoppingCart resource
	 */
	@GetMapping(value = { "", "/cart" })
	public @NotNull ShoppingCartDto getShoppingCartDetail() {
		LOGGER.info("ShoppingCartRestController.getCartDetail() invocation started");
		return theShoppingCartService.getItemDetailFromCart();
	}

	/*
	 * This POST method is exposed as REST-Api to add Car Resource under
	 * shopping-cart
	 */
	@PostMapping(value = { "", "/cart" })
	public void addCarItem(@RequestBody CarDto car) {
		LOGGER.info("ShoppingCartRestController.addCarItem() invocation started");
		theShoppingCartService.addToCart(car);
	}

	/*
	 * This DELET method is exposed as REST-Api to remove Car Resource from
	 * shopping-cart
	 */
	@DeleteMapping(value = { "", "/cart/{parent}/{child}" })
	public void removeCarItem(@PathVariable("parent") String parent, @PathVariable("child") String child) {
		LOGGER.info("ShoppingCartRestController.removeCarItem() invocation started");
		theShoppingCartService.removeFromCart(parent, child);
	}

	/*
	 * This DELET method is exposed as REST-Api to clear entire shopping-cart
	 */
	@DeleteMapping(value = { "", "/cart/delete/all" })
	public @NotNull ShoppingCartDto clearAllCartItems() {
		LOGGER.info("ShoppingCartRestController.clearAllCartItems() invocation started");
		return theShoppingCartService.emptyCart();
	}
}
