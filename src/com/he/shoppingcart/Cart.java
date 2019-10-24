package com.he.shoppingcart;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cart {
	
	private final Map<Product, Integer> CHECKOUT_MAP = new HashMap<>();
	
	public Cart() {
		/**/
	}
	
	public void addItem(Product product, Integer amount) throws Exception{
		
		if(amount < 1) {
			throw new Exception("Quantity to be added to cart must be greater than zero.");
		}
		
		CHECKOUT_MAP.merge(product, amount, (t, u) -> t + u);
	}
	
	public void removeItem(Product product) throws Exception {
		if(CHECKOUT_MAP.containsKey(product)){
			throw new Exception("Items to be removed is not available in the cart.");
		}else {
			CHECKOUT_MAP.remove(product);
		}
	}
	
	public void generateInvoice() {
		
		double totalPrice = 0.0;
		double price = 0.0;
		
		Product product = null;
		Integer quantity = null;
		
		for(Entry<Product, Integer> entry : CHECKOUT_MAP.entrySet()) {
			product = entry.getKey();
			quantity = entry.getValue();
			
			price = product.getPrice() * quantity;
			totalPrice += price;
			
			System.out.println(product.getName() + " " + quantity 
					+ " " + String.format("%.2f", price));
		}
		
		System.out.println("Total price: " + String.format("%.2f", totalPrice));
	}
	
	public void checkOut() {
		
		try {
			Inventory.getInstance().removeItems(CHECKOUT_MAP);
		} catch (Exception e) {
			e.printStackTrace();
		}

		CHECKOUT_MAP.clear();
	}
	public void emptyCart() {
		CHECKOUT_MAP.clear();
	}
	
}