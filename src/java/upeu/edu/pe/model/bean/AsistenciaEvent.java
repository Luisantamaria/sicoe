/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.model.bean;

/**
 *
 * @author Emmanuel
 */
public class AsistenciaEvent {
    private String documento;
    private String action;

    public AsistenciaEvent() {
    }

    public AsistenciaEvent(String documento, String action) {
        this.documento = documento;
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    
    
}
