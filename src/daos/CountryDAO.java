/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class CountryDAO<T> {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    T t;
    
    public CountryDAO(SessionFactory factory, Class<T> type) {
        this.factory = factory;
        try {
            this.t = type.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CountryDAO(SessionFactory SessionFactory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public T getById(Short id) {
        T location = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Location WHERE id = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", id);
            location = (T) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return location;
    }

    public List<T> getData(Object keyword) {
        List<T> objectList = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        String hql = "FROM " + t.getClass().getSimpleName();
        if (!keyword.equals("")) {
            hql+=" WHERE ";
            for (Field field : t.getClass().getDeclaredFields()) {
                if (!field.getName().contains("UID") && !field.getName().contains("List")) {
                    hql += field.getName() + " LIKE '%"+keyword+"%' OR ";
                }
            }
            hql = hql.substring(0, hql.lastIndexOf("OR"));
        }
        System.out.println(hql);
        try {
            Query query = session.createQuery(hql);
//            query.setParameter("table", table.getClass().getSimpleName());
//            if (!keyword.equals("")) {
//                query.setParameter("keyword", "%" + keyword + "%");
//            }
            objectList = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return objectList;
    }

    public boolean saveOrDelete(T object, boolean isDelete) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            if (isDelete) {
                session.delete(object);
            } else {
                session.saveOrUpdate(object);
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }
}