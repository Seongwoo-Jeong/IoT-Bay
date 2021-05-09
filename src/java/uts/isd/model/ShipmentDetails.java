/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

/**
 *
 * @author  Jeongseongwoo
 */

public class ShipmentDetails 
{
    private String streetNameNumber;
    private String suburb;
    private int postcode;
    private String state;
    private int shipmentDetailsID;

    public ShipmentDetails(String streetNameNumber, String suburb, int postcode, String state)
    {
        this.streetNameNumber = streetNameNumber;
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
    }
    
    public ShipmentDetails(final int shipmentDetailsID, final String streetNameNumber, final String suburb, final int postcode, final String state) {
        this.shipmentDetailsID = shipmentDetailsID;
        this.streetNameNumber = streetNameNumber;
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
    }
    

    public int getShipmentDetailsID() 
    {
        return shipmentDetailsID;
    }

    public void setShipmentDetailsID(int shipmentDetailsID)
    {
        this.shipmentDetailsID = shipmentDetailsID;
    }

    public String getStreetNameNumber()
    {
        return streetNameNumber;
    }

    public void setStreetAddress(String streetNameNumber) 
    {
        this.streetNameNumber = streetNameNumber;
    }

    public String getSuburb() 
    {
        return suburb;
    }

    public void setSuburb(String suburb) 
    {
        this.suburb = suburb;
    }

    public int getPostcode() 
    {
        return postcode;
    }

    public void setPostcode(int postcode)
    {
        this.postcode = postcode;
    }

    public String getState() 
    {
        return state;
    }

    public void setState(String state) 
    {
        this.state = state;
    }
    
    public String addressForm(int shipmentDetailsID) 
    {
        String fullform = streetNameNumber + ", " + suburb + ", " + postcode + ", " + state;
        return fullform;
    }
}