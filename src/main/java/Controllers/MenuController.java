package Controllers;

import Models.MenuItem;
import Enums.MenuCategory;
import Services.MenuManagementService;

public class MenuController {
    private MenuManagementService menuService;

    public MenuController() {
        this.menuService = new MenuManagementService();
    }
    
    public void addMenuItem(int id, String name, String description, double price, MenuCategory category) {
        MenuItem newItem = new MenuItem(id, name, description, price, category);
        menuService.addMenuItem(newItem);
    }
    
    public void removeMenuItem(int id) {
        menuService.removeMenuItem(id);
    }
    
    public void updateMenuItem(int id, String name, String description, double price, MenuCategory category) {
        MenuItem updatedItem = new MenuItem(id, name, description, price, category);
        menuService.updateMenuItem(updatedItem);
    }
    
    public void displayMenuItems() {
        for (MenuItem item : menuService.getMenuItems()) {
            System.out.println(item.getName() + " - " + item.getDescription() + " - $" + item.getPrice());
        }
    }
}
