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
package uts.isd.controller;

import uts.isd.model.ShipmentDetails;
import uts.isd.model.dao.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeongseongwoo
 */
public class UpdateShipmentDetailsServlet extends HttpServlet {

  
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    HttpSession session = request.getSession();
    String streetNameNumber = request.getParameter("streenNameNumber");
    String suburb = request.getParameter("suburb");
    int postcode = Integer.parseInt(request.getParameter("postcode"));
    String state = request.getParameter("state");
    int shipmentDetailsID = Integer.parseInt(request.getParameter("shipmentDetailsID"));
    Database manager = (Database) session.getAttribute("Database");
    session.setAttribute("updated",null);
    ShipmentValidator validator = new ShipmentValidator();
    validator.clear(session);
    session.setAttribute("nameNumberErr", null);
    session.setAttribute("postcodeErr", null);
    
    // To display back all the shipment details have through mapping URL from servlet to servlet
    // int userAccountID = Integer.parseInt(request.getParameter("userID"));
    
    ShipmentDetails shipmentD = new ShipmentDetails (streetNameNumber, suburb, postcode, state);
            try {
                if (!validator.validateShipment(streetNameNumber)) {
                    session.setAttribute("NameNumberErr", "Format is incorrect");
                    
                    request.getRequestDispatcher("editshipmentdetails.jsp").include(request,response);
                    
                } else if (!validator.validatePostcode(postcode)){
                      session.setAttribute("postcodeErr", "postcode invalid, please try again.");        
         request.getRequestDispatcher("editshipmentdetails.jsp").include(request,response);
                } else{
                   manager.updateShipmentDetails(shipmentDetailsID, streetNameNumber, suburb, postcode, state);
                   session.setAttribute("shipmentD", shipmentD); 
                   session.setAttribute("updated", "Shipment Details were succesfully updated!");
                    request.getRequestDispatcher("editshipmentdetails.jsp").include(request,response);
                }
            } catch (SQLException ex) {
           Logger.getLogger(UpdateShipmentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
        }
    }
