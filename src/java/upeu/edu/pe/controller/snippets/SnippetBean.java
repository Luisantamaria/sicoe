/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.controller.snippets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import upeu.edu.pe.model.bean.UsuarioBean;

/**
 *
 * @author Emmanuel
 * ::: LT49 :::
 */
public class SnippetBean {
    //funcion que usa la libreria Gson y recive del request el JSON 
    //enviado desde el Front End para convertirlo en un Objeto Java
    public Object getJSON(HttpServletRequest request,Class<?> clase){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        StringBuilder jsonview = new StringBuilder();
        BufferedReader br;
         Object obj = null;
        try {
            br = request.getReader();
            String str = null;        
            while ((str = br.readLine()) != null) {
                jsonview.append(str);
            }
//            System.out.println(jsonview.toString());
            obj = clase.newInstance();
        } catch (IOException ex) {
            Logger.getLogger(SnippetBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SnippetBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SnippetBean.class.getName()).log(Level.SEVERE, null, ex);
        }                  
        return  Object.class.cast(gson.fromJson(jsonview.toString(), obj.getClass() ));
    }
    
}
