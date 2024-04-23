package Models;

public class Table {
	private int tableNumber;
	private int capacity;
	private boolean isReserved;
	private String customerName;

	public Table(int tableNumber, int Seats) {
		// TODO Auto-generated constructor stub
	}

	// @return the tableNumber
	public int getTableNumber() {
		return tableNumber;
	}

	// @param tableNumber the tableNumber to set
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	// @return the capacity
	public int getCapacity() {
		return capacity;
	}

	// @param capacity the capacity to set
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	// @return the isReserved
	public boolean isReserved() {
		return isReserved;
	}

	// @param isReserved the isReserved to set
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	// @return the customerName
	public String getCustomerName() {
		return customerName;
	}

	// @param customerName the customerName to set
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
