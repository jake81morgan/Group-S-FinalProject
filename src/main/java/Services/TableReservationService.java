package Services;

import Models.Table;

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
	public boolean bookTable(int tableNumber, int customerCount, String customerName) {
		Table table = getTableByNumber(tableNumber);
		Table tableAdjacent = getTableByNumber(tableNumber + 1);

		if (customerCount <= table.getCapacity()) {
			if (table != null && !table.isReserved() && table.getCapacity() >= customerCount) {
				table.setReserved(true);
				table.setCustomerName(customerName);
				return true;// Booking was successful
			}
		} else if (customerCount <= 2 * table.getCapacity()) {
			if (table != null && tableAdjacent != null && !table.isReserved() && !tableAdjacent.isReserved()) {
				table.setReserved(true);
				tableAdjacent.setReserved(true);
				table.setCustomerName(customerName);
				tableAdjacent.setCustomerName(customerName);
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
				System.out.print(" " + table.getTableNumber());
			}
		}
	}
}