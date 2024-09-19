package org.swe_group.ice_tracker.inventory_management;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Setter
public class InventoryItem {
    private Product product;
    private int availableQuantity, reservedQuantity;

    public InventoryItem(Product product) {
        this.product = product;
        this.availableQuantity = 0;
        this.reservedQuantity = 0;
    }

    // Method to add stock
    public void addStock(int quantity) {
        this.availableQuantity += quantity;
    }

    // Method to reserve stock
    public void reserveStock(int quantity) {
        if (this.availableQuantity >= quantity) {
            this.availableQuantity -= quantity;
            this.reservedQuantity += quantity;
        } else {
            throw new IllegalArgumentException("Insufficient available stock to reserve");
        }
    }

    // Method to release reserved stock back to available
    public void releaseReservedStock(int quantity) {
        if (this.reservedQuantity >= quantity) {
            this.reservedQuantity -= quantity;
            this.availableQuantity += quantity;
        } else {
            throw new IllegalArgumentException("Insufficient reserved stock to release");
        }
    }
}

