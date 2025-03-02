package dao;

import database.HibernateUtil;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibreriaDAO {
    private Session session;
    public void insertLibreria(Libreria libreria){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.persist(libreria);

        session.getTransaction().commit();
        session.close();
    }

    public Libreria getLibreria(int id){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Libreria libreria = session.get(Libreria.class,id);

        session.getTransaction().commit();
        session.close();

        return libreria;
    }

    public void updateLibreriaLibro(int libroId, int libreriaId){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Libreria libreria = session.get(Libreria.class, libreriaId);
        Libro libro = session.get(Libro.class, libroId);

        libreria.getLibros().add(libro);
        libro.getLibrerias().add(libreria);

        session.merge(libreria);

        session.getTransaction().commit();
        session.close();
    }

    public List<Libreria> getAllLibrerias(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String querySTR = "FROM Libreria";
        Query<Libreria> query = session.createQuery(querySTR,Libreria.class);
        List<Libreria> librerias = query.list();

        session.getTransaction().commit();
        session.close();

        return librerias;
    }
}

