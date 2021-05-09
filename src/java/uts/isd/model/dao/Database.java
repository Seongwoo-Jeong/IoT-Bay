/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import uts.isd.model.Shipment;
import uts.isd.model.ShipmentDetails;

/**
 *
 * @author Jeongseongwoo
 */

public class Database {

    protected String host = "localhost";
    protected String database = "IoTBaydb";
    protected String username = "iotbayuser";
    protected String password = "1234";
    protected int port = 1527;
    protected Connection connection;

    private int retries = 0;
    private int closeIgnores = 0;

    public void resetConnection() {
        closeConnection();
        openConnection();
    }

    public void openConnection() {

        try {
            if (connection != null) {
                if (!connection.isClosed()) {
                    closeIgnores++;
                    return;
                }
            }

            synchronized (this) {
                connection = null;
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                connection = DriverManager.getConnection("jdbc:derby://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password);

            }

            if (connection.isClosed()) {
                if (retries < 3) {
                    retries++;
                    resetConnection();
                    System.out.println("Database has connection issues.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (closeIgnores > 0) {
            closeIgnores--;
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnections(final ResultSet resultSet, final PreparedStatement preparedStatement) throws SQLException {
        this.closeConnection();
        resultSet.close();
        preparedStatement.close();
    }
    
    // (START) Shipment Feature - Seongwoo Jeong
    
    public ShipmentDetails findShipmentDetails(final int id) {
        try {
            this.openConnection();
            final PreparedStatement getShipping = connection.prepareStatement("SELECT * FROM Shipment_Details WHERE shipmentdetailsid=?");
            getShipping.setInt(1, id);
            final ResultSet result = getShipping.executeQuery();
            
            ShipmentDetails details = null;
            while (result.next()) {
                String streetNameNumber = result.getString("streetnamenumber");
                String suburb = result.getString("suburb");
                int postcode = result.getInt("postcode");
                String state = result.getString("state");
                details = new ShipmentDetails(streetNameNumber, suburb, postcode, state);
            }
            this.closeConnections(result, getShipping);
            return details;
        } catch (SQLException e) {
            e.printStackTrace();
            this.closeConnection();
            return null;
        } 
    }
    
    public Shipment findShipment(final int id) {
        this.openConnection();
        try {
            final PreparedStatement getShipment = connection.prepareStatement("SELECT * FROM Shipment WHERE shipmentid=?");
            getShipment.setInt(1, id);
            final ResultSet result = getShipment.executeQuery();
            Shipment shipment = null;
            
            while (result.next()) {
               int shippingID = result.getInt("shipmentid");
               String shipmentStatus = result.getString("shipmentstatus");
               String shipmentDate = result.getString("shipmentdate");
               String courierName = result.getString("couriername");
               String trackingNumber = result.getString("trackingnumber");
               int shipmentDetailsID = result.getInt("shipmentdetailsid");
               int orderID = result.getInt("orderid");
               shipment = new Shipment(shippingID, shipmentDate, shipmentStatus, courierName, trackingNumber, shipmentDetailsID , orderID);
               shipment.setShipmentID(id);
            }
            this.closeConnections(result, getShipment);
            return shipment;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
       /* Assignment2 Requirements (create or add details in shipment feature), userAccount ID is generated */ 
   
   public void addShipmentDetails(final ShipmentDetails details, final int shipmentID) {
       this.openConnection();
       try {
           final PreparedStatement addShipping = connection.prepareStatement("INSERT INTO Shipment_Details (streetnamenumber, suburb, postcode, state) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
           addShipping.setString(1, details.getStreetNameNumber());
           addShipping.setString(2, details.getSuburb());
           addShipping.setInt(3, details.getPostcode());
           addShipping.setString(4, details.getState());
           addShipping.execute();
           final ResultSet result = addShipping.getGeneratedKeys();
           
           while (result.next()) {
               details.setShipmentDetailsID(result.getInt(1));
           }
          
           this.closeConnections(result, addShipping);
           
           this.openConnection();
           final PreparedStatement addToShipment = connection.prepareStatement("UPDATE Shipment SET shipmentdetailsid=? WHERE shipmentID=?");
           addToShipment.setInt(1, details.getShipmentDetailsID());
           addToShipment.setInt(2, shipmentID);
           addToShipment.executeUpdate();
           this.closeConnections(result, addToShipment);
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
 
   /* Assignment2 Requirements (updat details in shipment feature), following significants will be updated by the user */
   
   public void updateShipmentDetails(final ShipmentDetails details) {
       this.openConnection();
       try {
           final PreparedStatement updateShipping = connection.prepareStatement("UPDATE Shipment_Details SET streetnamenumber=?, suburb=?, postcode=?, state=? WHERE shipmentdetailsid=?");

           updateShipping.setString(1, details.getStreetNameNumber());
           updateShipping.setString(2, details.getSuburb());
           updateShipping.setInt(3, details.getPostcode());
           updateShipping.setString(4, details.getState());
           updateShipping.setInt(5, details.getShipmentDetailsID());
           updateShipping.execute();
           this.closeConnection();
           updateShipping.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   
   /* Assignment2 Requirements (delete details in shipment feature), shipmentDetails id is issued to delete a desired detail */
   
   public void deleteShipmentDetails (int shipmentDetailID) {
       this.openConnection();
       try {
           final PreparedStatement delShipping = connection.prepareStatement("DELETE FROM Shipment_Details WHERE shipmentdetailsid=?");

           delShipping.setInt(1, shipmentDetailID);
         
           delShipping.execute();
           this.closeConnection();
           delShipping.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   } 

   
   /* Get shipmentDetails ID */
   
   public int getShipmentDetailID (final Shipment shipment) {
       int id = 0;
       this.openConnection();
       try {
           final PreparedStatement getShipmentID = connection.prepareStatement("SELECT shipmentdetailid FROM Shipment WHERE shipmentid=?");
           getShipmentID.setInt(1, shipment.getShipmentID());
           final ResultSet result = getShipmentID.executeQuery();
           
           if (result.next()) {
               id = result.getInt("shipmentdetailid");
           }          
           this.closeConnections(result, getShipmentID);
           getShipmentID.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return id;
   }
   
   public ArrayList<Shipment> getAllShipments(int id) 
   {
       final ArrayList<Shipment> shipments = new ArrayList<>();
       this.openConnection();
       try {
           final PreparedStatement getShipments = connection.prepareStatement("SELECT * FROM Shipment WHERE useraccountid=?");
           getShipments.setInt(1, id);
           final ResultSet result = getShipments.executeQuery();
           while (result.next()) {
               shipments.add(new Shipment(result.getInt("shipmentid"), result.getString("shipmentdate"), result.getString("shipmentstatus"), result.getString("couriername"), result.getString("trackingnumber"), result.getInt("shipmentdetailsid"), result.getInt("orderid")));
           }
           this.closeConnections(result, getShipments);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return shipments;
    }   
   
   public ArrayList<ShipmentDetails> getAllShipmentDetails(int id)
   {
       ArrayList<ShipmentDetails> shipmentDetails = new ArrayList<>();
       this.openConnection();
       try {
           final PreparedStatement getShipmentDetails = connection.prepareStatement("SELECT shipmentdetailsid FROM Shipment WHERE useraccountid=?");
           getShipmentDetails.setInt(1, id);
           final ResultSet result = getShipmentDetails.executeQuery();
           
           while (result.next()) {
               final PreparedStatement getNewDetails = connection.prepareStatement("SELECT * FROM Shipment_Details WHERE shipmentdetailsid=?");
               getNewDetails.setInt(1, result.getInt("shipmentdetailsid"));
               final ResultSet newResults = getNewDetails.executeQuery();
               while (newResults.next()) {
                   shipmentDetails.add(new ShipmentDetails(newResults.getString("streetnamenumber"), newResults.getString("suburb"), newResults.getInt("postcode"), newResults.getString("state")));
               }
               newResults.close();
               getNewDetails.close();
           }
           this.closeConnections(result, getShipmentDetails);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return shipmentDetails;
   }
   
       // (END) Shipment Feature - Seongwoo Jeong
}