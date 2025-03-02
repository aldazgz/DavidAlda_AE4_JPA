package dao;

import database.HibernateUtil;
import model.Autor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AutorDAO {
    private Session session;
    public void insertAutor(Autor autor){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.persist(autor);

        session.getTransaction().commit();
        session.close();
    }

    public Autor getAutor(int id){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Autor autor = session.get(Autor.class, id);

        session.getTransaction().commit();
        session.close();

        return autor;
    }

    public List<Autor> getAllAutores(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String querySTR = "FROM Autor";
        Query<Autor> query = session.createQuery(querySTR,Autor.class);
        List<Autor> autores = query.list();

        session.getTransaction().commit();
        session.close();

        return autores;
    }
}

