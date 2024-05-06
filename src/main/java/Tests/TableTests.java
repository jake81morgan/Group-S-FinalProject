package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Models.Table;
import Services.TableReservationService;

import org.junit.Before;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class TableTests {
    private TableReservationService tableReservationService;

    @Before
    public void setUp() {
        tableReservationService = new TableReservationService();
    }

    @Test
    public void testGetAllTables() {
    	System.out.println("Testing GetAllTables");
        List<Table> tables = tableReservationService.getAllTables();
        assertNotNull(tables);
        assertEquals(10, tables.size());
    }

    @Test
    public void testGetTableByNumber() {
    	System.out.println("Testing GetTableByNumber");
        Table table = tableReservationService.getTableByNumber(1);
        assertNotNull(table);
        assertEquals(1, table.getTableNumber());
    }

    @Test
    public void testBookTable() {
    	System.out.println("Testing BookTable");
        boolean booked = tableReservationService.bookTable(1, 4, "John", DayOfWeek.MONDAY, LocalTime.of(14, 0));
        assertTrue(booked);

        // Test booking with invalid input
        boolean bookedInvalid = tableReservationService.bookTable(1, 0, "", DayOfWeek.MONDAY, null);
        assertFalse(bookedInvalid);
    }

    @Test
    public void testCancelReservation() {
    	System.out.println("Testing CancelReservation");
        // Assume "John" has already booked a table
    	tableReservationService.bookTable(1, 4, "John", DayOfWeek.MONDAY, LocalTime.of(14, 0));
        boolean canceled = tableReservationService.cancelReservation("John");
        assertTrue(canceled);

        // Test cancellation with invalid input
        boolean canceledInvalid = tableReservationService.cancelReservation("");
        assertFalse(canceledInvalid);
    }

    @Test
    public void testAvailableTables() {
        // No tables are booked initially
    	System.out.println("Testing AvailableTables");
        tableReservationService.availableTables();

        // Assume a table is booked
        tableReservationService.bookTable(1, 4, "John", DayOfWeek.MONDAY, LocalTime.of(14, 0));
        tableReservationService.availableTables();
    }

    @Test
    public void testViewReservationDetails() {
    	System.out.println("Testing ViewReservationDetails");
    	tableReservationService.bookTable(1, 4, "John", DayOfWeek.MONDAY, LocalTime.of(14, 0));
        // Assume "John" has already booked a table
        String details = tableReservationService.viewReservationDetails("John");
        System.out.println(details);
        assertNotNull(details);
        tableReservationService.cancelReservation("John");

        // Test viewing details with invalid input
        String detailsInvalid = tableReservationService.viewReservationDetails("");
        assertNull(detailsInvalid);
    }
}
