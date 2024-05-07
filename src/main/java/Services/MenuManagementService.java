package Services;

import Models.MenuItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MenuManagementService {
    private List<MenuItem> menuItems = new ArrayList<>();

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public boolean removeMenuItem(int itemId) {
        return menuItems.removeIf(item -> item.getId() == itemId);
    }

    public void updateMenuItem(MenuItem updatedItem) {
        menuItems.forEach(item -> {
            if (item.getId() == updatedItem.getId()) {
                item.setName(updatedItem.getName());
                item.setDescription(updatedItem.getDescription());
                item.setPrice(updatedItem.getPrice());
                item.setCategory(updatedItem.getCategory());
            }
        });
    }
    
    public void sortMenuItemsByPrice() {
        Collections.sort(menuItems, Comparator.comparingDouble(MenuItem::getPrice));
    }

    public List<MenuItem> getMenuItems() {
        return new ArrayList<>(menuItems);
    }
}
