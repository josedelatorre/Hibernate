package DAO;

import java.util.List;

import org.hibernate.*;

import Common.HibernateUtil;
import Models.Asignatura;

public class AsignaturaDAO extends GenericDAO {
	

	public String save(Asignatura Asignatura) throws HibernateException {
		String id = "";

		try {
			iniciaOperacion();
			id = (String) sesion.save(Asignatura);
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

	public void update(Asignatura Asignatura) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.update(Asignatura);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void delete(Asignatura Asignatura) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.delete(Asignatura);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public Asignatura get(int idAsignatura) throws HibernateException {
		Asignatura Asignatura = null;
		try {
			iniciaOperacion();
			Asignatura = (Asignatura) sesion.get(Asignatura.class, idAsignatura);
		} finally {
			sesion.close();
		}

		return Asignatura;
	}

	public List<Asignatura> find() throws HibernateException {
		List<Asignatura> listaAsignaturas = null;

		try {
			iniciaOperacion();
			listaAsignaturas = sesion.createQuery("from Asignatura").list();
		} finally {
			sesion.close();
		}

		return listaAsignaturas;
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