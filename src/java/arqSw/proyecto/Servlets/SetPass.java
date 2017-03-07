/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arqSw.proyecto.Servlets;

import arqSw.proyecto.DAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrador
 */
@WebServlet(name = "SetPassCliente", urlPatterns = {"/SetPassCliente"})
public class SetPass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);
        
        HttpSession session = request.getSession();
        String tipo = (String) session.getAttribute("type");
        String pass = request.getParameter("pass");
        
        if(tipo.equals("Cliente")){
            ClienteDAO cli = new ClienteDAO();
            cli.updatePassword(pass);
        }
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("user");
        
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

