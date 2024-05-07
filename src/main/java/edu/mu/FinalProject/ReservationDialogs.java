package edu.mu.FinalProject;

import java.awt.GridLayout;
import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Services.TableReservationService;

public class ReservationDialogs extends JDialog {
	private JTextField tableNumberField;
	private JTextField customerNameField;
	private JTextField customerCountField;
	private JTextField dateField;
	private JTextField timeField;
	private static final long serialVersionUID = 1L;

	public ReservationDialogs() {
		// Initialize text fields
		tableNumberField = new JTextField();
		customerNameField = new JTextField();
		customerCountField = new JTextField();
		dateField = new JTextField();
		timeField = new JTextField();
	}

	public void BookTableDialog(TableReservationService tableService) {
		setTitle("Book Table");
		setSize(400, 200);
		setLayout(new GridLayout(6, 2));

		JLabel tableNumberLabel = new JLabel("Table Number:");
		JLabel customerNameLabel = new JLabel("Customer Name:");
		JLabel customerCountLabel = new JLabel("Customer Count:");
		JLabel dateLabel = new JLabel("Reservation Date(eg:MONDAY):");
		JLabel timeLabel = new JLabel("Reservation Time(eg:05:30):");

		tableNumberField = new JTextField();
		customerNameField = new JTextField();
		customerCountField = new JTextField();
		dateField = new JTextField();
		timeField = new JTextField();

		add(tableNumberLabel);
		add(tableNumberField);
		add(customerNameLabel);
		add(customerNameField);
		add(customerCountLabel);
		add(customerCountField);
		add(dateLabel);
		add(dateField);
		add(timeLabel);
		add(timeField);

		JButton bookButton = new JButton("Book");
		JButton cancelButton = new JButton("cancel");
		bookButton.addActionListener(e -> {
			int tableNumber = Integer.parseInt(tableNumberField.getText());
			String customerName = customerNameField.getText();
			int customerCount = Integer.parseInt(customerCountField.getText());
			DayOfWeek reservationDate = DayOfWeek.valueOf(dateField.getText().toUpperCase());
			LocalTime reservationTime = LocalTime.parse(timeField.getText());
			tableService.bookTable(tableNumber, customerCount, customerName, reservationDate, reservationTime);
			dispose();
			remove(tableNumberLabel);
			remove(tableNumberField);
			remove(customerNameLabel);
			remove(customerNameField);
			remove(customerCountLabel);
			remove(customerCountField);
			remove(dateLabel);
			remove(dateField);
			remove(timeLabel);
			remove(timeField);
			remove(bookButton);
			remove(cancelButton);
		});
		cancelButton.addActionListener(e -> {
			dispose();
			remove(tableNumberLabel);
			remove(tableNumberField);
			remove(customerNameLabel);
			remove(customerNameField);
			remove(customerCountLabel);
			remove(customerCountField);
			remove(dateLabel);
			remove(dateField);
			remove(timeLabel);
			remove(timeField);
			remove(bookButton);
			remove(cancelButton);
		});

		add(bookButton);
		add(cancelButton);
	}

	public void CancelReservationDialog(TableReservationService tableService) {
		setTitle("Cancel Reservation");
		setSize(400, 100);
		setLayout(new GridLayout(1, 3));

		JLabel customerNameLabel = new JLabel("Customer Name:");
		customerNameField = new JTextField();

		add(customerNameLabel);
		add(customerNameField);

		JButton cancelButton = new JButton("Cancel Reservation");
		cancelButton.addActionListener(e -> {
			String customerName = customerNameField.getText();
			tableService.cancelReservation(customerName);
			dispose();
			remove(customerNameLabel);
			remove(customerNameField);
			remove(cancelButton);
		});

		add(cancelButton);
		
	}

	public void ViewReservationDetailsDialog(TableReservationService tableService) {
		setTitle("View Reservation Details");
		setSize(300, 200);
		setLayout(new GridLayout(3, 2));

		JLabel customerNameLabel = new JLabel("Customer Name:");
		customerNameField = new JTextField();

		add(customerNameLabel);
		add(customerNameField);

		JButton viewButton = new JButton("View Details");
		viewButton.addActionListener(e -> {
			String customerName = customerNameField.getText();
			String details = tableService.viewReservationDetails(customerName);
			if (details != null) {
				JOptionPane.showMessageDialog(this, details, "Reservation Details", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "No reservation found for this customer.", "Reservation Details", JOptionPane.INFORMATION_MESSAGE);
			}
			remove(customerNameLabel);
			remove(customerNameField);
			remove(viewButton);
			dispose();
		});

		add(viewButton);
	}
}
