/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.model.entity.view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Emmanuel
 */
@Entity
@Table(name = "eventos_view")
public class EventosView implements Serializable{
    @Id
    @Column(insertable = false, updatable = false)
     private Integer idasistente;
     private String voucher;
     private String operacion;
     private Date fecha;
     private String carne;
     private String nombres;
     @Column(name = "apellido_pat")
     private String apellidoPat;
     @Column(name = "apellido_mat")
     private String apellidoMat;
     private String dni;
     private String ep;
     private Double importe;
               
     private Integer idevento;
     private Integer idorganizador_ev;
     private String evento;
     @Column(name = "fecha_inicio")
     private Date fechaInicio;
     @Column(name = "fecha_fin")
     private Date fechaFin;
     private Character estado_evt;    
     
     @Column(name = "idevento_sesion")
     private Integer ideventoSesion;
     private Integer idevento_evs;
     @Column(name = "evento_sesion_evs")
     private String sesion;
     @Column(name = "fecha_evento_evs")
     private Date fechaEvento;
     private Date hora;
     private String descripcion;
     private Character estado_evs;     
     
     private int idcontrol_evento_asistencia;
     private Integer idasistente_cea;
     @Column(name = "idevento_sesion_cea")
     private Integer ideventoSesion_cea;
     private char estado_cea;
     private String estado_reg_cea;
     
     private Integer idorganizador;
     private String organizador;
     private String responzable;

    public EventosView() {
    }

    public EventosView(Integer idasistente, String voucher, String operacion, Date fecha, String carne, String nombres, String apellidoPat, String apellidoMat, String dni, String ep, Double importe, Integer idevento, Integer idorganizador_ev, String evento, Date fechaInicio, Date fechaFin, Character estado_evt, int idcontrol_evento_asistencia, Integer ideventoSesion, Integer idevento_evs, String sesion, Date fechaEvento, Date hora, String descripcion, Character estado_evs, Integer idasistente_cea, Integer ideventoSesion_cea, char estado_cea, String estado_reg_cea, Integer idorganizador, String organizador, String responzable) {
        this.idasistente = idasistente;
        this.voucher = voucher;
        this.operacion = operacion;
        this.fecha = fecha;
        this.carne = carne;
        this.nombres = nombres;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.dni = dni;
        this.ep = ep;
        this.importe = importe;
        this.idevento = idevento;
        this.idorganizador_ev = idorganizador_ev;
        this.evento = evento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado_evt = estado_evt;
        this.idcontrol_evento_asistencia = idcontrol_evento_asistencia;
        this.ideventoSesion = ideventoSesion;
        this.idevento_evs = idevento_evs;
        this.sesion = sesion;
        this.fechaEvento = fechaEvento;
        this.hora = hora;
        this.descripcion = descripcion;
        this.estado_evs = estado_evs;
        this.idasistente_cea = idasistente_cea;
        this.ideventoSesion_cea = ideventoSesion_cea;
        this.estado_cea = estado_cea;
        this.estado_reg_cea = estado_reg_cea;
        this.idorganizador = idorganizador;
        this.organizador = organizador;
        this.responzable = responzable;
    }

    public Integer getIdasistente() {
        return idasistente;
    }

    public void setIdasistente(Integer idasistente) {
        this.idasistente = idasistente;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Integer getIdevento() {
        return idevento;
    }

    public void setIdevento(Integer idevento) {
        this.idevento = idevento;
    }

    public Integer getIdorganizador_ev() {
        return idorganizador_ev;
    }

    public void setIdorganizador_ev(Integer idorganizador_ev) {
        this.idorganizador_ev = idorganizador_ev;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Character getEstado_evt() {
        return estado_evt;
    }

    public void setEstado_evt(Character estado_evt) {
        this.estado_evt = estado_evt;
    }

    public int getIdcontrol_evento_asistencia() {
        return idcontrol_evento_asistencia;
    }

    public void setIdcontrol_evento_asistencia(int idcontrol_evento_asistencia) {
        this.idcontrol_evento_asistencia = idcontrol_evento_asistencia;
    }

    public Integer getIdeventoSesion() {
        return ideventoSesion;
    }

    public void setIdeventoSesion(Integer ideventoSesion) {
        this.ideventoSesion = ideventoSesion;
    }

    public Integer getIdevento_evs() {
        return idevento_evs;
    }

    public void setIdevento_evs(Integer idevento_evs) {
        this.idevento_evs = idevento_evs;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado_evs() {
        return estado_evs;
    }

    public void setEstado_evs(Character estado_evs) {
        this.estado_evs = estado_evs;
    }

    public Integer getIdasistente_cea() {
        return idasistente_cea;
    }

    public void setIdasistente_cea(Integer idasistente_cea) {
        this.idasistente_cea = idasistente_cea;
    }

    public Integer getIdeventoSesion_cea() {
        return ideventoSesion_cea;
    }

    public void setIdeventoSesion_cea(Integer ideventoSesion_cea) {
        this.ideventoSesion_cea = ideventoSesion_cea;
    }

    public char getEstado_cea() {
        return estado_cea;
    }

    public void setEstado_cea(char estado_cea) {
        this.estado_cea = estado_cea;
    }

    public String getEstado_reg_cea() {
        return estado_reg_cea;
    }

    public void setEstado_reg_cea(String estado_reg_cea) {
        this.estado_reg_cea = estado_reg_cea;
    }

    public Integer getIdorganizador() {
        return idorganizador;
    }

    public void setIdorganizador(Integer idorganizador) {
        this.idorganizador = idorganizador;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public String getResponzable() {
        return responzable;
    }

    public void setResponzable(String responzable) {
        this.responzable = responzable;
    }

    

     
}
