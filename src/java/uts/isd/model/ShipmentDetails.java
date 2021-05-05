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
    private int userAccountID;

    public ShipmentDetails(String streetNameNumber, String suburb, int postcode, String state)
    {
        this.streetNameNumber = streetNameNumber;
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
    }
    
    public ShipmentDetails(String streetNameNumber, String suburb, int postcode, String state, int userID) {
        this.streetNameNumber = streetNameNumber;
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
        this.userAccountID = userID;
    }

    public int getShipmentDetailsID() 
    {
        return shipmentDetailsID;
    }

    public void setShipmentDetailsID(int shipmentDetailsID)
    {
        this.shipmentDetailsID = shipmentDetailsID;
    }
    
    public int getUserAccountID() { return this.userAccountID; }
    
    public void setUserAccountID(final int id) { this.userAccountID = id; }

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