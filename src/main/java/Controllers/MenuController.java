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
	
	public void displaySortedMenuItems() {
	    menuService.sortMenuItemsByPrice();
	    for (MenuItem item : menuService.getMenuItems()) {
	        System.out.println("ID #" + item.getId() + " " + item.getName() + " - " + item.getDescription() + " - $" + item.getPrice());
	    }
	}

	public void displayMenuItems(MenuManagementService Menu) {
		for (MenuItem item : Menu.getMenuItems()) {
			System.out.println("ID #" + item.getId() + " " + item.getName() + " - " + item.getDescription() + " - $"
					+ item.getPrice());
		}
	}
}
