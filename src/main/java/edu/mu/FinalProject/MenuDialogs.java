package edu.mu.FinalProject;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Services.MenuManagementService;
import Models.MenuItem;
import Enums.MenuCategory;

public class MenuDialogs extends JDialog {
	private JTextField menuItemNameField;
	private JTextField menuItemDescriptionField;
	private JTextField menuItemPriceField;
	private JTextField menuItemCategoryField;
	private JTextField MenuItemIDField;
	private static final long serialVersionUID = 1L;

	public MenuDialogs() {
	}

	public void AddMenuItemDialog(MenuManagementService MenuService) {
		setTitle("Add Menu Item");
		setSize(600, 200);
		setLayout(new GridLayout(6, 2));
		
		JLabel menuItemNameLabel = new JLabel("Menu Item Name:");
		JLabel menuItemDescriptionLabel = new JLabel("Description:");
		JLabel menuItemPriceLabel = new JLabel("Price:");
		JLabel menuItemCategoryLabel = new JLabel("Category(MAIN,APPETIZERS, or DESSERTS):");
		JLabel MenuItemIDLabel = new JLabel("Menu Item ID:");


		menuItemNameField = new JTextField();
		menuItemDescriptionField = new JTextField();
		menuItemPriceField = new JTextField();
		menuItemCategoryField = new JTextField();
		MenuItemIDField = new JTextField();

		add(menuItemNameLabel);
		add(menuItemNameField);
		add(menuItemDescriptionLabel);
		add(menuItemDescriptionField);
		add(menuItemPriceLabel);
		add(menuItemPriceField);
		add(menuItemCategoryLabel);
		add(menuItemCategoryField);
		add(MenuItemIDLabel);
		add(MenuItemIDField);

		JButton AddMenuItemButton = new JButton("Add Menu Item");
		JButton cancelButton = new JButton("cancel");
		AddMenuItemButton.addActionListener(e -> {
            String itemName = menuItemNameField.getText();
            String description = menuItemDescriptionField.getText();
            double price = Double.parseDouble(menuItemPriceField.getText());
            String category = menuItemCategoryField.getText();
            int MenuItemID = Integer.parseInt(MenuItemIDField.getText());
            MenuCategory menuCategory = null;
            if(category.equals(MenuCategory.APPETIZERS)) {
            	menuCategory = MenuCategory.APPETIZERS;
            }
            else if(category.equals(MenuCategory.MAIN)) {
            	menuCategory = MenuCategory.MAIN;
            }
            else if(category.equals(MenuCategory.DESSERTS)) {
            	menuCategory = MenuCategory.DESSERTS;
            }
            MenuItem Item = new MenuItem(MenuItemID, itemName, description, price, menuCategory);
            MenuService.addMenuItem(Item);
			dispose();
			remove(menuItemNameLabel);
			remove(menuItemNameField);
			remove(menuItemDescriptionLabel);
			remove(menuItemDescriptionField);
			remove(menuItemPriceLabel);
			remove(menuItemPriceField);
			remove(menuItemCategoryLabel);
			remove(menuItemCategoryField);
			remove(AddMenuItemButton);
			remove(MenuItemIDLabel);
			remove(MenuItemIDField);
			remove(cancelButton);
		});
		cancelButton.addActionListener(e -> {
			dispose();
			remove(MenuItemIDLabel);
			remove(MenuItemIDField);
			remove(menuItemNameLabel);
			remove(menuItemNameField);
			remove(menuItemDescriptionLabel);
			remove(menuItemDescriptionField);
			remove(menuItemPriceLabel);
			remove(menuItemPriceField);
			remove(menuItemCategoryLabel);
			remove(menuItemCategoryField);
			remove(AddMenuItemButton);
			remove(cancelButton);
		});

		add(AddMenuItemButton);
		add(cancelButton);
	}

	public void RemoveMenuItem(MenuManagementService MenuService) {
		setTitle("Remove Menu Item");
		setSize(400, 100);
		setLayout(new GridLayout(2, 2));

		JLabel MenuItemIDLabel = new JLabel("Menu Item ID:");
		MenuItemIDField = new JTextField();

		add(MenuItemIDLabel);
		add(MenuItemIDField);

		JButton RemoveMenuItem = new JButton("Remove Menu Item");
		JButton cancelButton = new JButton("cancel");
		RemoveMenuItem.addActionListener(e -> {
			int MenuItemID = Integer.parseInt(MenuItemIDField.getText());
			MenuService.removeMenuItem(MenuItemID);
			dispose();
			remove(MenuItemIDLabel);
			remove(MenuItemIDField);
			remove(RemoveMenuItem);
		});
		cancelButton.addActionListener(e -> {
			dispose();
			
			remove(MenuItemIDLabel);
			remove(MenuItemIDField);
			remove(RemoveMenuItem);
			remove(RemoveMenuItem);
			remove(cancelButton);
		});

		add(RemoveMenuItem);
		add(cancelButton);

	}
}
