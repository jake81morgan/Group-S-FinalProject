package edu.mu.FinalProject;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import Services.OrderProcessingService;
import Models.MenuItem;
import Enums.OrderStatus;

public class OrderDialogs extends JDialog {
	private static final long serialVersionUID = 1L;

	public OrderDialogs() {
	}

    public void takeOrder(OrderProcessingService orderService, ArrayList<MenuItem> orderItems) {
        int orderID = orderService.takeOrder(orderItems);
        JOptionPane.showMessageDialog(null, "Order number is " + orderID, "Order Taken", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean manageOrder(OrderProcessingService orderService, int orderID, OrderStatus status) {
        boolean success = orderService.manageOrderStatus(orderID, status);
        if (success) {
            JOptionPane.showMessageDialog(null, "Order status changed to " + status, "Order Status Changed", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Order with ID " + orderID + " does not exist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }
}
