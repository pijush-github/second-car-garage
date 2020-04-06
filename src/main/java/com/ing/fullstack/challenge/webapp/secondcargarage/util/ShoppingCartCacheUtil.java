package com.ing.fullstack.challenge.webapp.secondcargarage.util;

import java.util.HashMap;
import java.util.Map;

import com.ing.fullstack.challenge.webapp.secondcargarage.domain.Vehicle;

public class ShoppingCartCacheUtil {

	private final Map<String, Vehicle> SHOPPING_CART_CACHE = new HashMap<>();
	
	private ShoppingCartCacheUtil() {}

	private static class CacheStore {
		
		private static final ShoppingCartCacheUtil INSTANCE = new ShoppingCartCacheUtil();
	}

	public static ShoppingCartCacheUtil getInstance() {
		return CacheStore.INSTANCE;
	}

	public Map<String, Vehicle> getShoppingCartCache() {
		return ShoppingCartCacheUtil.getInstance().SHOPPING_CART_CACHE;
	}
}
