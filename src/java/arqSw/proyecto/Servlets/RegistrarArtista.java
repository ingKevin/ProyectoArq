/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arqSw.proyecto.Servlets;

import arqSw.proyecto.DAO.ArtistaDAO;
import arqSw.proyecto.DAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
@WebServlet(name = "RegistrarArtista", urlPatterns = {"/RegistrarArtista"})
public class RegistrarArtista extends HttpServlet {

       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);
        
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        ArtistaDAO artDao = new ArtistaDAO();
        if(artDao.insertCliente(id,name, pass)){
            request.getRequestDispatcher("index.html");
        }else{
            out.print("false");
        }
            
       


    }
}

