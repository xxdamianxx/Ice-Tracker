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

}
