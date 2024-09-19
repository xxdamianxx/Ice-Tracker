package org.swe_group.ice_tracker.inventory_management;

import java.util.*;
import lombok.Getter;

@Getter
public class InventoryManager {
    private Map<Product, InventoryItem> inventory = new HashMap<>();
    private Map<Product, Integer> plannedInventory = new HashMap<>();
    private List<InventoryLog> transactionLog = new ArrayList<>();

    // Add stock to actual inventory
    public void addStock(Product product, int quantity, String user) {
        InventoryItem item = inventory.getOrDefault(product, new InventoryItem(product));
        item.addStock(quantity);
        inventory.put(product, item);
        logTransaction(product, quantity, "Added to Inventory", user);
    }

    // Reserve stock for unfilled orders
    public boolean reserveStock(Product product, int quantity, String user) {
        InventoryItem item = inventory.get(product);
        if (item != null && item.getAvailableQuantity() >= quantity) {
            item.reserveStock(quantity);
            logTransaction(product, quantity, "Reserved for Order", user);
            return true;
        }
        return false;
    }

    // Add product to the list of planned inventory
    public void addPlannedInventory(Product product, int quantity, String user) {
        plannedInventory.put(product, plannedInventory.getOrDefault(product, 0) + quantity);
        logTransaction(product, quantity, "Added to Planned Inventory", user);
    }

    // Convert planned inventory to actual inventory
    public void convertPlannedToActual(Product product, String user) {
        int plannedQuantity = plannedInventory.getOrDefault(product, 0);
        if (plannedQuantity > 0) {
            addStock(product, plannedQuantity, user);
            plannedInventory.remove(product);
            logTransaction(product, plannedQuantity, "Planned to Actual Conversion", user);
        }
    }

    // Delete product from inventory
    public void deleteProduct(Product product, String user) {
        inventory.remove(product);
        logTransaction(product, 0, "Deleted from Inventory", user);
    }

    // Log each transaction
    private void logTransaction(Product product, int quantity, String action, String user) {
        InventoryLog log = new InventoryLog(product, quantity, action, user);
        transactionLog.add(log);
    }

    // Track inventory dispositions (Shipped, Defective, Spoilage)
    public void disposeInventory(Product product, int quantity, String disposition, String user) {
        InventoryItem item = inventory.get(product);
        if (item != null) {
            item.reserveStock(quantity); // Temporarily reserve before removing
            logTransaction(product, quantity, "Disposed: " + disposition, user);
            if (disposition.equals("SHIPPED")) {
                // Notify Trouble Ticket system for defects or spoilage if necessary
                // Trigger notification to external subsystem
            }
        }
    }

    // Generate summary reports by week, month, or year
    public void generateSummaryReport(String period) {
        // Implement logic for generating statistical summaries over a specified time frame
        // The time frame can be a week, month, or year
    }
}

