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
		int tableCount = 10;
		int customerCount = 6;
		for (int i = 1; i <= tableCount; i++) {
			tables.add(new Table(i, customerCount));
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
	public boolean bookTable(int tableNumber, int customerCount, String customerName, DayOfWeek reservationDate,
			LocalTime reservationTime) {
		if (customerCount <= 0 || customerName == null || customerName.isEmpty() || reservationDate == null
				|| reservationTime == null) {
			return false; // Invalid input, booking unsuccessful
		}

		Table table = getTableByNumber(tableNumber);
		Table tableAdjacent = getTableByNumber(tableNumber + 1);

		if (table == null || customerCount > 2 * table.getCapacity() || table.isReserved()) {
			confirmReservation(table.isReserved(), table.getTableNumber());// Booking was successful for Table 1
			return false; // Table not found, too many customers, or already reserved
		}

		if (customerCount <= table.getCapacity()) {
			// Set table information for Table
			table.setReserved(true);
			table.setCustomerName(customerName);
			table.setReservationDate(reservationDate);
			table.setReservationTime(reservationTime);
			confirmReservation(table.isReserved(), table.getTableNumber());// Booking was successful
			return true; // Booking was successful
		} else if (tableAdjacent != null && !tableAdjacent.isReserved()) {
			// Set table information for Table 1
			table.setReserved(true);
			table.setCustomerName(customerName);
			table.setReservationDate(reservationDate);
			table.setReservationTime(reservationTime);
			confirmReservation(table.isReserved(), table.getTableNumber());// Booking was successful for Table 1
			// Set table information for Table 2
			tableAdjacent.setReserved(true);
			tableAdjacent.setCustomerName(customerName);
			tableAdjacent.setReservationDate(reservationDate);
			tableAdjacent.setReservationTime(reservationTime);
			confirmReservation(tableAdjacent.isReserved(), tableAdjacent.getTableNumber());// Booking was successful for
																							// Table 2
			return true; // Booking was successful
		}
		confirmReservation(table.isReserved(), table.getTableNumber());// Booking was successful for Table 1
		return false; // Booking was unsuccessful
	}

	// Method to handle cancellation of a reservation
	public boolean cancelReservation(String customerName) {
		if (customerName == null || customerName.isEmpty()) {
			return false; // Invalid input
		}

		boolean canceled = false;
		for (Table table : tables) {
			if (table.isReserved() && table.getCustomerName().equals(customerName)) {
				System.out.println(table.getCustomerName() + "'s reservation at table " + table.getTableNumber()
						+ " has successfully been cancelled");
				table.setReserved(false);
				table.setCustomerName(null);
				canceled = true;
			}
		}
		return canceled;
	}

	// Method to display Available Tables
	public void availableTables() {
		System.out.println("The following tableNumbers are available: ");
		for (Table table : tables) {
			if (!table.isReserved()) {
				System.out.print(table.getTableNumber() + ", ");
			}
		}
		System.out.print("\n");
	}

	public void confirmReservation(boolean tableIsReserved, int tableNumber) {
		if (tableIsReserved) {
			System.out.println("Table " + tableNumber + " has successfully been reserved");
		} else {
			System.out.println("Table " + tableNumber + " was unable to be reserved");
		}
	}

	public String viewReservationDetails(String customerName) {
		if (customerName == null || customerName.isEmpty()) {
			return null; // Invalid input
		}

		System.out.println("The following reservation is labeled under the name: " + customerName);
		for (Table table : tables) {
			if (table.isReserved() && table.getCustomerName().equals(customerName)) {
				String details = ("The table number is : " + table.getTableNumber() + "\n" + "The table date is : "
						+ table.getReservationDate() + "\n" + "The table date is : " + table.getReservationTime());
				return details;
			}
		}
		return null;
	}
}
