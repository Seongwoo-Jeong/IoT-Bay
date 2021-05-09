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
public class EditShipmentDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //String streetNameNumber = request.getParameter("streetNameNumber");
        //String suburb = request.getParameter("suburb");
        //int postcode = Integer.parseInt(request.getParameter("postcode"));
        //String state = request.getParameter("state");
        // int userID = Integer.parseInt(request.getParameter("userID"));
        int shipmentDetailsID = Integer.parseInt(request.getParameter("shipmentDetailsID"));
        
        Database manager = (Database) session.getAttribute("shipmentManager");
        
        ShipmentDetails shipmentD = null;
       
            shipmentD = manager.findShipmentDetails(shipmentDetailsID);
            if(shipmentD != null) {
                session.setAttribute("shipmentDet", shipmentD);
                shipmentD.setShipmentDetailsID(shipmentDetailsID);
                request.getRequestDispatcher("editshipmentdetails.jsp").include(request,response);
            } else {
                session.setAttribute("existErr", "Shipment Detail does not exist in the Database!");
                request.getRequestDispatcher("EditShipmentDetails.jsp").include(request,response);
            }
            
       

    }
}