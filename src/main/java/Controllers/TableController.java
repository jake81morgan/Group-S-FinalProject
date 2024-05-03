package Controllers;

import Models.Table;
import Services.TableReservationService;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class TableController {
    private TableReservationService tableReservationService;

    public void setTableReservationService(TableReservationService tableReservationService) {
        this.tableReservationService = tableReservationService;
    }

    public List<Table> getAllTables() {
        return tableReservationService.getAllTables();
    }

    public Table getTableByNumber(int tableNumber) {
        return tableReservationService.getTableByNumber(tableNumber);
    }

    public boolean bookTable(int tableNumber, int customerCount, String customerName, DayOfWeek reservationDate, LocalTime reservationTime) {
        return tableReservationService.bookTable(tableNumber, customerCount, customerName, reservationDate, reservationTime);
    }

    public boolean cancelReservation(String customerName) {
        return tableReservationService.cancelReservation(customerName);
    }

    public void availableTables() {
        tableReservationService.availableTables();
    }

    public void confirmReservation(boolean tableIsReserved, int tableNumber) {
        tableReservationService.confirmReservation(tableIsReserved, tableNumber);
    }

    public String viewReservationDetails(String customerName) {
        return tableReservationService.viewReservationDetails(customerName);
    }
}
