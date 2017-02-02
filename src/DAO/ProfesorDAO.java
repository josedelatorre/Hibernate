package DAO;

import java.util.List;

import org.hibernate.*;

import Common.HibernateUtil;
import Models.Profesor;

public class ProfesorDAO extends GenericDAO {
	

	public String save(Profesor Profesor) throws HibernateException {
		String id = "";

		try {
			iniciaOperacion();
			id = (String) sesion.save(Profesor);
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

	public void update(Profesor Profesor) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.update(Profesor);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void delete(Profesor Profesor) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.delete(Profesor);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public Profesor get(String idProfesor) throws HibernateException {
		Profesor Profesor = null;
		try {
			iniciaOperacion();
			Profesor = (Profesor) sesion.get(Profesor.class, idProfesor);
		} finally {
			sesion.close();
		}

		return Profesor;
	}

	public List<Profesor> find() throws HibernateException {
		List<Profesor> listaProfesors = null;

		try {
			iniciaOperacion();
			listaProfesors = sesion.createQuery("from Profesor").list();
		} finally {
			sesion.close();
		}

		return listaProfesors;
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