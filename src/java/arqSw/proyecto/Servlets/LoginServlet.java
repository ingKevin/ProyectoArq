package arqSw.proyecto.Servlets;


import arqSw.proyecto.DAO.AdministradorDAO;
import arqSw.proyecto.DAO.ArtistaDAO;
import arqSw.proyecto.DAO.ClienteDAO;
import arqSw.proyecto.Hibernate.Administrador;
import arqSw.proyecto.Hibernate.Artista;
import arqSw.proyecto.Hibernate.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);

        String name = request.getParameter("user");
        String password = request.getParameter("password");
        String P = request.getParameter("tUser");

        if (P.equals("adm")) {
            AdministradorDAO admDao = new AdministradorDAO();
            List<Administrador> admP = admDao.getAdministrador();
            for (Administrador a : admP) {
                if (name.equals(a.getUsuario()) && password.equals(a.getPassword())) {
                    out.print("Bienvenido, " + name);
                    HttpSession session = request.getSession();
                    session.setAttribute("name", name);
                    session.setAttribute("type", "Administrador");
                    request.getRequestDispatcher("indexAdm.html").include(request, response);
                } else {
                    out.print("Usuario o contraseña incorrecta!");
                    request.getRequestDispatcher("index.html").include(request, response);
                }
                out.close();
            }
        }else if (P.equals("cliente")) {
            ClienteDAO cliDao = new ClienteDAO();
            List<Cliente> cliP = cliDao.getCliente();
            for (Cliente a : cliP) {
                if (name.equals(a.getUsuario()) && password.equals(a.getPassword())) {   
                    out.print("Bienvenido, " + name);
                    HttpSession session = request.getSession();
                    session.setAttribute("name", name);
                    session.setAttribute("type", "Cliente");
                    request.getRequestDispatcher("indexCliente.html").include(request, response);
                    
                } else {
                    out.print("Usuario o contraseña incorrecta!");
                    request.getRequestDispatcher("index.html").include(request, response);
                }
                out.close();
            }
//        }else if (P.equals("artista")) {
        }else {
            ArtistaDAO artDao = new ArtistaDAO();
            List<Artista> admP = artDao.getArtista();
            for (Artista a : admP) {
                if (name.equals(a.getUsuario()) && password.equals(a.getPassword())) {
                    out.print("Bienvenido, " + name);
                    HttpSession session = request.getSession();
                    session.setAttribute("name", name);
                    session.setAttribute("type", "Artista");
                    request.getRequestDispatcher("indexArtista.html").include(request, response);
                    
                } else {
                    out.print("Usuario o contraseña incorrecta!");
                    request.getRequestDispatcher("index.html").include(request, response);
                }
                out.close();
            }
        }

    }
}
