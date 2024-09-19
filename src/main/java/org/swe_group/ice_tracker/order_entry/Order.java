package org.swe_group.ice_tracker.order_entry;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import java.util.*;

@Getter
@Setter
public class Order {
    private String orderNumber;

    @NotNull(message = "Customer cannot be null")
    private Customer customer;

    @NotNull(message = "Order date cannot be null")
    @PastOrPresent(message = "Order date must be in the past or present")
    private Date orderDate;

    private List<LineItem> lineItems = new ArrayList<>();

    private double totalCost;

    private OrderStatus status;

    // Constructor
    public Order(String orderNumber, Customer customer, Date orderDate, OrderStatus status) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
        calculateTotal();
    }

    // Method to add a line item
    public void addLineItem(LineItem item) {
        lineItems.add(item);
        calculateTotal();
    }

    // Method to remove a line item
    public void removeLineItem(LineItem item) {
        lineItems.remove(item);
        calculateTotal();
    }

    // Method to calculate total cost of the order
    private void calculateTotal() {
        this.totalCost = lineItems.stream().mapToDouble(LineItem::calculateTotalCost).sum();
    }
}
