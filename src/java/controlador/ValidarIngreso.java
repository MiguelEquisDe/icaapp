/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.RegistroDAO;
import beens.RegistroBeens;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vargas
 */
@WebServlet(name = "ValidarIngreso", urlPatterns = {"/ValidarIngreso"})
public class ValidarIngreso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    RegistroBeens Beens = new RegistroBeens();
    RegistroDAO DAO = new RegistroDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acc = request.getParameter("accion");
        if (acc.equals("ingresar")) {
            String usr = request.getParameter("usr");
            Beens = DAO.validar(usr);

            if (Beens.getNombres() != null) {
                if (Beens.getRol().equals("Administrador") || Beens.getRol().equals("Moderador")) {
                    request.getSession().setAttribute("Administrador", Beens);
                    request.setAttribute("Administrador", Beens);
                    request.getRequestDispatcher("ControladorA?accion=Ppal").forward(request, response);
                }

                if (Beens.getRol().equals("Usuario") || Beens.getRol() == null) {
                    request.getSession().setAttribute("Usu", Beens);
                    request.setAttribute("Usuario", Beens);
                    request.getRequestDispatcher("ControladorU?accion=Ppal").forward(request, response);
                }
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
