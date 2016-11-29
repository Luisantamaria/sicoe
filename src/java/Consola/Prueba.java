/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consola;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import upeu.edu.pe.model.dao.ControlAsistenciaDao;
import upeu.edu.pe.model.dao.impl.ControlAsistenciaDaoImpl;
import upeu.edu.pe.model.entity.Asistente;
import upeu.edu.pe.model.entity.Evento;
import upeu.edu.pe.model.entity.EventoSesion;
import upeu.edu.pe.model.entity.Organizador;
import upeu.edu.pe.model.entity.Usuario;
import upeu.edu.pe.model.entity.view.EventosView;
import upeu.edu.pe.model.util.HibernateUtil;

/**
 *
 * @author Emmanuel
 */
public class Prueba {
    public static void main(String[] args) {
        //Probando funcion agregar EventoSesion
        ControlAsistenciaDao dao = new ControlAsistenciaDaoImpl();
//        for (int i = 1; i <= 1; i++) {
//            if (dao.agregarControlAsistente(1, 17)) {
//                System.out.println("ok-");
//            } else {
//                System.out.println("NO-");
//            }
//        }
        
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatHour = new SimpleDateFormat("hh:mm");
        Date fecha = null;
        Date hora = null;
        try {
            fecha = new Date(format.parse("2016-11-11").getTime());
            hora = new Date(formatHour.parse("08:30").getTime());
        } catch (Exception e) {
        }
        
        
        
        EventoSesion es = new EventoSesion(3, 1, "dia 3", fecha, hora, "Tarde", '0');
        if (dao.agregarEventoSesion(es)) {
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }
        
        
        
//        //Probando Entidad Usuario
//        SessionFactory sf = null;
//        Session session = null;
//        Transaction tx = null;
//        Query query = null;
//        try {
//           sf = HibernateUtil.getSessionFactory();
//           session = sf.openSession(); 
//           query = session.createQuery("FROM Usuario");
//            for (Usuario u : (List<Usuario>)query.list()) {
//                System.out.println(u.getUsuario());
//            }
//            session.close();
//        } catch (Exception e) {
//            System.out.println("ERROR: "+e.getMessage());
//            session.close();
//        }
        
//        //Probando Entidad Organizador
//        SessionFactory sf = null;
//        Session session = null;
//        Transaction tx = null;
//        Query query = null;
//        try {
//           sf = HibernateUtil.getSessionFactory();
//           session = sf.openSession(); 
//           query = session.createQuery("FROM Organizador");
//            for (Organizador org : (List<Organizador>)query.list()) {
//                System.out.println(org.getOrganizador());
//            }
//            session.close();
//        } catch (Exception e) {
//            System.out.println("ERROR: "+e.getMessage());
//            session.close();
//        }
        
//           //Probando Entidad EventoSesion
//        SessionFactory sf = null;
//        Session session = null;
//        Transaction tx = null;
//        Query query = null;
//        try {
//           sf = HibernateUtil.getSessionFactory();
//           session = sf.openSession(); 
//           query = session.createQuery("FROM EventoSesion");
//            for (EventoSesion ev : (List<EventoSesion>)query.list()) {
//                System.out.println(ev.getSesion());
//            }
//            session.close();
//        } catch (Exception e) {
//            System.out.println("ERROR: "+e.getMessage());
//            session.close();
//        }

//Probando Entidad Evento
//        SessionFactory sf = null;
//        Session session = null;
//        Transaction tx = null;
//        Query query = null;
//        try {
//           sf = HibernateUtil.getSessionFactory();
//           session = sf.openSession(); 
//           query = session.createQuery("FROM Evento");
//            for (Evento ev : (List<Evento>)query.list()) {
//                System.out.println(ev.getEvento());
//            }
//            session.close();
//        } catch (Exception e) {
//            System.out.println("ERROR: "+e.getMessage());
//            session.close();
//        }
        
        //Probando Entidad Asistente
//        SessionFactory sf = null;
//        Session session = null;
//        Transaction tx = null;
//        Query query = null;
//        try {
//           sf = HibernateUtil.getSessionFactory();
//           session = sf.openSession(); 
//           query = session.createQuery("FROM Asistente");
//            for (Asistente asis : (List<Asistente>)query.list()) {
//                System.out.println( new SimpleDateFormat("dd'/'MM'/'yyyy", new Locale("es_ES")).format(asis.getFecha()) );
//            }
//            session.close();
//        } catch (Exception e) {
//            System.out.println("ERROR: "+e.getMessage());
//            session.close();
//        }
        
        
        //probando registro de asistencia
//        ControlAsistenciaDao dao = new ControlAsistenciaDaoImpl();
//        if(dao.registrarAsistencia("48621039")) {
//            System.out.println("Se registro Correctamente!");
//        } else {
//                System.out.println("Error al Resistrar Asistencia.");
//        }
        
        //Llamando una Vista
//        SessionFactory sf = null;
//        Session session = null;
//        Transaction tx = null;
//        Query query = null;
//        try {
//           sf = HibernateUtil.getSessionFactory();
//           session = sf.openSession(); 
//           query = session.createQuery("FROM EventosView");
////            for (int id : (List<Integer>)query.list()) {
////                System.out.println(id);
////            }
//            for (EventosView ev : (List<EventosView>)query.list()) {
//                System.out.println(ev.getApellidoPat()+" FECHA: "+ev.getFecha()+" Operacion: "+ev.getOperacion()+"estado number: "+ev.getEstado_cea()+" -  Estado: "+ev.getEstado_reg_cea());
//            }
//            session.close();
//        } catch (Exception e) {
//            System.out.println("ERROR: "+e.getMessage());
//            session.close();
//        }
        
        
//        try {
//            sf = HibernateUtil.getSessionFactory();
//            session = sf.openSession();
//            tx = session.beginTransaction();
//            Asistente a = new Asistente("aaa", "opera", new Date("2016/11/09"), "201610898", "luis", "santa maria", "Ticlavilca", "45448683", "Sistemas", 20.00, "EVENT002");
//            session.save(a);
//            tx.commit();
//            session.close();
//        } catch (Exception e) {
//            System.out.println("ERROR: "+e.getMessage());
//            tx.rollback();
//            session.close();
//        }
        
        
        
//        try {
//            sf = HibernateUtil.getSessionFactory();
//            session = sf.openSession();
//            tx = session.beginTransaction();
//            Evento e = new Evento(1,"Seminario", new Date("2016/11/09"), new Date("2016/11/09"));
//            session.save(e);
//            tx.commit();
//            session.close();
//        } catch (Exception e) {
//            System.out.println("ERROR: "+e.getMessage());
//            tx.rollback();
//            session.close();
//        }
        
//        try {
//            sf = HibernateUtil.getSessionFactory();
//            session = sf.openSession();
//            tx = session.beginTransaction();
//            EventoSesion es = new EventoSesion(9, "dia 1", new Date("2016/11/09"), new Time(13, 25, 15), "Comienzo del Evento", '1');
//            session.save(es);
//            tx.commit();
//            session.close();
//        } catch (Exception e) {
//            System.out.println("ERROR: "+e.getMessage());
//            tx.rollback();
//            session.close();
//        }
        
        
//EventoSesion es = new EventoSesion(Integer.SIZE, null, null, null, null, Character.MIN_VALUE)
        
    }
}
