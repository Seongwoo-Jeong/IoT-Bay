package uts.isd.controller;

import uts.isd.model.dao.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ConnectServlet extends HttpServlet 
{
    private Database db;
    private Connection conn;

    @Override
    public void init() 
    {
        db = new Database();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        conn = db.openConnection();

        try 
        {
            shipmentManager = new ShipmentDBManager(conn);
            // other DBManagers should also be listed here
        } catch (SQLException ex) {
            Logger.getLogger(ConnectServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("shipmentManager", shipmentManager);
    // other features should also be included here

    }

    @Override
    public void destroy() {

        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
