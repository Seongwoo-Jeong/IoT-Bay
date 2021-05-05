 package uts.isd.model.dao;

import uts.isd.model.Shipment;
import uts.isd.model.ShipmentDetails;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeongseongwoo
 */
public class ShipmentDBManager 
{
    
   private Statement sm;
   
   public ShipmentDBManager(Connection conn) throws SQLException            
   {
       sm = conn.createStatement();
   }
   
   /* Retrieving shipment information with shipment id and shipment date */
   
   public Shipment findShipment (int id, String date) throws SQLException 
   {
       String fetch = "Select shipmentid, shipmentdate, shipmentstatus, couriername, trackingnumber,  s.shipmentdetailsid From Shipment S  , Shipment_Details SD Where S.Shipmentdetailsid = SD.shipmentdetailsid and Sd.useraccountid =" + id;
       
       ResultSet resultSet = sm.executeQuery (fetch);
       
       while (resultSet.next())
       { 
           int shipmentID = resultSet.getInt(1); 
           String shipmentDate = resultSet.getString(2);
           
           if (shipmentID == id && shipmentDate.equals(date)) 
           {
               String shipmentStatus = resultSet.getString(3);
               String courierName = resultSet.getString(4);
               String trackingNumber = resultSet.getString(5);
               int shipmentDetailsID = resultSet.getInt(6);
               int orderID = resultSet.getInt(7);
               Shipment shipment = new Shipment (shipmentDate, shipmentStatus, courierName, trackingNumber, shipmentDetailsID , orderID);
               shipment.setShipmentID(id);
               return shipment;
           }
       }
       return null;
   }

   /* Shipment contains shipmentDetails id, which is a foreign key, Requirements in assignment on shipment management (edit, delete or update button in JSP) */
   
   
   public ShipmentDetails findShipmentDetails (int id) throws SQLException 
   {
       String fetch = "select * from IOTBAYUSER.SHIPMENT_DETAILS where SHIPMENTDETAILSID =" + id;
       ResultSet resultSet = sm.executeQuery(fetch);
       
       while (resultSet.next()) 
       { 
           int shipmentDetailsID = resultSet.getInt(1);
           
           if(shipmentDetailsID == id) 
           {
               String streetNameNumber = resultSet.getString(2);
               String suburb = resultSet.getString(3);
               int postcode = resultSet.getInt(4);
               String state = resultSet.getString(5);
               ShipmentDetails shipmentDetails = new ShipmentDetails(streetNameNumber, suburb, postcode, state);
               return shipmentDetails;
           }
       }
       return null;
   }
   
   
   /* Assignment2 Requirements (create or add details in shipment feature), userAccount ID is generated */ 
   
   public void addShipmentDetails(String streetNameNumber, String suburb, int postcode, String state, int userAccountID) throws SQLException           
   {
       sm.executeUpdate("INSERT INTO IOTBAYUSER.SHIPMENT_DETAILS (STREETNAMENUMBER, SUBURB, POSTCODE, STATE, USERACCOUNTID)  VALUES ('" + streetNameNumber +  "', '"  + suburb + "', " + postcode + ", '" + state + "'," + userAccountID + ")");
   }
 
   /* Assignment2 Requirements (updat details in shipment feature), following significants will be updated by the user */
   
   public void updateShipmentDetails(int shipmentDetailsID, String streetNameNumber, String suburb, int postcode, String state) throws SQLException
   {
       sm.executeUpdate("UPDATE IOTBAYUSER.SHIPMENT_DETAILS SET STREETNAMENUMBER='" + streetNameNumber + "', SUBURB='" + suburb + "',POSTCODE=" + postcode + ", STATE='"  + state + "' where SHIPMENTDETAILSID =" + shipmentDetailsID);
   }
   
   /* Assignment2 Requirements (delete details in shipment feature), shipmentDetails id is issued to delete a desired detail */
   
   public void deleteShipmentDetails (int shipmentDetailID) throws SQLException
   {
       sm.executeUpdate("DELETE FROM IOTBAYUSER.SHIPMENT_DETAILS WHERE SHIPMENTDETAILSID =" +  shipmentDetailID);
   } 

   
   /* Get shipmentDetails ID */
   
   public int getShipmentDetailID (String streetNameNumber, String suburb, int postcode, String state, int userAccountID) throws SQLException
   {
       String fetch = "select * from IOTBAY.SHIPMENT_DETAILS where userAccount =" + userAccountID + "and streetNameNumber=' " + streetNameNumber + "' and SUBURB='" + suburb  + "and POSTCODE " + postcode + "and STATE='" + state + "'";
       ResultSet resultSet = sm.executeQuery (fetch);
       
       while (resultSet.next()) 
       {
           int id = resultSet.getInt (1);
           return id;
       }
       return 0;
   }
   
//////////////////////////////////////////////////////////////////////////////////////////////// -\n
   public ArrayList<Shipment> fectShipment(int id) throws SQLException 
   {
        String fetch = "Select shipmentid, shipmentdate, shipmentstatus, couriername, trackingnumber, s.shipmentdetailsid from Shipment S, Shipment_Details SD Where Sp.Shipmentdetailsid = SD.shipmentdetailsid and Sd.useraccountid =" + id;
        ResultSet resultSet = sm.executeQuery(fetch);
        ArrayList <Shipment> table = new ArrayList();
        
        while (resultSet.next()) 
        {
            int shipmentID = resultSet.getInt(1);
            String shipmentDate = resultSet.getString (2);
            String shipmentStatus = resultSet.getString(3);
            String courierName = resultSet.getString(4);            
            String trackingNumber = resultSet.getString(5);
            int shipmentDetailsID = resultSet.getInt(6);
            int orderID = resultSet.getInt(7);
            Shipment shipment = new Shipment (shipmentDate, shipmentStatus, courierName,  trackingNumber, shipmentDetailsID, orderID);
            shipment.setShipmentID(shipmentID);
            table.add(shipment);
        }
        
        if (!table.isEmpty())
        {
            return table;
        } 
        
        else             
        {
            return null;
        }
    }   
   
   //////////////////////////////////////////////////////////////////////////////////////////////// -\n
   public ArrayList<ShipmentDetails> fectShipmentDetails(int id) throws SQLException
   {
       String fetch = "select * from SHIPMENT_DETAILS where USERACCOUNTID =" + id;
       ResultSet resultSet = sm.executeQuery(fetch);
       ArrayList<ShipmentDetails> table = new ArrayList();
         
       while (resultSet.next()) 
       {
           if (id == resultSet.getInt(6))
           {
           int shipmentDetailsID = resultSet.getInt(1);
           String streetNameNumber = resultSet.getString(2);
           String suburb = resultSet.getString(3);
           int postCode = resultSet.getInt(4);
           String state = resultSet.getString(5);
           ShipmentDetails shipmentDetails = new ShipmentDetails(streetNameNumber, suburb, postCode, state);
           shipmentDetails.setShipmentDetailsID(shipmentDetailsID);
           table.add(shipmentDetails);
           }
       }
       
       if (!table.isEmpty())
       {
       return table;
       } 
       
       else 
       {
           return null;
       }
   }
   
}
