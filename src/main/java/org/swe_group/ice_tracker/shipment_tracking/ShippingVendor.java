package org.swe_group.ice_tracker.shipment_tracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShippingVendor {
    private String vendorName;
    private String geographicRegion;
    private String shippingType;
    private double shippingRate;
    private VendorRating rating;
}
