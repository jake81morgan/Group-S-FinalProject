package Controllers;

import Models.Table;
import Services.TableReservationService;

import java.util.List;

public class TableController {
	private TableReservationService TableReservationService;

	// @return the getAllTables
	public List<Table> getAllTables() {
		return TableReservationService.getAllTables();
	}
	// @return the getTableByNumber
		public Table getTableByNumber(int tableNumber) {
			return TableReservationService.getTableByNumber(tableNumber);
		}

	// @param tableReservationService the tableReservationService to set
	public void setTableReservationService(TableReservationService tableReservationService) {
		this.TableReservationService = tableReservationService;
	}

}
