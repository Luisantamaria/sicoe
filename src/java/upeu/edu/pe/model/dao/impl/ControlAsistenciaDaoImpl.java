/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.model.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import upeu.edu.pe.model.bean.AsistenteCEA;
import upeu.edu.pe.model.bean.EventosViewBean;
import upeu.edu.pe.model.dao.ControlAsistenciaDao;
import upeu.edu.pe.model.entity.Asistente;
import upeu.edu.pe.model.entity.ControlEventoAsistencia;
import upeu.edu.pe.model.entity.EventoSesion;
import upeu.edu.pe.model.entity.Usuario;
import upeu.edu.pe.model.entity.view.EventosView;
import upeu.edu.pe.model.util.HibernateUtil;

/**
 *
 * @author Emmanuel
 */
public class ControlAsistenciaDaoImpl implements ControlAsistenciaDao{

    @Override
    public Usuario validarUsuario(String usuario, String clave) {
        Usuario u = null;
        SessionFactory sf = null;
        Session session = null;
        Query query = null;
        try {
            u  = new Usuario();
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            query = session.createQuery("from Usuario where usuario = :usuario and clave = :clave");
            query.setParameter("usuario", usuario); 
            query.setParameter("clave", clave); 
            u = (Usuario) query.uniqueResult();
            //System.out.println("DAO USUARIO: "+u.getIdusuario()+ " | "+u.getUsuario()+" | "+u.getClave()+" | "+u.getRol());
            session.close();
        } catch (Exception e) {
            session.close();
            System.out.println("ERROR VALIDAR-USUARIO: "+e.getMessage());
        }
        return u;
    }
    
    @Override
    public AsistenteCEA registrarAsistencia(String documento, Integer idevento) {
//        boolean flag = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        AsistenteCEA acea = null;
        //EventosView ew = null;
        EventosView ew = null;
        ControlEventoAsistencia cea = null;
        Query query = null;
        String doc = "carne";
        try {
            if(documento.length() == 8){
                doc = "dni" ;
            }
            acea = new AsistenteCEA();
            ew = new EventosView();
            cea = new ControlEventoAsistencia();
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            query = session.createQuery("from EventosView where idorganizador = idorganizador_ev "+
                                        "and idevento = idevento_evs and idasistente = idasistente_cea "+
                                        "and idevento_sesion = idevento_sesion_cea "+
                                        "and estado_evs = 1 "+
                                        "and idevento = :id and "+doc+" = :carne");
//            query = session.createQuery("select new upeu.edu.pe.model.entity.Asistente(idasistente, voucher, operacion, fecha, carne, "+
//                                        "nombres, apellidoPat, apellidoMat, dni, ep, importe) "+
//                                        "from EventosView where idorganizador = idorganizador_ev "+
//                                        "and idevento = idevento_evs and idasistente = idasistente_cea "+
//                                        "and idevento_sesion = idevento_sesion_cea "+
//                                        "and estado_evs = 1 "+
//                                        "and idevento = :id and dni = :carne or carne = :carne");
//            query = session.createQuery("from EventosView where idorganizador = idorganizador_ev "+
//                                        "and idevento = idevento_evs and idasistente = idasistente_cea "+
//                                        "and idevento_sesion = idevento_sesion_cea and estado_evs = 1 "+
//                                        "and idevento = :id and dni = :carne or carne = :carne");
            query.setParameter("id", idevento);
            query.setParameter("carne", documento);
            ew = (EventosView) query.uniqueResult();
            System.out.println("Registro CAST HBN: "+ew.getNombres());
            //ew = (EventosView) query.uniqueResult();
            cea.setIdcontrol_evento_asistencia(ew.getIdcontrol_evento_asistencia());
            cea.setIdasistente(ew.getIdasistente());
            cea.setIdevento_sesion(ew.getIdeventoSesion());
            cea.setEstado('1');
            acea = new AsistenteCEA(ew.getIdasistente(), ew.getCarne(), ew.getNombres(), ew.getApellidoPat(), ew.getApellidoMat(), ew.getDni(), ew.getEp(), idevento, cea.getEstado());
            System.out.println("update control_evento_asistencia set idasistente = "+ew.getIdasistente()+", idevento_sesion = "+ew.getIdeventoSesion()+", estado = '1' where idasistente= "+ew.getIdasistente());
//            System.out.println("DAO Registro Asistencia: "+asistente.getIdasistente()+" | "+asistente.getNombres()+
//                    " | "+asistente.getApellidoPat()+" | "+asistente.getApellidoMat()+" | "+asistente.getDni()+" | "+
//                    asistente.getCarne());
            session.update(cea);            
            tx.commit();
            session.close();
//            flag = true;
        } catch (Exception e) {
            tx.rollback();
            System.out.println("DAO Documento: "+documento);
            System.out.println("ERROR DE REGISTRO ASISTENCIA CEA: "+e.getMessage());
            session.close();
//            flag = false;
        }
        return acea;
    }
    
