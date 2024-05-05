package Controllers;

import java.util.ArrayList;

import Enums.OrderStatus;
import Models.MenuItem;
import Models.Order;
import Services.OrderProcessingService;

public class OrderController {
	
	private OrderProcessingService orderProcessingService;
	
	public OrderController() {
		this.orderProcessingService = new OrderProcessingService();
	}
	
	public OrderController(ArrayList<Order> orders) {
		this.orderProcessingService = new OrderProcessingService(orders);
	}
	
	public void takeOrder(ArrayList<MenuItem> orderItems) {
		orderProcessingService.takeOrder(orderItems);
	}
	
	public void addToOrder(int orderID, MenuItem item) {
		orderProcessingService.addToOrder(orderID, item);
	}
	
	public void removeFromOrder(int orderID, MenuItem item) {
		orderProcessingService.removeFromOrder(orderID, item);
	}
	
	public void manageOrderStatus(int orderID, OrderStatus status) {
		orderProcessingService.manageOrderStatus(orderID, status);
	}
	
	public void applyDiscount(int orderID, double discount) {
		orderProcessingService.applyDiscount(orderID, discount);
	}
	
	public void splitBill(int orderID, int split) {
		orderProcessingService.splitBill(orderID, split);
	}
	
	public Order getOrderByID(int orderID) {
		ArrayList<Order> orders = new ArrayList<Order>();
		orders = orderProcessingService.getOrders();
		return orders.get(orderID);
	}
	
	public void displayOrders() {
		ArrayList<Order> orders = new ArrayList<Order>();
		orders = orderProcessingService.getOrders();
		for(Order order : orders) {
			System.out.println("Order " + order.getID() + ", Price: " + order.getFinalPrice() + ", Status: " + order.getOrderStatus());
		}
	}
	
	

}
