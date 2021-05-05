package uts.isd.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.dao.*;
import uts.isd.model.Shipment;
import uts.isd.model.ShipmentDetails;
/**
 *
 * @author Jeongseongwoo
 */

public class TestShipmentDB 
{
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private ShipmentDBManager db;

    public static void main (String [] args) throws SQLException
    {
        (new TestShipmentDB()).runQueries();
    }    
    
    public TestShipmentDB ()
    {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new ShipmentDBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestShipmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    private char readChoice()
    {
        System.out.println("Operation CRUDS or * to exit");
        return in.nextLine().charAt(0);
    }
    
    private void runQueries() throws SQLException 
    {
        char c;
        
        while ((c = readChoice()) != '*') {
            switch (c) {
                case 'C': // Implementation of adding shipment  (1)
                    testAdd(4); 
                    break;
                    
                case 'R': // Implementation of Finding shipment using shipmentID and shipmentDate (2) 
                   testRead();
                   break;
                   
                case 'U':  // Finding all shipment (4)
                    findingShipment();
                    break;
                    
                // case 'D' // Optional function | Implementation of Deleting shipment | not required
                    //testDelate();
                   // break;
                    
                case 'S': // Implementation of Showing shipment (3)
                    viewAllShipment(4);
                    break;
                default:
                    System.out.println("Error occured: cannot retrieve the information. Please try again");
                    break;
            }
        }
    }
    
    // case 'c' - adding shipment details
    // \n
     private void testAdd(int id) 
     {
        System.out.print(" Street Name Number: ");
        String streetNameNumber = in.nextLine();
        System.out.print(" Suburb: "); // \n
        String suburb = in.nextLine();
        System.out.print(" Postcode: "); // \n
        int postCode = in.nextInt();
        in.nextLine();
        System.out.print(" State: "); // \n
        String state = in.nextLine();
        try {
            db.addShipmentDetails(streetNameNumber, suburb, postCode, state, id);
        } catch (SQLException ex) {
            Logger.getLogger(TestShipmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(" Following Details of Shipment has been added! ");
    }
     // case 'R' - Finding shipment
        private void testRead () throws SQLException 
        {
        System.out.print("Shipping ID: ");
        int shippingID = in.nextInt();
        in.nextLine();
        System.out.print("Date (DD/MM/YYYY): "); // \n
        String dateS = in.nextLine();
        Shipment shipment = db.findShipment(shippingID, dateS);
        
        if(shipment!= null) 
        {
            System.out.println("     ");
            System.out.println("Shipment ID: " + shippingID +  "\n" + "Shipment Status: " + shipment.getShipmentStatus() + "Courier Name: " + shipment.getCourierName() + "\n" +  "\n" + "Tracking Number: " + shipment.getTrackingNumber());
            ShipmentDetails shipmentD = db.findShipmentDetails(shipment.getShipmentDetailsID());
            System.out.println("Delivery Address: " + shipmentD.getStreetNameNumber() + ", " + shipmentD.getSuburb() + ", " + shipmentD.getPostcode() + ", " + shipmentD.getState() + "");
        } 
        else 
        {
            System.out.println("Error Occorred: shipment cannot be found");
        }
    } 
     
        // case "U" | finding all shipment
    private void findingShipment () 
    {
        System.out.print("User ID: ");
        int userID = in.nextInt();
        in.nextLine();
         try {
            ArrayList<Shipment> shipment = db.fectShipment(userID);
            System.out.println("Stored Shipping Details:");
            System.out.println("                        ");
            System.out.printf("%-10s %-20s %-30s %-20s %-20s \n","Shipment ID", "Shipment Date", "Shipment Status", "Courier Name", "tracking Number" );
            System.out.println("                         ");
            shipment.stream().forEach((shipments) -> { 
                System.out.printf("%-10d %-20s %-30s %-20s %-3s \n",shipments.getShipmentID(), shipments.getShipmentDate(), shipments.getShipmentStatus(), shipments.getCourierName(), shipments.getTrackingNumber());
            });
            System.out.println();      
        } catch (SQLException ex) {
            Logger.getLogger(TestShipmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
     
    private void viewAllShipment(int id) throws SQLException 
    {
        try {
            ArrayList<ShipmentDetails> shipmentdetails = db.fectShipmentDetails(id);
            System.out.println("Stored Shipping Details:");
            System.out.println("                        ");
            System.out.printf("%-10s %-20s %-30s %-20s %-20s \n","ID", "StreetNameNumber", "Suburb", "Postcode", "State");
            System.out.println("                        ");
            shipmentdetails.stream().forEach((shipmentdetail) -> { 
                System.out.printf("%-10d %-20s %-30s %-20d %-3s \n",shipmentdetail.getShipmentDetailsID(), shipmentdetail.getStreetNameNumber(), shipmentdetail.getSuburb(),shipmentdetail.getPostcode(), shipmentdetail.getState());
            });
            System.out.println();      
        } catch (SQLException ex) {
            Logger.getLogger(TestShipmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
}
