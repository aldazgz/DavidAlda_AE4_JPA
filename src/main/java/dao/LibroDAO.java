package dao;

import database.HibernateUtil;
import model.Autor;
import model.Editorial;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibroDAO {
    private Session session;
    public void insertLibro(Libro libro, int autorId, int editorialId){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Autor autor = session.get(Autor.class, autorId);
        Editorial editorial = session.get(Editorial.class, editorialId);

        libro.setAutor(autor);
        libro.setEditorial(editorial);

        session.persist(libro);

        session.getTransaction().commit();
        session.close();
    }

    public Libro getLibro(int id){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Libro libro = session.get(Libro.class,id);

        session.getTransaction().commit();
        session.close();

        return libro;
    }

    public List<Libro> getAllLibros(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String querySTR = "FROM Libro";
        Query<Libro> query = session.createQuery(querySTR,Libro.class);
        List<Libro> libros = query.list();

        session.getTransaction().commit();
        session.close();

        return libros;
    }
}

