package org.swe_group.ice_tracker.order_entry;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class Address {
    @NotNull(message = "Street cannot be null")
    private String street;

    @NotNull(message = "City cannot be null")
    private String city;

    @NotNull(message = "State cannot be null")
    private String state;

    @NotNull(message = "Zip cannot be null")
    private String zip;

    // Constructor with validation
    public Address(@NotNull String street, @NotNull String city, @NotNull String state, @NotNull String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}

