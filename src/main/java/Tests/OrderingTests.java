package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.MenuCategory;
import Enums.OrderStatus;
import Models.MenuItem;
import Models.Order;
import Services.OrderProcessingService;

public class OrderingTests {
	
	private OrderProcessingService service;
	
	@BeforeEach
	void setUp() {
		service = new OrderProcessingService();
	}
	
	@Test
	void testTakeOrder() {
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
		service.takeOrder(items);
		assertTrue(service.getOrders().contains(items), "Order has been taken.");
	}
	
	@Test
	void testAddToOrder() {
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        MenuItem newItem = new MenuItem(1, "Pasta", "Delicious Italian pasta", 8.99, MenuCategory.MAIN);
		int orderID = service.takeOrder(items);
		assertTrue(service.getOrders().contains(items), "Order has been taken.");
		assertTrue(service.addToOrder(orderID, newItem), "Item should be added.");
		assertTrue(service.getOrders().get(orderID).getOrderItems().contains(newItem), "Item added successfully");
	}
	
	@Test
	void testRemoveFromOrder() {
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        MenuItem newItem = new MenuItem(1, "Pasta", "Delicious Italian pasta", 8.99, MenuCategory.MAIN);
		int orderID = service.takeOrder(items);
		service.addToOrder(orderID, newItem);
		assertTrue(service.getOrders().contains(items), "Order has been taken.");
		assertTrue(service.removeFromOrder(orderID, newItem), "Item should be removed.");
		assertFalse(service.getOrders().get(orderID).getOrderItems().contains(newItem), "Item removed successfully.");
	}
	
	@Test
	void testManageOrderStatus() {
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
		int orderID = service.takeOrder(items);
		assertTrue(service.manageOrderStatus(orderID, OrderStatus.COMPLETED), "Should be changed to completed.");
		assertEquals(service.getOrders().get(orderID).getOrderStatus(), OrderStatus.COMPLETED, "Order status changed successfully.");
	}
	
	@Test
	void testApplyDiscount() {
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        MenuItem newItem = new MenuItem(1, "Pasta", "Delicious Italian pasta", 100, MenuCategory.MAIN);
		items.add(newItem);
		int orderID = service.takeOrder(items);
		service.applyDiscount(orderID, 0.5);
		assertEquals(50, service.splitBill(orderID, 1));
	}
	
	@Test
	void testSplitBill() {
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        MenuItem newItem = new MenuItem(1, "Pasta", "Delicious Italian pasta", 100, MenuCategory.MAIN);
		items.add(newItem);
		int orderID = service.takeOrder(items);
		assertEquals(20, service.splitBill(orderID, 5), "Bill split correctly.");
	}
	
}
