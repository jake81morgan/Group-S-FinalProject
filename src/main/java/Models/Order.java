package Models;

import java.util.ArrayList;

import Enums.OrderStatus;

public class Order {

	private OrderStatus orderStatus;
	private ArrayList<MenuItem> orderItems;
	private double totalPrice;
	private double orderDiscount;
	private double finalPrice;
	private int ID;
	
	public Order(OrderStatus orderStatus, ArrayList<MenuItem> orderItems, double totalPrice, double orderDiscount,
			double finalPrice, int ID) {
		super();
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
		this.totalPrice = totalPrice;
		this.orderDiscount = orderDiscount;
		this.finalPrice = finalPrice;
		this.ID = ID;
	}

	public Order() {
		
	}
	
	public boolean add(MenuItem item) {
		if(orderItems.add(item)) {
			return true;
		}
		return false;
	}
	
	public boolean remove(MenuItem item) {
		if(orderItems.remove(item)) {
			return true;
		} 
		return false;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public ArrayList<MenuItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(ArrayList<MenuItem> orderItems) {
		this.orderItems = orderItems;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getOrderDiscount() {
		return orderDiscount;
	}

	public void setOrderDiscount(double orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	
	
	
	
}
