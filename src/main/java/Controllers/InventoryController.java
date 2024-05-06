package Controllers;

import Services.InventoryManagementService;

public class InventoryController {

	private InventoryManagementService inventoryService;

	public InventoryController() {
		this.inventoryService = new InventoryManagementService();
	}

	public void initializeInventory() {
		inventoryService.initializeInventory();
	}

	public void reOrderInventory() {
		inventoryService.reorderInventory();
	}

	public String generateInventoryReport() {
		return inventoryService.generateInventoryReport();
	}

}
