/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import upeu.edu.pe.model.dao.ControlAsistenciaDao;
import upeu.edu.pe.model.dao.impl.ControlAsistenciaDaoImpl;

/**
 *
 * @author Emmanuel
 */
public class RedirectEvent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String rd = request.getParameter("rd"); rd = request.getParameter("rd")==null?"":rd; 
        ControlAsistenciaDao dao = null;
        if (session.getAttribute("usuario")==null) {
            response.sendRedirect(request.getContextPath());
        }else{
            switch(rd){
                case "rpasis":
                    dao = new ControlAsistenciaDaoImpl();
                    request.setAttribute("listaAsistentes", dao.listaAsistentes(1));
    //                if (session.getAttribute("usuario")!=null) {
    //                    response.sendRedirect(request.getContextPath());
    //                }
                    if (!session.getAttribute("rol").equals("helper")) {
                        request.getRequestDispatcher("evento/reportes/rep_asistente.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("evento/reportes/rep_asistenciahelper.jsp").forward(request, response);
                    }

                    break;
                case "rpia":
                     dao = new ControlAsistenciaDaoImpl();
                    request.setAttribute("reporteInasistente", dao.reporteInasistente(1));
                    request.getRequestDispatcher("evento/reportes/rep_inasistencia.jsp").forward(request, response);
                    break;                    
                case "rpa":
                     dao = new ControlAsistenciaDaoImpl();
                    request.setAttribute("reporteAsistente", dao.reporteAsistente(1));
                    request.getRequestDispatcher("evento/reportes/rep_asistencia.jsp").forward(request, response);
                    break;
                case "casis":
                    dao = new ControlAsistenciaDaoImpl();
                    request.setAttribute("listaEventoSesion", dao.listaEventoSesion(1));
                    request.getRequestDispatcher("evento/mantenimiento/crear_asistencia.jsp").forward(request, response);
                    break;
                case "gesasis":
                    dao = new ControlAsistenciaDaoImpl();
                    request.setAttribute("listaEventoSesion", dao.listaEventoSesion(1));
                    request.getRequestDispatcher("evento/mantenimiento/gest_asistencia.jsp").forward(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath());
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
