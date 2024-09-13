package org.swe_group.ice_tracker.order_entry;
import lombok.NonNull;

import java.util.UUID;

@lombok.Getter
public class Customer {

    private Long customerId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    @lombok.Setter
    private String name;
    @lombok.Setter
    private String shippingAddress;
    @lombok.Setter
    private String billingAddress;
    //preferred customer, ok customer, shaky customer doesn’t always pay on time
    @lombok.Setter
    private CustomerType customerStatus;

    private Customer(String name, String shippingAddress, String billingAddress, CustomerType customerStatus) {
        this.name = name;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.customerStatus = customerStatus;
    }

    public static Customer getInstance(@NonNull String name, @NonNull String shippingAddress, @NonNull String billingAddress, CustomerType customerStatus) {
        return new Customer(name, shippingAddress, billingAddress, customerStatus);
    }
}
