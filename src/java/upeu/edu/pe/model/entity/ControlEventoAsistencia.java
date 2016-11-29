/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Emmanuel
 */
@Entity
@Table(name = "control_evento_asistencia")
public class ControlEventoAsistencia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcontrol_evento_asistencia;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idasistente;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idevento_sesion;
    private char estado;

    public ControlEventoAsistencia() {
    }

    public ControlEventoAsistencia(int idcontrol_evento_asistencia, int idasistente, int idevento_sesion, char estado) {
        this.idcontrol_evento_asistencia = idcontrol_evento_asistencia;
        this.idasistente = idasistente;
        this.idevento_sesion = idevento_sesion;
        this.estado = estado;
    }

    public int getIdcontrol_evento_asistencia() {
        return idcontrol_evento_asistencia;
    }

    public void setIdcontrol_evento_asistencia(int idcontrol_evento_asistencia) {
        this.idcontrol_evento_asistencia = idcontrol_evento_asistencia;
    }

    public int getIdasistente() {
        return idasistente;
    }

    public void setIdasistente(int idasistente) {
        this.idasistente = idasistente;
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
