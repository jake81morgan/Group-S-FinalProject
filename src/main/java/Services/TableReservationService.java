package Services;

import Models.Table;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TableReservationService {
	private List<Table> tables;

	public TableReservationService() {
		this.tables = new ArrayList<>();
		initializeTables();
	}

	// Initialize All Tables(10) with capabilities of seating 6 people
	private void initializeTables() {
		// Loop to initialize all the tables
		for (int i = 1; i <= 10; i++) {
			tables.add(new Table(i, 6));
		}
	}

	// @return the tables
	public List<Table> getAllTables() {
		return tables;
	}

	// @return the getTableByNumber
	public Table getTableByNumber(int tableNumber) {
		for (Table table : tables) {
			if (table.getTableNumber() == tableNumber) {
				return table;
			}
		}
		// Table was not found
		return null;
	}

	// Method to book a table for specific date and time
	public boolean bookTable(int tableNumber, int customerCount, String customerName, DayOfWeek reservationDate, LocalTime reservationTime) {
		Table table = getTableByNumber(tableNumber);
		Table tableAdjacent = getTableByNumber(tableNumber + 1);

		if (customerCount <= table.getCapacity()) {
			if (table != null && !table.isReserved() && table.getCapacity() >= customerCount) {
				// Set table information for Table
				table.setReserved(true);
				table.setCustomerName(customerName);
				table.setReservationDate(reservationDate);
				table.setReservationTime(reservationTime);
				return true;// Booking was successful
			}
		} else if (customerCount <= 2 * table.getCapacity()) {
			if (table != null && tableAdjacent != null && !table.isReserved() && !tableAdjacent.isReserved()) {
				// Set table information for Table 1
				table.setReserved(true);
				table.setCustomerName(customerName);
				table.setReservationDate(reservationDate);
				table.setReservationTime(reservationTime);

				// Set table information for Table 2
				tableAdjacent.setReserved(true);
				tableAdjacent.setCustomerName(customerName);
				tableAdjacent.setReservationDate(reservationDate);
				tableAdjacent.setReservationTime(reservationTime);
				return true;// Booking was successful
			}
		}

		return false;// Booking was unsuccessful
	}

	// Method to handle cancellation of a reservation
	public boolean cancelReservation(String customerName) {
		for (Table table : tables) {
			if (table.isReserved() && table.getCustomerName().equals(customerName)) {
				table.setReserved(false);
				table.setCustomerName(null);
			}
		}
		return false;
	}

	// Method to display Available Tables
	public void availableTables() {
		System.out.println("The following tableNumbers are available: ");
		for (Table table : tables) {
			if (table.isReserved()) {

			} else {
				System.out.print(table.getTableNumber() + ", ");
			}
		}
	}

	public void confirmReservation(boolean tableIsReserved, int tableNumber) {
		if (tableIsReserved) {
			System.out.println("Table " + tableNumber + " has succesfully been reserved");
		} else {
			System.out.println("Table " + tableNumber + " was unable to be reserved");
		}
	}

	public void viewReservationDetails(String customerName) {
		System.out.println("The following reservation is labeled under the name: " + customerName);
		for (Table table : tables) {
			if (table.isReserved() && table.getCustomerName().equals(customerName)) {
				System.out.println("The table number is : " + table.getTableNumber());
				System.out.println("The table date is : " + table.getReservationDate());
				System.out.println("The table date is : " + table.getReservationTime());
			}
		}
	}
}