/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import uts.isd.model.dao.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeongseongwoo
 */
public class DeleteShipmentDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userID = Integer.parseInt(request.getParameter("userID"));
        int shipmentDetailsID = Integer.parseInt(request.getParameter("shipmentDetailsID"));
        Database manager = (Database) session.getAttribute("shipmentManager");
        try {
            manager.deleteShipmentDetails(shipmentDetailsID);
            request.getRequestDispatcher("/ShipmentDetailsServlet?userID=" + userID).include(request,response);
          /* response.sendRedirect("/ShipmentServlet?userID=3"); */
            
        } catch (SQLException ex) {
            Logger.getLogger(DeleteShipmentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
