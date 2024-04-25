package Models;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Table {
	private int tableNumber;
	private int capacity;
	private boolean isReserved;
	private String customerName;
	private DayOfWeek reservationDate;
	private LocalTime reservationTime;

	public Table(int tableNumber, int capacity) {
		this.tableNumber = tableNumber;
		this.capacity = capacity;
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

	// @return the reservationDate
	public DayOfWeek getReservationDate() {
		return reservationDate;
	}

	// @param reservationDate the reservationDate to set
	public void setReservationDate(DayOfWeek reservationDate) {
		this.reservationDate = reservationDate;
	}

	// @return the reservationTime
	public LocalTime getReservationTime() {
		return reservationTime;
	}

	// @param reservationTime the reservationTime to set
	public void setReservationTime(LocalTime reservationTime) {
		this.reservationTime = reservationTime;
	}

}
