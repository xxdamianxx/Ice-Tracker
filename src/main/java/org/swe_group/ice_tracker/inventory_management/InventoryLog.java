package org.swe_group.ice_tracker.inventory_management;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InventoryLog {
    private Product product;
    private int quantity;
    private String action;
    private String user;
    private Date timestamp;

    public InventoryLog(Product product, int quantity, String action, String user) {
        this.product = product;
        this.quantity = quantity;
        this.action = action;
        this.user = user;
        this.timestamp = new Date(); // Log the current timestamp
    }
}

