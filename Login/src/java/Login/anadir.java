/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import BD.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "anadir", urlPatterns = {"/anadir"})
public class anadir extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nombre;
        String password;
    
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             nombre = request.getParameter("usuario");
        password = request.getParameter("contrasenia");
        
        out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Servlet NewServlet</title>");            
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<h1>Usuario " + nombre + " añadido</h1>");
                            out.println("</body>");
                            out.println("</html>");
        
        try {
            Conexion c = new Conexion();
            Connection con=c.getConexion();
            
                if(con!=null){
                    Statement st;
                    st = con.createStatement();
                    st.executeUpdate("INSERT INTO usuario VALUES ('"+nombre+"','"+password+"')"); 
                    st.close();
                    
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Servlet NewServlet</title>");            
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<h1>Usuario " + nombre + " añadido</h1>");
                            out.println("</body>");
                            out.println("</html>");
                   }
                   c.cerrarConexion();
                  } catch (SQLException e) {                 
                   e.printStackTrace();
               }
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