     @Override
    public AsistenteCEA comprobarAsistencia(String documento, Integer idevento) {        
        AsistenteCEA acea = null;
        EventosView ew = null;
        
        SessionFactory sf = null;
        Session session = null;
        Query query = null;
        String doc = "carne";
        try {
            if(documento.length() == 8){
                doc = "dni" ;
            }
            ew = new EventosView();
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();            
//            query = session.createQuery("select idasistente, voucher, operacion, fecha, carne, "+
//                                        "nombres, apellidoPat, apellidoMat, dni, ep, importe "+
//                                        "from EventosView where idorganizador = idorganizador_ev "+
//                                        "and idevento = idevento_evs and idasistente = idasistente_cea "+
//                                        "and idevento_sesion = idevento_sesion_cea and estado_evs = 1 "+
//                                        "and idevento = :id and dni = :carne or carne = :carne");
            query = session.createQuery("from EventosView where idorganizador = idorganizador_ev "+
                                        "and idevento = idevento_evs and idasistente = idasistente_cea "+
                                        "and idevento_sesion = idevento_sesion_cea "+
                                        "and estado_evs = 1 "+
                                        "and idevento = :id and "+doc+" = :carne");
            query.setParameter("id", idevento);
            query.setParameter("carne", documento); 
            System.out.println(query);
            ew = (EventosView) query.uniqueResult();
            
            acea = new AsistenteCEA(ew.getIdasistente(), ew.getCarne(), ew.getNombres(), ew.getApellidoPat(), ew.getApellidoMat(), ew.getDni(), ew.getEp(), idevento, ew.getEstado_cea());
            
            session.close();
        } catch (Exception e) {
            session.close();
            System.out.println("ERROR comprobarAsistencia: "+e.getMessage());
        }
        return acea;
    }

    
    @Override
    public List<EventosViewBean> listaAsistentes(Integer idevento) {
        SessionFactory sf = null;
        Session session = null;
        Query query = null;
        List<EventosView> lista = null;
        List<EventosViewBean> list = null;
        EventosViewBean evb = null;
        try {
            lista = new ArrayList<>();
            list = new ArrayList<>();
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            query = session.createQuery("from EventosView where idorganizador = idorganizador_ev "+
                    "and idevento = idevento_evs and idasistente = idasistente_cea "+
                    "and idevento_sesion = idevento_sesion_cea "+
                    "and estado_evs = '1' and idevento = :id");
            query.setParameter("id", idevento);
            lista = query.list();
            for (EventosView ev: lista) {
                evb = new EventosViewBean();
                evb.setIdasistente(ev.getIdasistente());
                evb.setVoucher(ev.getVoucher());
                evb.setOperacion(ev.getOperacion());
                evb.setFecha(ev.getFecha());
                evb.setCarne(ev.getCarne());
                evb.setNombres(ev.getNombres());
                evb.setApellidoPat(ev.getApellidoPat());
                evb.setApellidoMat(ev.getApellidoMat());
                evb.setDni(ev.getDni());
                evb.setEp(ev.getEp());
                evb.setImporte(ev.getImporte());
                evb.setEstado_cea(ev.getEstado_cea());
                evb.setEstado_reg_cea(ev.getEstado_reg_cea());
                list.add(evb);
            }
            //list = EventosViewBean.class.cast(lista);
            session.close();
        } catch (Exception e) {
            System.out.println("ERROR listaAsistentes: "+e.getMessage());
            session.close();
        }
        return list;
    }

    @Override
    public List<EventoSesion> listaEventoSesion(Integer idevento) {
        SessionFactory sf = null;
        Session session = null;
        Query query = null;
        EventoSesion evs = null;
        List<EventoSesion> lista = null;
        try {
            lista = new ArrayList<>();
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            query = session.createQuery("from EventoSesion where idevento = :id");
            query.setParameter("id", idevento);
            lista = query.list();            
            session.close();
        } catch (Exception e) {
            System.out.println("DAO:msg-ERROR listaEventoSesion: "+e.getMessage());
            session.close();
        }
        return lista;
    }
    
