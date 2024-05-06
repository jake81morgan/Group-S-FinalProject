package edu.mu.FinalProject;

import javax.swing.*;

import Controllers.*;
import Services.*;
import edu.mu.FinalProject.ReservationDialogs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class ManagementGUI extends JFrame implements ActionListener {

	private JPanel mainPanel;
	private JPanel inventoryPanel;
	private JPanel menuPanel;
	private JPanel orderPanel;
	private JPanel tablePanel;

	private JButton inventoryButton;
	private JButton menuButton;
	private JButton orderButton;
	private JButton tableButton;

	private InventoryController inventoryController;
	private MenuController menuController;
	private OrderController orderController;
	private TableController tableController;

	public ManagementGUI() {
		super("Management GUI");
		setSize(400, 400); // Increased width to accommodate larger buttons
		setLocation(700, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initialize controllers
		inventoryController = new InventoryController();
		menuController = new MenuController();
		orderController = new OrderController();
		tableController = new TableController();

		// Main panel
		mainPanel = new JPanel(new GridLayout(4, 1));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adding padding

		// Inventory panel
		inventoryPanel = new JPanel();
		inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));
		inventoryButton = new JButton("Inventory Section");
		inventoryButton.addActionListener(this);
		inventoryButton.setPreferredSize(new Dimension(300, 100)); // Larger button size
		inventoryButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
		inventoryPanel.add(Box.createVerticalGlue()); // Pushes the button to the middle vertically
		inventoryPanel.add(inventoryButton);

		// Menu panel
		menuPanel = new JPanel();
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuButton = new JButton("Menu Section");
		menuButton.addActionListener(this);
		menuButton.setPreferredSize(new Dimension(300, 100)); // Larger button size
		menuButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
		menuPanel.add(Box.createVerticalStrut(20)); // Adds vertical space
		menuPanel.add(menuButton);

		// Order panel
		orderPanel = new JPanel();
		orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));
		orderButton = new JButton("Order Section");
		orderButton.addActionListener(this);
		orderButton.setPreferredSize(new Dimension(300, 100)); // Larger button size
		orderButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
		orderPanel.add(Box.createVerticalStrut(20)); // Adds vertical space
		orderPanel.add(orderButton);

		// Table panel
		tablePanel = new JPanel();
		tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
		tableButton = new JButton("Reservation Section");
		tableButton.addActionListener(this);
		tableButton.setPreferredSize(new Dimension(300, 100)); // Larger button size
		tableButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
		tablePanel.add(Box.createVerticalStrut(20)); // Adds vertical space
		tablePanel.add(tableButton);
		tablePanel.add(Box.createVerticalGlue()); // Pushes the button to the middle vertically

		mainPanel.add(inventoryPanel);
		mainPanel.add(menuPanel);
		mainPanel.add(orderPanel);
		mainPanel.add(tablePanel);

		getContentPane().add(mainPanel);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == inventoryButton) {
			showInventorySection();
		} else if (e.getSource() == menuButton) {
			showMenuSection();
		} else if (e.getSource() == orderButton) {
			showOrderSection();
		} else if (e.getSource() == tableButton) {
			showTableSection();
		}
	}

	private void showInventorySection() {
		JFrame inventoryFrame = new JFrame("Inventory Section");
		JPanel inventoryPanel = new JPanel();
		JButton initializeInventoryButton = new JButton("Initialize Inventory");
		JButton reorderInventoryButton = new JButton("Reorder Inventory");
		JButton generateInventoryReportButton = new JButton("Generate Inventory Report");

		initializeInventoryButton.addActionListener(e -> {
			inventoryController.initializeInventory();
			JOptionPane.showMessageDialog(null, "Inventory Has been Initialized", "Inventory Initialization",
					JOptionPane.INFORMATION_MESSAGE);
		});
		reorderInventoryButton.addActionListener(e -> {
			inventoryController.reOrderInventory();
			JOptionPane.showMessageDialog(null, "Inventory Has been Reordered", "Inventory Ordering",
					JOptionPane.INFORMATION_MESSAGE);
		});
		generateInventoryReportButton.addActionListener(e -> {
			String report = inventoryController.generateInventoryReport();
			JOptionPane.showMessageDialog(null, report, "Inventory Report", JOptionPane.INFORMATION_MESSAGE);
		});

		inventoryPanel.add(initializeInventoryButton);
		inventoryPanel.add(reorderInventoryButton);
		inventoryPanel.add(generateInventoryReportButton);

		inventoryFrame.getContentPane().add(inventoryPanel);
		inventoryFrame.setSize(300, 200);
		inventoryFrame.setVisible(true);
	}

	private void showMenuSection() {
		JFrame menuFrame = new JFrame("Menu Section");
		JPanel menuPanel = new JPanel();
		JButton addMenuItemButton = new JButton("Add Menu Item");
		JButton removeMenuItemButton = new JButton("Remove Menu Item");
		JButton displayMenuItemsButton = new JButton("Display Menu Items");

		addMenuItemButton.addActionListener(e -> {
			// Logic to open a dialog for adding a menu item
			//AddMenuItemDialog dialog = new AddMenuItemDialog();
			// dialog.setVisible(true);
		});

		removeMenuItemButton.addActionListener(e -> {
			// Logic to open a dialog for removing a menu item
			// Example: RemoveMenuItemDialog dialog = new RemoveMenuItemDialog();
			// dialog.setVisible(true);
		});

		displayMenuItemsButton.addActionListener(e -> menuController.displayMenuItems());

		menuPanel.add(addMenuItemButton);
		menuPanel.add(removeMenuItemButton);
		menuPanel.add(displayMenuItemsButton);

		menuFrame.getContentPane().add(menuPanel);
		menuFrame.setSize(300, 200);
		menuFrame.setVisible(true);
	}

	private void showOrderSection() {
		JFrame orderFrame = new JFrame("Order Section");
		JPanel orderPanel = new JPanel();
		JButton takeOrderButton = new JButton("Take Order");
		JButton manageOrderButton = new JButton("Manage Order");
		JButton displayOrdersButton = new JButton("Display Orders");

		takeOrderButton.addActionListener(e -> {
			// Logic to open a dialog for taking an order
			// Example: TakeOrderDialog dialog = new TakeOrderDialog();
			// dialog.setVisible(true);
		});

		manageOrderButton.addActionListener(e -> {
			// Logic to open a dialog for managing an order
			// Example: ManageOrderDialog dialog = new ManageOrderDialog();
			// dialog.setVisible(true);
		});

		displayOrdersButton.addActionListener(e -> orderController.displayOrders());

		orderPanel.add(takeOrderButton);
		orderPanel.add(manageOrderButton);
		orderPanel.add(displayOrdersButton);

		orderFrame.getContentPane().add(orderPanel);
		orderFrame.setSize(300, 200);
		orderFrame.setVisible(true);
	}

	private void showTableSection() {
		JFrame tableFrame = new JFrame("Reservation Section");
		JPanel tablePanel = new JPanel();
		JButton bookTableButton = new JButton("Book Table");
		JButton cancelReservationButton = new JButton("Cancel Reservation");
		JButton availableTablesButton = new JButton("Available Tables");
		JButton viewReservationDetailsButton = new JButton("View Reservation Details");
		
		TableReservationService table = new TableReservationService();
		ReservationDialogs dialog = new ReservationDialogs();

		bookTableButton.addActionListener(e -> {
			// Logic to open a dialog for booking a table
			dialog.BookTableDialog(table);
			dialog.setVisible(true);
		});

		cancelReservationButton.addActionListener(e -> {
			dialog.CancelReservationDialog(table);
			dialog.setVisible(true);
		});

		availableTablesButton.addActionListener(e -> table.availableTables());

		viewReservationDetailsButton.addActionListener(e -> {
			dialog.ViewReservationDetailsDialog(table);
			dialog.setVisible(true);
		});

		tablePanel.add(bookTableButton);
		tablePanel.add(cancelReservationButton);
		tablePanel.add(availableTablesButton);
		tablePanel.add(viewReservationDetailsButton);

		tableFrame.getContentPane().add(tablePanel);
		tableFrame.setSize(300, 200);
		tableFrame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new ManagementGUI());
	}
}