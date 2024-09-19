package org.swe_group.ice_tracker.shipment_tracking;

import org.swe_group.ice_tracker.order_entry.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Shipment {
    private String shipmentId;             // Unique ID for the shipment
    private Order order;                   // The order associated with the shipment
    private int numberOfBoxes;             // Number of boxes in the shipment
    private boolean isPartialShipment;     // Indicator if this is a partial shipment
    // Date the shipment was sent
    private Date shipmentDate, expectedDeliveryDate;     // Expected delivery date
    private Date actualDeliveryDate;       // Actual delivery date (set when delivered)
    private ShipmentStatus status;         // Status of the shipment (e.g., PROCESSING, DELIVERED)
    private String shippingMethod; // The method used to ship (e.g., air, ground)
    private ShippingVendor shippingVendor; // Vendor used for shipping

    public void updateStatus(ShipmentStatus newStatus) {
        this.status = newStatus;
        if (newStatus == ShipmentStatus.DELIVERED) this.actualDeliveryDate = new Date();
    }

    public void recordLostOrDamagedShipment(String problemDescription, double cost) {
        // Record the problem and notify the Trouble Ticket system
        notifyTroubleTicketSystem(problemDescription, cost);
    }

    private void notifyTroubleTicketSystem(String problemDescription, double cost) {
        // Logic to notify the Trouble Ticket system about lost or damaged shipment
        System.out.println("Notifying Trouble Ticket system about lost/damaged shipment.");
    }
}
