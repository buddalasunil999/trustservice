package nz.ac.aut.sa.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	public T get(Class<T> entityClass,Serializable id);
	public Serializable save(T entity);
	public void update(T entity);
	public void delete(T entity);
	public void delete(Class<T> entityClass, Serializable id);
	public List<T> findAll(Class<T> entityClass);
	public int findCount(Class<T> entityClass);
}
