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

	// @param tables the tables to set
	public void initializeTables(List<Table> tables) {
		this.tables = tables;
	}
}