    @Override
    public boolean cambiarEstadoEventoSesion(Integer ideventoSesion, char estado) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        EventoSesion evs = null;
        estado = estado=='1'?'0':'1';
        try {
            evs = new EventoSesion();
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            evs = (EventoSesion) session.get(EventoSesion.class, ideventoSesion);
            evs.setEstado(estado);
            session.update(evs);
            tx.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            tx.rollback();
            System.out.println("DAO:msg-ERROR cambiarEstadoEventoSesion: "+e.getMessage());
            session.close();
            flat=false;
        }
        return flat;
    }
    
    @Override
    public boolean agregarEventoSesion(EventoSesion eventoSesion) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        EventoSesion evs = null;
        Query query = null;
        List<Asistente> lsAsis = null;
        ControlEventoAsistencia cea = null;
        try {
            evs = new EventoSesion();
            lsAsis = new ArrayList<>();
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(eventoSesion);
            tx.commit();
//            try {
                query = session.createQuery("from Asistente where evento = :idevento");
                query.setParameter("idevento", eventoSesion.getIdevento());
                lsAsis = query.list();
                for (Asistente asis : (List<Asistente>)query.list()) {
                    Thread.sleep(250);
                    this.agregarControlAsistente(asis.getIdasistente(), eventoSesion.getIdeventoSesion());
                }
            session.close();
            flat = true;
        } catch (Exception e) {
            tx.rollback();
            System.out.println("DAO:msg-ERROR agregarEventoSesion: "+e.getMessage());
            session.close();
            flat=false;
        }
        return flat;
    }
    
    @Override
    public boolean agregarControlAsistente(Integer idasistente, Integer ideventoSesion) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        ControlEventoAsistencia cea = null;
        try {
            //cea = new ControlEventoAsistencia(idasistente, ideventoSesion, '0');
            cea = new ControlEventoAsistencia();
            cea.setIdasistente(idasistente);
            cea.setIdevento_sesion(ideventoSesion);
            cea.setEstado('0');
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(cea);
            tx.commit(); 
            flat = true;
        } catch (Exception e) {
            tx.rollback();
            System.out.println("DAO:msg-ERROR agregarControlAsistente: "+e.getMessage());
            session.close();
            flat=false;
        }        
        return flat;
    }
    
    @Override
    public List<EventosViewBean> reporteInasistente(Integer idevento) {
        SessionFactory sf = null;
        Session session = null;
        Query query = null;
        List<EventosView> lista = null;
        List<EventosViewBean> list = null;
        EventosViewBean evb = null;
        try {
            lista = new ArrayList<>();
            list = new ArrayList<>();
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            query = session.createQuery("from EventosView where idorganizador = idorganizador_ev "+
                    "and idevento = idevento_evs and idasistente = idasistente_cea "+
                    "and idevento_sesion = idevento_sesion_cea "+
                    "and estado_evs = '1' and idevento = :id and estado_cea = '0'");
            query.setParameter("id", idevento);
            lista = query.list();
            for (EventosView ev: lista) {
                evb = new EventosViewBean();
                evb.setIdasistente(ev.getIdasistente());
                evb.setVoucher(ev.getVoucher());
                evb.setOperacion(ev.getOperacion());
                evb.setFecha(ev.getFecha());
                evb.setCarne(ev.getCarne());
                evb.setNombres(ev.getNombres());
                evb.setApellidoPat(ev.getApellidoPat());
                evb.setApellidoMat(ev.getApellidoMat());
                evb.setDni(ev.getDni());
                evb.setEp(ev.getEp());
                evb.setImporte(ev.getImporte());
                evb.setEstado_cea(ev.getEstado_cea());
                evb.setEstado_reg_cea(ev.getEstado_reg_cea());
                list.add(evb);
            }
            //list = EventosViewBean.class.cast(lista);
            session.close();
        } catch (Exception e) {
            System.out.println("ERROR listaAsistentes: "+e.getMessage());
            session.close();
        }
        return list;
    }

    @Override
    public List<EventosViewBean> reporteAsistente(Integer idevento) {
        SessionFactory sf = null;
        Session session = null;
        Query query = null;
        List<EventosView> lista = null;
        List<EventosViewBean> list = null;
        EventosViewBean evb = null;
        try {
            lista = new ArrayList<>();
            list = new ArrayList<>();
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            query = session.createQuery("from EventosView where idorganizador = idorganizador_ev "+
                    "and idevento = idevento_evs and idasistente = idasistente_cea "+
                    "and idevento_sesion = idevento_sesion_cea "+
                    "and estado_evs = '1' and idevento = :id and estado_cea = '1'");
            query.setParameter("id", idevento);
            lista = query.list();
            for (EventosView ev: lista) {
                evb = new EventosViewBean();
                evb.setIdasistente(ev.getIdasistente());
                evb.setVoucher(ev.getVoucher());
                evb.setOperacion(ev.getOperacion());
                evb.setFecha(ev.getFecha());
                evb.setCarne(ev.getCarne());
                evb.setNombres(ev.getNombres());
                evb.setApellidoPat(ev.getApellidoPat());
                evb.setApellidoMat(ev.getApellidoMat());
                evb.setDni(ev.getDni());
                evb.setEp(ev.getEp());
                evb.setImporte(ev.getImporte());
                evb.setEstado_cea(ev.getEstado_cea());
                evb.setEstado_reg_cea(ev.getEstado_reg_cea());
                list.add(evb);
            }
            //list = EventosViewBean.class.cast(lista);
            session.close();
        } catch (Exception e) {
            System.out.println("ERROR listaAsistentes: "+e.getMessage());
            session.close();
        }
        return list;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void cargarHbn() {
        SessionFactory sf = null;
        Session session = null;
        Query query = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            query = session.createQuery("from Organizador");
            System.out.println("Se cargo HBN");
            session.close();
        } catch (Exception e) {
            System.out.println("ERROR CARGAR HBN: "+e.getMessage());
            session.close();
        }
    }

    

    

    
    
}
