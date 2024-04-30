package Models;

public class Ingredient {  
	
	private String name;
	private int quantity;
	private String supplier;
	private int orderThreshold;
	
	
	public Ingredient(String name, int quantity, String supplier, int orderThreshold) {
		this.name = name;
		this.quantity = quantity;
		this.supplier = supplier;
		this.orderThreshold = orderThreshold;
	}
	

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public int getOrderThreshold() {
		return orderThreshold;
	}

	public void setOrderThreshold(int orderThreshold) {
		this.orderThreshold = orderThreshold;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}   
    
}
