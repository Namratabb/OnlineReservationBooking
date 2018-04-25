/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chaitrag
 */
public class Registration extends HttpServlet {

    String firstname, lastname, email,password;
        long phone;
        int r;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>hello</h2>");
            firstname=request.getParameter("tbfirst");
            lastname=request.getParameter("tbsecond");
            email=request.getParameter("tbem");
            password=request.getParameter("tbpass");
            phone=Long.parseLong(request.getParameter("tbnum"));
            out.println("<h1>Servlet RegistrationServlet at " + request.getContextPath() + "</h1>");
            String q="insert into resturant.registration values(?,?,?,?,?)";
            
            Connection con=null;
            PreparedStatement stmt=null;
            out.println("<h2>hello</h2>");
            try {
             DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resturant","root","admin");
                stmt=con.prepareStatement(q);
                stmt.setString(1,firstname);
                stmt.setString(2,lastname);
                stmt.setString(3,email);
                stmt.setString(4,password);
                stmt.setLong(5,phone);
                 r=stmt.executeUpdate();
               
                 out.println("<h2>Number of rows affected is "+r+" </h2>");
                   out.println("<h2>Registration successfull</h2>");
            }
            catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
           
            out.println("<h1>Servlet Registration at " + request.getContextPath() + "</h1>");
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
