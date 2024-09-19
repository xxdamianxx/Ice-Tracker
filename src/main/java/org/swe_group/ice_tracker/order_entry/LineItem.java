package org.swe_group.ice_tracker.order_entry;

import lombok.AllArgsConstructor;
import org.swe_group.ice_tracker.inventory_management.Product;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LineItem {
    private Product product;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    private double cost;

    // Method to calculate total cost for the line item
    public double calculateTotalCost() {
        return this.quantity * this.cost;
    }
}
