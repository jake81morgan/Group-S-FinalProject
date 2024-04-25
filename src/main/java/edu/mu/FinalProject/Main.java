package edu.mu.FinalProject;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
        // Create and display the GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RestaurantGUI();
            }
        });
    }
}