/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.RegistroDAO;
import beens.RegistroBeens;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vargas
 */
@WebServlet(name = "ControladorA", urlPatterns = {"/ControladorA"})
public class ControladorA extends HttpServlet {

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
    int IdUsr;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("menu");
        String opc = request.getParameter("accion");
        HttpSession session = request.getSession();
        if (opc.equals("Ppal")) {
            request.getRequestDispatcher("Menu.jsp").forward(request, response);
        }

        if (op.equals("Administrador")) {
            switch (opc) {
                case "mostrar":
                    request.getRequestDispatcher("Menu.jsp").forward(request, response);
                    break;

                case "cargar":
                    IdUsr = Integer.parseInt(request.getParameter("id_registro"));
                    RegistroBeens BeensCarga = DAO.cargar(IdUsr);
                    request.setAttribute("datos", BeensCarga);
                    request.getRequestDispatcher("AdministradorUsu.jsp").forward(request, response);
                    break;

                case "borrar":
                    IdUsr = Integer.parseInt(request.getParameter("id_registro"));
                    DAO.eliminar(IdUsr);
                    request.getRequestDispatcher("AdministradorUsu.jsp").forward(request, response);
                    break;

                case "agregar":
                    String nom = request.getParameter("nombres");
                    String con = request.getParameter("contacto");
                    String cor = request.getParameter("correo");
                    String rol = request.getParameter("rol");

                    Beens.setNombres(nom);
                    Beens.setContacto(con);
                    Beens.setCorreo(cor);
                    Beens.setRol(rol);

                    DAO.insertar(Beens);
                    request.getRequestDispatcher("exito.jsp").forward(request, response);
                    break;

                case "modificar":
                    String nom2 = request.getParameter("nombres");
                    String con2 = request.getParameter("contacto");
                    String cor2 = request.getParameter("correo");
                    String rol2 = request.getParameter("rol");

                    Beens.setNombres(nom2);
                    Beens.setContacto(con2);
                    Beens.setCorreo(cor2);
                    Beens.setRol(rol2);

                    Beens.setId_registro(IdUsr);
                    DAO.modificar(Beens);
                    request.getRequestDispatcher("exito.jsp").forward(request, response);
                    break;

                case "cerrarS":
                    Beens.setNombres(null);
                    Beens.setContacto(null);
                    Beens.setCorreo(null);
                    Beens.setRol(null);
                    session.invalidate();

                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
            }
        }
    }

//    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
//        ventana.Username = jTextFieldEmail.getText();
//        ventana.setVisible(true);
//        this.dispose();
//    }
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
