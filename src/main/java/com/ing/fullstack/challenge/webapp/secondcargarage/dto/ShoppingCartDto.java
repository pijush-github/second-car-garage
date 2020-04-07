package com.ing.fullstack.challenge.webapp.secondcargarage.dto;

import java.util.List;

public class ShoppingCartDto {
	
	private String totalCartAmount;
	private List<String> allCartItems;
	
	public ShoppingCartDto() {}
	
	public ShoppingCartDto(final String totalCartAmount, final List<String> allCartItems) {
		this.setTotalCartAmount(totalCartAmount);
		this.setAllCartItems(allCartItems);
	}
	
	public String getTotalCartAmount() {
		return totalCartAmount;
	}
	public void setTotalCartAmount(String totalCartAmount) {
		this.totalCartAmount = totalCartAmount;
	}
	public List<String> getAllCartItems() {
		return allCartItems;
	}
	public void setAllCartItems(List<String> allCartItems) {
		this.allCartItems = allCartItems;
	}

}
