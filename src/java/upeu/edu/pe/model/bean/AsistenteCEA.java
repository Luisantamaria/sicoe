/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.model.bean;

import java.util.Date;

/**
 *
 * @author Emmanuel
 */
public class AsistenteCEA {
    private Integer idasistente;
    private String carne;
    private String nombres;
    private String apellidoPat;
    private String apellidoMat;
    private String dni;
    private String ep;
    private int idevento_sesion;
    private char estado;

    public AsistenteCEA() {
    }

    public AsistenteCEA(Integer idasistente, String carne, String nombres, String apellidoPat, String apellidoMat, String dni, String ep, int idevento_sesion, char estado) {
        this.idasistente = idasistente;
        this.carne = carne;
        this.nombres = nombres;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.dni = dni;
        this.ep = ep;
        this.idevento_sesion = idevento_sesion;
        this.estado = estado;
    }

    public Integer getIdasistente() {
        return idasistente;
    }

    public void setIdasistente(Integer idasistente) {
        this.idasistente = idasistente;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEp() {
        return ep;
    }

    public void setEp(String ep) {
        this.ep = ep;
    }

    public int getIdevento_sesion() {
        return idevento_sesion;
    }

    public void setIdevento_sesion(int idevento_sesion) {
        this.idevento_sesion = idevento_sesion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    
    
    
}
