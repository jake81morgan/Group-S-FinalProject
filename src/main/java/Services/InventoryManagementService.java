package Services;

import java.util.ArrayList;

import Models.Ingredient;

public class InventoryManagementService {

	private ArrayList<Ingredient> inventory;
	
	public InventoryManagementService() {
		this.inventory = new ArrayList<Ingredient>();
	}
	
	public void reorderInventory() {
		for (Ingredient ingredient : inventory) {
			if(ingredient.getQuantity() < ingredient.getOrderThreshold()) {
				System.out.println("Placing order for " + 100 + " of " + ingredient.getName() + " from supplier: " + ingredient.getSupplier());
				ingredient.setQuantity(ingredient.getQuantity() + 100);
			}
		}
		
	}	
	
	public ArrayList<Ingredient> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Ingredient> inventory) {
		this.inventory = inventory;
	}
	
	
	
}
