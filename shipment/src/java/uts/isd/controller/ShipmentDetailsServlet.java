/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import com.sun.istack.logging.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.UserAccount;
import uts.isd.model.ShipmentDetails;
import uts.isd.model.dao.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Jeongseongwoo
 */
public class ShipmentDetailsServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       HttpSession session = request.getSession();
       ShipmentValidator validator = new ShipmentValidator();
       int userID = Integer.parseInt(request.getParameter("userID"));
       Database manager = (Database) session.getAttribute("shipmentManager");
        ArrayList <ShipmentDetails> shipmentD = null;
        session.setAttribute("existErr", null);
        session.setAttribute("shipmentD", null);
        
       try {
           shipmentD = manager.getAllShipments(userID);
           if (shipmentD != null) {
           session.setAttribute("shipmentD", shipmentD);
           request.getRequestDispatcher("shipmentdetails.jsp").include(request,response);
           } else {
               session.setAttribute("existErr", "cannot find saved shipment addresses");
               request.getRequestDispatcher("shipmentdetails.jsp").include(request, response);
           }
       } catch (SQLException ex) {
           java.util.logging.Logger.getLogger(ShipmentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
   }
}