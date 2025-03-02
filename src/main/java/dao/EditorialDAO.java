package dao;

import database.HibernateUtil;
import model.Editorial;
import org.hibernate.Session;

public class EditorialDAO {
    private Session session;
    public void insertEditorial(Editorial editorial){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.persist(editorial);

        session.getTransaction().commit();
        session.close();
    }

    public Editorial getEditorial(int id){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Editorial editorial = session.get(Editorial.class, id);

        session.getTransaction().commit();
        session.close();

        return editorial;
    }

}
