package arqSw.proyecto.Servlets;

import arqSw.proyecto.DAO.AdministradorDAO;
import arqSw.proyecto.Hibernate.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KEVIN
 */
@WebServlet(name = "PersonaServlet", urlPatterns = {"/PersonaServlet"})
public class AdministradorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministradorDAO admDao = new AdministradorDAO();
        List<Administrador> admP = admDao.getAdministrador();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PersonaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(admP.size());
            for (Administrador a : admP) {
                out.println("Nombre" + a.getUsuario() + "<h1>");
//                for (Password p : a.getPassword()) {
//
//                }
            }      

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
