/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import upeu.edu.pe.controller.snippets.SnippetBean;
import upeu.edu.pe.model.bean.UsuarioBean;
import upeu.edu.pe.model.dao.ControlAsistenciaDao;
import upeu.edu.pe.model.dao.impl.ControlAsistenciaDaoImpl;
import upeu.edu.pe.model.entity.Usuario;

/**
 *
 * @author Emmanuel
 */
public class LoginEvent extends HttpServlet {

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

        
        String mensaje = "";
        SnippetBean sb = new SnippetBean();
        UsuarioBean user = new UsuarioBean();
        Usuario usuario = new Usuario();
        ControlAsistenciaDao dao = new ControlAsistenciaDaoImpl();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");action = request.getParameter("action")==null?"":action;
        
        if(!action.equals("")){
            user.setAction(action);
        }else{
            user = (UsuarioBean) sb.getJSON(request, UsuarioBean.class);
        }        
        //user = UsuarioBean.class.cast(sb.getJSON(request, UsuarioBean.class));

        switch (user.getAction()) {
            case "login":
                usuario = dao.validarUsuario(user.getUsuario(), user.getClave());
                if (usuario != null) {
                    session.setAttribute("usuario", usuario.getUsuario());
                    session.setAttribute("rol", usuario.getRol());
                    mensaje = "valido";
                } else {
                    mensaje = "invalido";
                }
                break;
//            case "dashboard":
//                response.sendRedirect("evento/index.jsp");
//                break;
            case "hbn":
                dao.cargarHbn();
                mensaje = "KHBN";
                break;
        }
        //System.out.println("LOGIN: "+user.getUsuario());
        String json = new Gson().toJson(mensaje);
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
