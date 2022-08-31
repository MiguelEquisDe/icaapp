/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.CasinoDAO;
import DAO.CorreoDAO;
import beens.BeensCasinos;
import beens.RegistroBeens;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author varga
 */
@MultipartConfig
@WebServlet(name = "ControladorCasino", urlPatterns = {"/ControladorCasino"})
public class ControladorCasino extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    List<BeensCasinos> casinos = new ArrayList<>();
    BeensCasinos Beens = new BeensCasinos();
    RegistroBeens RBeens = new RegistroBeens();
    CasinoDAO DAO_C = new CasinoDAO();
    CorreoDAO DAO_Correo = new CorreoDAO();
    int IdCas;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String men = request.getParameter("menu");
        String acc = request.getParameter("accion");

        if (men.equals("datos")) {
            switch (acc) {
                case "Mostrar":
                    request.setAttribute("BeensCasinos", casinos);
                    request.getRequestDispatcher("Menu.jsp").forward(request, response);

                case "Cargar":
                    IdCas = Integer.parseInt(request.getParameter("id_casino"));
                    BeensCasinos BeensC = DAO_C.cargar(IdCas);
                    request.setAttribute("datos", BeensC);
                    request.getRequestDispatcher("agTareas.jsp").forward(request, response);
                    break;

                case "Insertar":
                    String nomP = request.getParameter("nom");
                    String desP = request.getParameter("des");
                    Part imgP = request.getPart("img");
                    InputStream inputStream = imgP.getInputStream();

                    Beens.setNombres(nomP);
                    Beens.setDescripcion(desP);
                    Beens.setImg(inputStream);

                    DAO_C.insertar(Beens);
                    request.getRequestDispatcher("exitoT.jsp").forward(request, response);
                    break;

                case "Borrar":
                    IdCas = Integer.parseInt(request.getParameter("id_casino"));
                    DAO_C.eliminar(IdCas);
                    request.getRequestDispatcher("Menu.jsp").forward(request, response);
                    break;

                case "Modificar":
                    String nomPM = request.getParameter("nom");
                    String desPM = request.getParameter("des");
                    Part imgPM = request.getPart("img");
                    InputStream iS = imgPM.getInputStream();

                    Beens.setNombres(nomPM);
                    Beens.setDescripcion(desPM);
                    Beens.setImg(iS);

                    Beens.setId_casino(IdCas);
                    DAO_C.modificar(Beens);
                    request.getRequestDispatcher("exitoT.jsp").forward(request, response);
                    break;

                case "establecer0":
                    IdCas = Integer.parseInt(request.getParameter("id_casino"));
                    BeensCasinos BeensT = DAO_C.cargar(IdCas);
                    request.setAttribute("datos", BeensT);
                    request.getRequestDispatcher("CorregirTarea.jsp").forward(request, response);
                    break;

                case "establecerr":
                    String nomS = request.getParameter("nom");
                    String desS = request.getParameter("des");

                    Beens.setNombres(nomS);
                    Beens.setDescripcion(desS);
                    Beens.setSolucion("");

                    Beens.setId_casino(IdCas);
                    DAO_C.modificar0(Beens);
                    request.getRequestDispatcher("TareasTerminadas.jsp").forward(request, response);
                    break;

                case "Cargar_Finalizar":
                    IdCas = Integer.parseInt(request.getParameter("id_casino"));
                    BeensCasinos BeensCa = DAO_C.cargar(IdCas);
                    request.setAttribute("datos", BeensCa);
                    request.getRequestDispatcher("Finalizar_Tarea.jsp").forward(request, response);
                    break;

                case "Insertar_Finalizar":
                    String nomPr = request.getParameter("nom");
                    String tareaPr = request.getParameter("tarea");
                    String solPr = request.getParameter("sol");
                    Part imgPPr = request.getPart("imgP");
                    InputStream iPr = imgPPr.getInputStream();

                    Beens.setSolucion(solPr);
                    Beens.setImgP(iPr);

                    if (Beens.getSolucion() != null) {
                        Beens.setFinalizado(1);
                    }

                    Beens.setId_casino(IdCas);
                    DAO_C.modificarFinalizar(Beens);
                    DAO_Correo.transfer_to_email(nomPr, tareaPr);
                    request.getRequestDispatcher("exitoU.jsp").forward(request, response);
                    break;
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
