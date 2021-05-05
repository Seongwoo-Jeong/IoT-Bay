package uts.isd.model;

/**
 * Shipment java
 * @author Jeongseongwoo
 */

public class Shipment {
    private String shipmentDate;
    private String ShipmentStatus;
    private String courierName;
    private String trackingNumber;
    private int shipmentID; 
    private int shipmentDetailsID; 
    private int orderID; 

    public Shipment(int shipmentID, String shipmentDate, String ShipmentStatus, String courierName, String trackingNumber, int shipmentDetailsID ,int orderID)
    {
        this.shipmentID = shipmentID;
        this.shipmentDate = shipmentDate;
        this.ShipmentStatus = ShipmentStatus;
        this.courierName = courierName;
        this.trackingNumber = trackingNumber;
        this.shipmentDetailsID = shipmentDetailsID;
        this.orderID = orderID;
    }
    
    public String getShipmentDate() 
    {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }
    
    public String getShipmentStatus() 
    {
        return ShipmentStatus;
    }

    public void setShipmentStatus(String ShipmentStatus)
    {
        this.ShipmentStatus = ShipmentStatus;
    }
    
    public String getCourierName() 
    {
        return courierName;
    }

    public void setCourierName(String courierName) 
    {
        this.courierName = courierName;
    }
    
    public String getTrackingNumber()
    {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber)
    {
        this.trackingNumber = trackingNumber;
    }
    
    public int getShipmentID() 
    {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID)
    {
        this.shipmentID = shipmentID;
    }

    public int getShipmentDetailsID() 
    {
        return shipmentDetailsID;
    }

    public void setShipmentDetailsID(int shipmentDetailsID)
    {
        this.shipmentDetailsID = shipmentDetailsID;
    }
    
    public int getOrderID() 
    {
        return orderID;
    }
    
    public void setOrderID(int orderID) 
    {
        this.orderID = orderID;
    }

    
    
}