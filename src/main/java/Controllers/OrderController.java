package Controllers;

import java.util.ArrayList;

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
	
	

}
