package arqSw.proyecto.Servlets;


import arqSw.proyecto.DAO.ArtistaDAO;
import arqSw.proyecto.DAO.ClienteDAO;
import arqSw.proyecto.Hibernate.Artista;
import arqSw.proyecto.Hibernate.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KEVIN
 */
@WebServlet(name = "RegistrarCliente", urlPatterns = {"/RegistrarCliente"})
public class RegistrarCliente extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);
        
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        String ubicacion = request.getParameter("ubicacion");
        String formaPago = request.getParameter("fPago");

        ClienteDAO cliDao = new ClienteDAO();
        if(cliDao.insertCliente(id,name, pass, ubicacion, formaPago)){
            request.getRequestDispatcher("index.html");
        }else{
            out.print("false");
        }
            
       


    }
}
