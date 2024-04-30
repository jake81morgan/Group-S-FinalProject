package Models;

import java.util.List;

public class Supplier {

	private String name;
	private String address;
	private String contactInfo;
	private List<String> productsSupplied;
	
	
	public Supplier(String name, String address, String contactInfo, List<String> productsSupplied) {
		this.name = name;
		this.address = address;
		this.contactInfo = contactInfo;
		this.productsSupplied = productsSupplied;
	}
	
	public boolean add(String product) {
		if(productsSupplied.add(product)) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getContactInfo() {
		return contactInfo;
	}
	
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	public List<String> getProductsSupplied() {
		return productsSupplied;
	}
	
	public void setProductsSupplied(List<String> productsSupplied) {
		this.productsSupplied = productsSupplied;
	}
	
	
}
