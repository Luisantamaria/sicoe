/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import upeu.edu.pe.controller.snippets.SnippetBean;
import upeu.edu.pe.model.bean.AsistenciaEvent;
import upeu.edu.pe.model.bean.AsistenteCEA;
import upeu.edu.pe.model.bean.RegAsistenteBean;
import upeu.edu.pe.model.dao.ControlAsistenciaDao;
import upeu.edu.pe.model.dao.impl.ControlAsistenciaDaoImpl;
import upeu.edu.pe.model.entity.Asistente;

/**
 *
 * @author Emmanuel
 */
public class ActionEvent extends HttpServlet {

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
        ControlAsistenciaDao dao = new ControlAsistenciaDaoImpl();
        SnippetBean sb = new SnippetBean();        
        AsistenciaEvent aevt = new AsistenciaEvent();
        AsistenteCEA asistente = null;
        RegAsistenteBean regAbean = null;
        String mensaje = "";
        aevt = (AsistenciaEvent)sb.getJSON(request, AsistenciaEvent.class);
        System.out.println("---- Bienvenido ActionEvent Servler -----");
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        StringBuilder jsonview = new StringBuilder();
//        BufferedReader br = request.getReader();
//        String str = null;
//        
//        while ((str = br.readLine()) != null) {
//            jsonview.append(str);
//        }
//        System.out.println(jsonview.toString());
//        aevt = gson.fromJson(jsonview.toString(), AsistenciaEvent.class);
        switch(aevt.getAction()){
            case "val":
                asistente = new AsistenteCEA();
                
                asistente = dao.comprobarAsistencia(aevt.getDocumento(), 1);
                if (asistente != null) {
                    switch(asistente.getEstado()){
                        case '0':
                            System.out.println("Servlet Valida Reg - NO esta registrado ");
                            regAbean = new RegAsistenteBean(asistente.getCarne(), asistente.getNombres(), asistente.getApellidoPat(), asistente.getApellidoMat(), asistente.getDni(), asistente.getEp(), asistente.getEstado(), "no");
                            
                            break;
                        case '1':
                            System.out.println("Servlet Valida Reg - SI esta registrado ");
                            regAbean = new RegAsistenteBean(asistente.getCarne(), asistente.getNombres(), asistente.getApellidoPat(), asistente.getApellidoMat(), asistente.getDni(), asistente.getEp(), asistente.getEstado(), "si");
                            break;
                    }
                } else {
                    System.out.println("Servlet Valida Reg - NO Existe ");
                    regAbean = new RegAsistenteBean("", "", "", "", aevt.getDocumento(), "",'9', "nulo");
                }
//                switch(dao.comprobarAsistencia(aevt.getDocumento())){
//                    case 0:
//                        System.out.println("Servlet Valida Reg - NO esta registrado ");
//                        mensaje = "no";
//                        break;
//                    case 1:
//                        System.out.println("Servlet Valida Reg - SI esta registrado ");
//                        mensaje = "si";
//                        break;
//                    case 2:
//                        System.out.println("Servlet Valida Reg - NO Existe ");
//                        mensaje = "nulo";
//                        break;
//                }                
                break;
            case "reg":
                System.out.println("Servlet Documento: "+aevt.getDocumento());
                
                asistente = new AsistenteCEA();                
                asistente = dao.registrarAsistencia(aevt.getDocumento(), 1);
                if (asistente != null) {
                    regAbean = new RegAsistenteBean(asistente.getCarne(), asistente.getNombres(), asistente.getApellidoPat(), asistente.getApellidoMat(), asistente.getDni(), asistente.getEp(), asistente.getEstado(), "OK");
                    switch(asistente.getEstado()){
                        case '0':
                            //System.out.println("Servlet Valida Reg - NO esta registrado ");
                            
                            
                            break;
                        case '1':
                            //System.out.println("Servlet Valida Reg - SI esta registrado ");
                            
                            break;
                    }
                } else {                    
                    regAbean = new RegAsistenteBean("", "", "", "", aevt.getDocumento(), "",'9', "NOK");
                }
                
//                regAbean = new RegAsistenteBean();
//                if (dao.registrarAsistencia(aevt.getDocumento())) {                    
//                    regAbean.setMensaje("OK");
//                }else{
//                    regAbean.setMensaje("NOK");
//                }
//                break;
            
        }        
                
        //System.out.println("DOCUMENTO: "+aevt.getDocumento());
                
        String json = new Gson().toJson(regAbean);
        response.setContentType("application/json");
        response.getWriter().write(json);
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
