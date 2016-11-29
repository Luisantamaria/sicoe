/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import upeu.edu.pe.model.dao.ControlAsistenciaDao;
import upeu.edu.pe.model.dao.impl.ControlAsistenciaDaoImpl;
import upeu.edu.pe.model.entity.EventoSesion;

/**
 *
 * @author Emmanuel
 */
public class ActionCrud extends HttpServlet {

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
        
        
        
        String op = request.getParameter("op"); op= request.getParameter("op")==null?"":op;
        ControlAsistenciaDao dao = null;
//        System.out.println("ideventoSesion: "+ideventoSesion+" | estadoSesion: "+estadoSesion+" | op: "+op);
        switch(op){
            case "updtgesasis":
                System.out.println("Ingreso CambiarEstado!!------------");
                dao = new ControlAsistenciaDaoImpl();
                char estadoSesion =  request.getParameter("estadoSesion").charAt(0); estadoSesion= request.getParameter("estadoSesion")==null?"".charAt(0):estadoSesion;
                Integer ideventoSesion = Integer.parseInt(request.getParameter("ideventoSesion"));ideventoSesion = request.getParameter("ideventoSesion")==null?0:ideventoSesion;
                if(dao.cambiarEstadoEventoSesion(ideventoSesion, estadoSesion)){
                    System.out.println("Cambio el Estado!");
                }else{
                    System.out.println("NO Cambio el Estado!");
                }
                
                request.setAttribute("listaEventoSesion", dao.listaEventoSesion(1));
                request.getRequestDispatcher("evento/mantenimiento/gest_asistencia.jsp").forward(request, response);
                break;
            case "addcreasis":
                String txtSesion = request.getParameter("sesion"); txtSesion=request.getParameter("sesion")==null?"":txtSesion;
                String fechaHora = request.getParameter("fecha"); fechaHora=request.getParameter("fecha")==null?"":fechaHora;
                String txtdescripcion = request.getParameter("descripcion"); txtdescripcion=request.getParameter("descripcion")==null?"":txtdescripcion;
                if (!txtSesion.equals("") && !fechaHora.equals("") && !txtdescripcion.equals("")) {
                    dao = new ControlAsistenciaDaoImpl();
                    EventoSesion evs = new EventoSesion();
                    String day = fechaHora.substring(3,5);
                    String month = fechaHora.substring(0,2);
                    String year = fechaHora.substring(6,10);
                    String hour = fechaHora.substring(11,13);
                    String minute = fechaHora.substring(14,16);
                    if (fechaHora.length()==18) {
                        hour = fechaHora.substring(11,12);
                        minute = fechaHora.substring(13,15);
                    }

                    System.out.println("FECHA DATE: "+hour+":"+minute+" length:"+fechaHora.length());

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat formatHour = new SimpleDateFormat("hh:mm");
                    Date fecha = null;
                    Date hora = null;
                    try {
                        fecha = new Date(format.parse(year+"-"+month+"-"+day).getTime());
                        hora = new Date(formatHour.parse(hour+":"+minute).getTime());
                    } catch (Exception e) {
                    }

                    evs.setIdevento(1);
                    evs.setSesion(txtSesion);
                    evs.setFecha(fecha);
                    evs.setHora(hora);
                    evs.setDescripcion(txtdescripcion);
                    evs.setEstado('0');
                    dao.agregarEventoSesion(evs);
                }
                
                request.getRequestDispatcher("evento/mantenimiento/crear_asistencia.jsp").forward(request, response);
                //request.getRequestDispatcher("../index.jsp").forward(request, response);
                //response.sendRedirect(request.getContextPath()+"/evento/index.jsp");
                break;
            case "updt":
                break;
        
        
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
