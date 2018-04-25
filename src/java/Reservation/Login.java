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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chaitrag
 */
public class Login extends HttpServlet {
    String email,password;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            email=request.getParameter("tbem");
            password=request.getParameter("tbpass");
            ResultSet r;
          
            String q="select Email,Password from resturant.registration where Email=? and password=?";
            Connection con;
            PreparedStatement stmt;
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resturant","root","admin");
                stmt=con.prepareStatement(q);
                stmt.setString(1,email);
                stmt.setString(2,password);
               r= stmt.executeQuery();
               if(r.next())
               {
                   String email1=r.getString(1);
                   String password1=r.getString(2);
                   out.println("<h2>The username is" +email1+" password is"+password1+"</h2>");
                   if(email.equals(email1) && password.equals(password1))
                   {
                       out.println("<a href='#'>Home</a>");
                   }
                  
               } 
               else
               {
                   out.println("<a href='http://localhost:8080/Online_Reservation_Booking/fgggh/Registration.html'>Registration</a>");
               }
              
                    
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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
