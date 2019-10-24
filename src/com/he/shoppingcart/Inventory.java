package com.he.shoppingcart;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Inventory {

	private static final Inventory INSTANCE = new Inventory();
	
	private final Map<Product, Integer> INVENTORY_ITEMS = new HashMap<>();
	
	private Inventory() {
		/**/
	}
	
	public static Inventory getInstance() {
		return INSTANCE;
	}

	public void addItems(Map<Product, Integer> items) throws Exception{
		
		for(Entry<Product, Integer> entry : items.entrySet()) {
			if(entry.getValue() <= 0) {
				throw new Exception("Items to be added must be greater than zero.");
			}
			
			INVENTORY_ITEMS.merge(entry.getKey(), entry.getValue(), (t, u) -> t+u);
		}
	}
	
	public void removeItems(Map<Product, Integer> items) throws Exception {
		
		Product product = null;
		Integer count = null;
		Integer currCount = null;
		Integer remainingCount = null;
		
		for(Entry<Product, Integer> entry : items.entrySet()) {
			
			product = entry.getKey();
			count = entry.getValue();
			
			if(INVENTORY_ITEMS.containsKey(product)){
				currCount = INVENTORY_ITEMS.get(product);
				
				if(count > currCount) {
					throw new Exception("Items to be removed is more than available in the inventory");
				}else if(count <= 0){
					throw new Exception("Items to be removed must be greater than zero.");
				}else {
					remainingCount = currCount - count;
					
					if(remainingCount == 0) {
						INVENTORY_ITEMS.remove(product);
					}else {
						INVENTORY_ITEMS.replace(product, remainingCount);
					}
				}
				
			}
		}
	}
	
	public Integer getAvailableAmount(Product product) {
		return INVENTORY_ITEMS.getOrDefault(product, 0);
	}
	
}