package DAO;

import java.util.List;

import org.hibernate.*;

import Common.HibernateUtil;
import Models.Aula;

public class AulaDAO extends GenericDAO {
	

	public String save(Aula Aula) throws HibernateException {
		String id = "";

		try {
			iniciaOperacion();
			id = (String) sesion.save(Aula);
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

	public void update(Aula Aula) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.update(Aula);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void delete(Aula Aula) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.delete(Aula);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public Aula get(int idAula) throws HibernateException {
		Aula Aula = null;
		try {
			iniciaOperacion();
			Aula = (Aula) sesion.get(Aula.class, idAula);
		} finally {
			sesion.close();
		}

		return Aula;
	}

	public List<Aula> find() throws HibernateException {
		List<Aula> listaAulas = null;

		try {
			iniciaOperacion();
			listaAulas = sesion.createQuery("from Aula").list();
		} finally {
			sesion.close();
		}

		return listaAulas;
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