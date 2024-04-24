package Services;

import java.awt.Menu;
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

	
	// Getters and Setters
	
	public void manageOrderStatus(int orderID, OrderStatus status) {

		Order order = new Order();
		
		try {
			
			order = orders.get(orderID);
			order.setOrderStatus(status);
			orders.set(orderID, order);
			System.out.println("Order status changed to " + order.getOrderStatus());
			
		} catch(IndexOutOfBoundsException e) {
			
			System.out.println("Order with id + " + orderID + " does not exist...");
			
		}
		
	}
	
	/**
	 * TODO: This function applies a discount to the order specified
	 * @param orderID
	 * @param discount
	 */
	public void applyDiscount(int orderID, double discount) {
		Order order = new Order();
		
		try {
			
			order = orders.get(orderID);
			order.setOrderDiscount(discount);
			calculateOrderPrice(order);
			orders.set(orderID, order);
			
		} catch(IndexOutOfBoundsException e) {
			
			System.out.println("Order with id + " + orderID + " does not exist...");
			
		}
	}
	
	/**
	 * TODO: This function calculates and returns the price of the bill split in a specified way.
	 * @param orderID
	 * @param split
	 */
	public void splitBill(int orderID, int split) {
		Order order = new Order();
		
		try {
			
			order = orders.get(orderID);
			calculateOrderPrice(order);
			System.out.println("When split " + split + " ways, the price "+ order.getFinalPrice() + "/person.");
			
		} catch(IndexOutOfBoundsException e) {
			
			System.out.println("Order with id + " + orderID + " does not exist...");
			
		}
	}
	
	/**
	 * TODO: Calculates the total price and price with discount added of all menu items ordered.
	 * @param order
	 */
	public void calculateOrderPrice(Order order) {
		
		// Calculates total price of all menu items ordered
		double totalPrice = 0;
		for(MenuItem item : order.getOrderItems()) {
			totalPrice += item.getPrice();
		}
		
		// Calculates and sets the total and final price with the discount
		double discount = 1 - order.getOrderDiscount();
		order.setTotalPrice(totalPrice);
		order.setFinalPrice(totalPrice * discount);
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

}
