package Reservation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP PC
 */
public class RegistrationServlet extends HttpServlet {

        String firstname, lastname, email,password;
        long phone;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            firstname=request.getParameter("tbfirstname");
            lastname=request.getParameter("tbsecond");
            email=request.getParameter("tbem");
            password=request.getParameter("tbpass");
            phone=Long.parseLong(request.getParameter("tbnum"));
            out.println("<h1>Servlet RegistrationServlet at " + request.getContextPath() + "</h1>");
            String q="insert into resturant.register values(?,?,?,?,?);";
            
            Connection con;
            PreparedStatement stmt;
            out.println("<h2>hello</h2>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspiders","root","admin");
                stmt=con.prepareStatement(q);
                int r=stmt.executeUpdate();
                stmt=con.prepareStatement(q);
                stmt.setString(1,firstname);
                stmt.setString(2,lastname);
                stmt.setString(3,email);
                stmt.setLong(4,phone);
                stmt.setString(5,password);
                 r=stmt.executeUpdate();
                 out.println("<h2>Number of rows affected is "+r+" </h2>");
            } catch (ClassNotFoundException|SQLException ex) {
                ex.printStackTrace();
            }
           
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
