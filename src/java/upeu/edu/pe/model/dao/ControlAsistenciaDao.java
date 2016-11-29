/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.model.dao;

import java.util.List;
import upeu.edu.pe.model.bean.AsistenteCEA;
import upeu.edu.pe.model.bean.EventosViewBean;
import upeu.edu.pe.model.entity.Asistente;
import upeu.edu.pe.model.entity.EventoSesion;
import upeu.edu.pe.model.entity.Usuario;
import upeu.edu.pe.model.entity.view.EventosView;

/**
 *
 * @author Emmanuel
 */
public interface ControlAsistenciaDao {
    
    public Usuario validarUsuario(String usuario, String clave);
    public AsistenteCEA registrarAsistencia(String documento, Integer idevento);
    public AsistenteCEA comprobarAsistencia(String documento, Integer idevento);
    public List<EventosViewBean> listaAsistentes(Integer idevento);    
    public List<EventoSesion> listaEventoSesion(Integer idevento);
    public boolean agregarEventoSesion(EventoSesion eventoSesion);
    public boolean cambiarEstadoEventoSesion(Integer ideventoSesion, char estado);
    
    public List<EventosViewBean> reporteInasistente(Integer idevento);
    public List<EventosViewBean> reporteAsistente(Integer idevento);
    
    public boolean agregarControlAsistente(Integer idasistente, Integer ideventoSesion);
    
    public void cargarHbn();
    
}
