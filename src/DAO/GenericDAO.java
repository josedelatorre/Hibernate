package DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Common.HibernateUtil;

public class GenericDAO<T> {
	protected Session sesion;
	protected Transaction tx;
    private final Class genericType;

    public GenericDAO(Class childClass)
    {
        this.genericType = childClass;
    }
    
	public String save(T Object) throws HibernateException {
		String id = "";

		try {
			iniciaOperacion();
			id = (String) sesion.save(Object);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			if (sesion != null)
				sesion.close();
		}

		return id;
	}

	public void update(T Object) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.update(Object);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void delete(T Object) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.delete(Object);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public T get(String idObject) throws HibernateException {
		T Object = null;
		try {
			iniciaOperacion();
			Object = (T) sesion.get(genericType, idObject);
		} finally {
			sesion.close();
		}

		return Object;
	}
	
	public T get(int idObject) throws HibernateException {
		T Object = null;
		try {
			iniciaOperacion();
			Object = (T) sesion.get(genericType, idObject);
		} finally {
			sesion.close();
		}

		return Object;
	}

	public List<T> find(String entity) throws HibernateException {
		List<T> listaObjects = null;

		try {
			iniciaOperacion();
			listaObjects = sesion.createQuery("from "+entity).list();
		} finally {
			sesion.close();
		}

		return listaObjects;
	}

	private void iniciaOperacion() throws HibernateException {
		sesion = HibernateUtil.getSessionFactory().openSession();
		tx = sesion.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
	}
}
