package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Models.MenuItem;
import Enums.MenuCategory;
import Services.MenuManagementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuManagementServiceTests {

    private MenuManagementService service;

    @BeforeEach
    void setUp() {
        service = new MenuManagementService();
    }

    @Test
    void testAddMenuItem() {
        MenuItem newItem = new MenuItem(1, "Pasta", "Delicious Italian pasta", 8.99, MenuCategory.MAIN);
        service.addMenuItem(newItem);
        assertTrue(service.getMenuItems().contains(newItem), "Menu item should be added");
    }
    
    @Test
    void testRemoveMenuItem() {
        MenuItem item = new MenuItem(1, "Burger", "Classic burger", 5.99, MenuCategory.MAIN);
        service.addMenuItem(item); // Adding the item first
        boolean result = service.removeMenuItem(1); // Attempt to remove
        assertTrue(result, "Item should be removed successfully");
        assertFalse(service.getMenuItems().contains(item), "Item should no longer exist in the menu list");
    }
    
    @Test
    void testUpdateMenuItem() {
        MenuItem originalItem = new MenuItem(2, "Salad", "Green salad", 3.99, MenuCategory.APPETIZERS);
        service.addMenuItem(originalItem);
        MenuItem updatedItem = new MenuItem(2, "Updated Salad", "Fresh green salad", 4.99, MenuCategory.APPETIZERS);
        service.updateMenuItem(updatedItem);

        MenuItem resultItem = service.getMenuItems().stream()
                                .filter(item -> item.getId() == 2)
                                .findFirst()
                                .orElse(null);
        
        assertNotNull(resultItem, "Updated item should exist");
        assertEquals("Updated Salad", resultItem.getName(), "Name should be updated");
        assertEquals("Fresh green salad", resultItem.getDescription(), "Description should be updated");
        assertEquals(4.99, resultItem.getPrice(), "Price should be updated");
    }
}
