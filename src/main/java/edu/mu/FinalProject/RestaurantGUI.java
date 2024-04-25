package edu.mu.FinalProject;
import javax.swing.*;

import Services.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class RestaurantGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TableReservationService tableService;

    public RestaurantGUI() {
        // Initialize Table Reservation Service
        tableService = new TableReservationService();

        // Set up the frame
        setTitle("Restaurant Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Create buttons
        JButton viewTablesButton = new JButton("View Available Tables");
        JButton makeReservationButton = new JButton("Make Reservation");
        JButton cancelReservationButton = new JButton("Cancel Reservation");
        JButton viewReservationDetailsButton = new JButton("View Reservation Details");

        // Add action listeners to buttons
        viewTablesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableService.availableTables();
            }
        });

        makeReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a dialog to take reservation information
                int tableNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter table number:"));
                int customerCount = Integer.parseInt(JOptionPane.showInputDialog("Enter number of customers:"));
                String customerName = JOptionPane.showInputDialog("Enter customer name:");
                DayOfWeek reservationDay = DayOfWeek.valueOf(JOptionPane.showInputDialog("Enter reservation day (e.g., MONDAY):"));
                int reservationHour = Integer.parseInt(JOptionPane.showInputDialog("Enter reservation hour:"));
                int reservationMinute = Integer.parseInt(JOptionPane.showInputDialog("Enter reservation minute:"));

                LocalTime reservationTime = LocalTime.of(reservationHour, reservationMinute);

                boolean success = tableService.bookTable(tableNumber, customerCount, customerName, reservationDay, reservationTime);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Reservation successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Reservation unsuccessful. Please try again.");
                }
            }
        });

        cancelReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = JOptionPane.showInputDialog("Enter customer name to cancel reservation:");
                boolean success = tableService.cancelReservation(customerName);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Reservation canceled successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No reservation found for the given customer name.");
                }
            }
        });

        viewReservationDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = JOptionPane.showInputDialog("Enter customer name to view reservation details:");
                tableService.viewReservationDetails(customerName);
            }
        });

        // Add buttons to the frame
        add(viewTablesButton);
        add(makeReservationButton);
        add(cancelReservationButton);
        add(viewReservationDetailsButton);

        // Set frame visibility
        setVisible(true);
    }
}
