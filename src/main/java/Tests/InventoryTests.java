package Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Models.Ingredient;
import Services.InventoryManagementService;
import static org.junit.jupiter.api.Assertions.*;

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
}