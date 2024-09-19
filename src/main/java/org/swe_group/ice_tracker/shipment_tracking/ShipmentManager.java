package org.swe_group.ice_tracker.shipment_tracking;

import java.util.*;

/**
 * Class responsible for managing the list of shipments and shipping vendors.
 */
public class ShipmentManager {
    private List<Shipment> shipments;                           // List of all shipments
    private Map<String, ShippingVendor> shippingVendors;        // Map of vendors by geographic region

    /**
     * Constructor to initialize the ShipmentManager.
     */
    public ShipmentManager() {
        this.shipments = new ArrayList<>();
        this.shippingVendors = new HashMap<>();
    }

    /**
     * Adds a new shipment to the system.
     *
     * @param shipment The shipment to be added
     */
    public void addShipment(Shipment shipment) {
        shipments.add(shipment);
    }

    /**
     * Queries shipments based on customer name, destination, shipment date, or expected delivery date.
     *
     * @param customerName Name of the customer
     * @param destination Destination of the shipment
     * @param shipmentDate Date the shipment was sent
     * @param expectedDeliveryDate Expected delivery date
     * @return A list of shipments that match the criteria
     */
    public List<Shipment> queryShipments(String customerName, String destination, Date shipmentDate, Date expectedDeliveryDate) {
        List<Shipment> result = new ArrayList<>();
        for (Shipment shipment : shipments) {
            if (matchesCriteria(shipment, customerName, destination, shipmentDate, expectedDeliveryDate)) {
                result.add(shipment);
            }
        }
        return result;
    }

    /**
     * Helper method to check if a shipment matches the given criteria.
     */
    private boolean matchesCriteria(Shipment shipment, String customerName, String destination, Date shipmentDate, Date expectedDeliveryDate) {
        // Logic to match based on criteria (simplified for now)
        return true;
    }

    /**
     * Generates a report on active shipments.
     */
    public void generateActiveShipmentsReport() {
        // Generate a report of all shipments that are still active
    }

    /**
     * Generates a report on delivered shipments.
     */
    public void generateDeliveredShipmentsReport() {
        // Generate a report of all shipments that have been delivered
    }

    /**
     * Generates a report on lost or damaged shipments.
     */
    public void generateLostOrDamagedShipmentsReport() {
        // Generate a report of all shipments that are lost or damaged
    }
}

