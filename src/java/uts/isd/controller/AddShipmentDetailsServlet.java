/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.ShipmentDetails;
import uts.isd.model.dao.Database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeongseongwoo
 */
public class AddShipmentDetailsServlet extends HttpServlet {

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
     HttpSession session = request.getSession();
     ShipmentValidator validator = new ShipmentValidator();
     String streetNameNumber = request.getParameter("streetNameNumber");
     String suburb = request.getParameter("suburb");
     String state = request.getParameter("state");
     int postcode = Integer.parseInt(request.getParameter("postcode"));
     int userID = Integer.parseInt(request.getParameter("userID"));
     ShipmentDetails shipmentDetail = null;
     Database manager = (Database) session.getAttribute("Database");
     session.setAttribute("addSuccess", null);
     session.setAttribute("addressErr", null);
     
     
     validator.clear(session);
     if (!validator.validateShipmentNameNumber(streetNameNumber)) {
         session.setAttribute("addressErr", "address Format is Wrong");
         request.getRequestDispatcher("addShipmentDetails.jsp").include(request,response);
     } else if (!validator.validatePostcode(postcode)){
         
         session.setAttribute("postcodeErr", "Invalid postcode, please try again.");        
         request.getRequestDispatcher("addShipmentDetails.jsp").include(request,response);
     } 
     else { 
     
        manager.addShipmentDetails(new ShipmentDetails(streetNameNumber, suburb, postcode, state), 1);
        session.setAttribute("addedSuccess", "Shipment detail has been added to your account.");
        
     
     }
 }
}
