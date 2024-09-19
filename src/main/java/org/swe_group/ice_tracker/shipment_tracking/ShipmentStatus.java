package org.swe_group.ice_tracker.shipment_tracking;

public enum ShipmentStatus {
    PROCESSING,  // Shipment is being prepared
    IN_TRANSIT,  // Shipment is on its way
    DELIVERED,   // Shipment has been delivered to the customer
    LOST,        // Shipment was lost
    DAMAGED      // Shipment was damaged during transit
}
