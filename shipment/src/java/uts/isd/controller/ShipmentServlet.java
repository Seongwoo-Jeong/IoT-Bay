/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import uts.isd.model.Shipment;
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
public class ShipmentServlet extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       HttpSession session = request.getSession();
       ShipmentValidator validator = new ShipmentValidator();
       int shipmentID = Integer.parseInt(request.getParameter("shipmentID"));
      Database manager = (Database) session.getAttribute("shipmentManager");
       Shipment shipment = null;
       session.setAttribute ("shipment", null);
       session.setAttribute("searchErr", null);
       validator.clear(session);
       

           shipment = manager.findShipment(shipmentID);
           if (shipment != null) {
               session.setAttribute("shipment", shipment);
               ShipmentDetails shipmentD = manager.findShipmentDetails(shipment.getShipmentDetailsID());
               session.setAttribute("shipmentD", shipmentD);
               request.getRequestDispatcher("shipment.jsp").include(request, response);
               
           } else {
               session.setAttribute("Error Occurred", "Invalid shipment in the Database, please try again.");
               request.getRequestDispatcher("shipment.jsp").include(request, response);
           }
       }
   }
