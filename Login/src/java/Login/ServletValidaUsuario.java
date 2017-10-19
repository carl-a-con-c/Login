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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;

@WebServlet(name = "ServletValidaUsuario", urlPatterns = {"/ServletValidaUsuario"})
public class ServletValidaUsuario extends HttpServlet {

    String nombre;
    String password;
    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        nombre = request.getParameter("usuario");
        password = request.getParameter("contrasenia");
        
        String sql = "SELECT * FROM usuario where usuario='"+nombre+"' and "
                + "contrasenia = '" + password + "';";
        
        try {
            Conexion c = new Conexion();
            Connection con=c.getConexion();
            
                if(con!=null){
                    Statement st;
                    st = con.createStatement();
                    st.executeUpdate("INSERT INTO usuario VALUES ('"+nombre+"','"+password+"')"); 
                    st.close();
                    
                        try (PrintWriter out = response.getWriter()) {
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
                   }
                   c.cerrarConexion();
                  } catch (SQLException e) {
                      
                   e.printStackTrace();
               }   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
