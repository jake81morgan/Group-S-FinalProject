package Services;

import java.util.ArrayList;

import Enums.IngredientNames;
import Models.Ingredient;

public class InventoryManagementService {

	private ArrayList<Ingredient> inventory;
	
	public InventoryManagementService() {
		this.inventory = new ArrayList<Ingredient>();
	}
	
    public void initializeInventory() {
    	for (IngredientNames ingredientName : IngredientNames.values()) {
            Ingredient ingredient = new Ingredient(ingredientName.getDisplayName(), 0, "Sysco", 25);
            inventory.add(ingredient);
        }
    }
	
	public void reorderInventory() {
		for (Ingredient ingredient : inventory) {
			if(ingredient.getQuantity() < ingredient.getOrderThreshold()) {
				System.out.println("Placing order for " + 100 + " of " + ingredient.getName() + " from supplier: " + ingredient.getSupplier());
				ingredient.setQuantity(ingredient.getQuantity() + 100);
			}
		}
		
	}
	
	public String generateInventoryReport() {
        StringBuilder report = new StringBuilder();
        report.append("Inventory Report:\n");
        for (Ingredient ingredient : inventory) {
            report.append("Ingredient: ").append(ingredient.getName()).append(", Quantity: ")
                    .append(ingredient.getQuantity()).append(", Supplier: ").append(ingredient.getSupplier()).append("\n");
        }
        return report.toString();
    }

	public ArrayList<Ingredient> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Ingredient> inventory) {
		this.inventory = inventory;
	}
	
	
	
}
