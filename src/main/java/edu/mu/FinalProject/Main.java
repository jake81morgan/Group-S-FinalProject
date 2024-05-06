package edu.mu.FinalProject;

import Models.*;
import Enums.*;
import Services.*;
import java.util.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Instantiate services
        TableReservationService tableService = new TableReservationService();
        InventoryManagementService inventoryService = new InventoryManagementService();
        MenuManagementService menuService = new MenuManagementService();
        OrderProcessingService orderService = new OrderProcessingService();

        // Test TableReservationService
        testTableService(tableService);

        // Test InventoryManagementService
        testInventoryService(inventoryService);

        // Test MenuManagementService
        testMenuService(menuService);

        // Test OrderProcessingService
        testOrderService(orderService);

        // Optionally, integrate GUI here
    }

    // Method to test TableReservationService
    private static void testTableService(TableReservationService tableService) {
        // Test methods here
        // For example:
        tableService.bookTable(1, 4, "John Doe", DayOfWeek.MONDAY, LocalTime.of(18, 30));
        tableService.cancelReservation("John Doe");
        tableService.availableTables();
    }

    // Method to test InventoryManagementService
    private static void testInventoryService(InventoryManagementService inventoryService) {
        // Test methods here
        // For example:
        inventoryService.initializeInventory();
        inventoryService.reorderInventory();
        System.out.println(inventoryService.generateInventoryReport());
    }

    // Method to test MenuManagementService
    private static void testMenuService(MenuManagementService menuService) {
        // Test methods here
        // For example:
        MenuItem item = new MenuItem(1, "Pizza", "Delicious pizza", 10.99, MenuCategory.MAIN);
        menuService.addMenuItem(item);
        menuService.removeMenuItem(1);
    }

    // Method to test OrderProcessingService
    private static void testOrderService(OrderProcessingService orderService) {
        // Test methods here
        // For example:
        orderService.takeOrder(new ArrayList<>()); // Pass list of MenuItems
        orderService.addToOrder(0, new MenuItem(1, "Pizza", "Tasty burger", 8.99, MenuCategory.MAIN));
        orderService.manageOrderStatus(0, OrderStatus.COMPLETED);
    }
}
