package org.swe_group.ice_tracker.order_entry;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    // Customer name: Allowing hyphenated names
    @NotNull(message = "Customer name cannot be null")
    @Size(min = 2, max = 50, message = "Customer name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+([ '-][a-zA-Z]+)*$", message = "Invalid customer name")
    private String name;

    // Shipping and Billing Addresses (assuming the Address class is already validated)
    @NotNull(message = "Shipping address cannot be null")
    private Address shippingAddress;

    @NotNull(message = "Billing address cannot be null")
    private Address billingAddress;

    // Customer status
    @NotNull(message = "Customer status cannot be null")
    private CustomerStatus status;
}
