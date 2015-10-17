package nz.ac.aut.sa.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import nz.ac.aut.sa.dao.BaseDao;
import nz.ac.aut.sa.hibernate.HibernateUtil;

public class BaseDaoImpl<T> implements BaseDao<T> {

	public T get(Class<T> entityClass, Serializable id) {
		Session session = HibernateUtil.currentSession();
		T instance = (T) session.get(entityClass, id);
		HibernateUtil.closeSession();
		return instance;
	}

	public Serializable save(T entity) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		Serializable s = session.save(entity);
		tx.commit();
		HibernateUtil.closeSession();
		return s;
	}

	public void update(T entity) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(entity);
		tx.commit();
		HibernateUtil.closeSession();
	}

	public void delete(T entity) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		HibernateUtil.closeSession();
	}

	public void delete(Class<T> entityClass, Serializable id) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.createQuery("delete " + entityClass.getSimpleName() + " en where en.id = ?0").setParameter("0", id)
				.executeUpdate();
		tx.commit();
		HibernateUtil.closeSession();
	}

	public List<T> findAll(Class<T> entityClass) {
		Session session = HibernateUtil.currentSession();
		List<T> list =  (List<T>) session.createQuery("from " + entityClass.getSimpleName())
				.list();
		HibernateUtil.closeSession();
		return list;
	}

	public int findCount(Class<T> entityClass) {
		return findAll(entityClass).size();
	}

}
