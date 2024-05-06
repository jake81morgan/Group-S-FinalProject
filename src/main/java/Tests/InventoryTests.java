package Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Models.Ingredient;
import Services.InventoryManagementService;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class InventoryTests {

    private InventoryManagementService inventoryManagementService;

    @BeforeEach
    void setUp() {
        inventoryManagementService = new InventoryManagementService();
        inventoryManagementService.initializeInventory();
    }

    @Test
    void testReorderInventory() {
        inventoryManagementService.reorderInventory();
        for (Ingredient ingredient : inventoryManagementService.getInventory()) {
            if (ingredient.getQuantity() < ingredient.getOrderThreshold()) {
                assertEquals(200, ingredient.getQuantity()); // Assuming reorder adds 100
            }
        }
    }

    @Test
    void testGenerateInventoryReport() {
        String expectedReport = "Inventory Report:\n" +
                                "Ingredient: Sugar, Quantity: 100, Supplier: Sysco\n" +
                                "Ingredient: Salt, Quantity: 100, Supplier: Sysco\n" +
                                "Ingredient: Flour, Quantity: 100, Supplier: Sysco\n" +
                                "Ingredient: Pepper, Quantity: 100, Supplier: Sysco\n";
        assertEquals(expectedReport, inventoryManagementService.generateInventoryReport());
    }
    
    @Test
    public void testAddIngredient() {
        // Add a new ingredient
        inventoryManagementService.addIngredient("New Ingredient", 50, "New Supplier", 20);

        // Get the inventory list
        ArrayList<Ingredient> inventory = inventoryManagementService.getInventory();

        // Check if the new ingredient is added
        boolean found = false;
        for (Ingredient ingredient : inventory) {
            if (ingredient.getName().equals("New Ingredient")) {
                found = true;
                assertEquals("New Ingredient", ingredient.getName());
                assertEquals(50, ingredient.getQuantity());
                assertEquals("New Supplier", ingredient.getSupplier());
                assertEquals(20, ingredient.getOrderThreshold());
                break;
            }
        }
        assertTrue("New ingredient not found in inventory", found);
    }

    @Test
    public void testRemoveIngredient() {
        // Remove an existing ingredient
        inventoryManagementService.removeIngredient("Salt");

        // Get the inventory list
        ArrayList<Ingredient> inventory = inventoryManagementService.getInventory();

        // Check if the ingredient is removed
        boolean found = false;
        for (Ingredient ingredient : inventory) {
            if (ingredient.getName().equals("Salt")) {
                found = true;
                break;
            }
        }
        assertFalse("Ingredient 'Salt' still found in inventory", found);
    }
}