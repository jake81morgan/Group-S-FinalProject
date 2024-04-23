package Services;

import java.util.ArrayList;

import Enums.OrderStatus;
import Models.MenuItem;
import Models.Order;

public class OrderProcessingService {

	ArrayList<Order> orders;

	public OrderProcessingService(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	public OrderProcessingService() {
		this.orders = new ArrayList<Order>();
	}
	
	/**
	 * TODO: This function take a list of MenuItems and creates an order.
	 * This order is then added to the list of orders with the status of PENDING
	 * @param orderItems
	 */
	public void takeOrder(ArrayList<MenuItem> orderItems) {
		
		// Increments the order ID everytime a new order is created
		int orderID;
		if(orders.isEmpty()) {
			orderID = 0;
		}
		else {
			orderID = orders.size();
		}
		
		// Adds items to order
		Order order = new Order(OrderStatus.PENDING, orderItems, 0, 0, 0, orderID);
		orders.add(order);
		
	}
	
	/**
	 * TODO: This function adds a MenuItem to an order if it is found in the list of orders.
	 * @param orderID
	 * @param item
	 */
	public void addToOrder(int orderID, MenuItem item) {
		
		Order order = new Order();
		
		try {
			order = orders.get(orderID);
			if(order.add(item)) {
					System.out.println("Item added...");
					orders.set(orderID, order);
			} else {
					System.out.println("Item add ERROR...");
			}
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Order with id + " + orderID + " does not exist...");
		} 
	}
	
	/**
	 * TODO: This function removes a MenuItem from an order if it is found in the list of orders.
	 * @param orderID
	 * @param item
	 */
	public void removeFromOrder(int orderID, MenuItem item) {
		
		Order order = new Order();
		
		try {
			order = orders.get(orderID);
			if(order.remove(item)) {
					System.out.println("Item removed...");
					orders.set(orderID, order);
			} else {
					System.out.println("Item removal ERROR...");
			}
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Order with id + " + orderID + " does not exist...");
		} 
	}

	public void manageOrderStatus(int orderID, OrderStatus status) {
		
	}
	
	

}
