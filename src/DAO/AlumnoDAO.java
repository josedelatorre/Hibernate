package DAO;

import java.util.List;

import org.hibernate.*;

import Common.HibernateUtil;
import Models.Alumno;

public class AlumnoDAO extends GenericDAO {
	

	public String save(Alumno Alumno) throws HibernateException {
		String id = "";

		try {
			iniciaOperacion();
			id = (String) sesion.save(Alumno);
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

	public void update(Alumno Alumno) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.update(Alumno);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void delete(Alumno Alumno) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.delete(Alumno);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public Alumno get(String idAlumno) throws HibernateException {
		Alumno Alumno = null;
		try {
			iniciaOperacion();
			Alumno = (Alumno) sesion.get(Alumno.class, idAlumno);
		} finally {
			sesion.close();
		}

		return Alumno;
	}

	public List<Alumno> find() throws HibernateException {
		List<Alumno> listaAlumnos = null;

		try {
			iniciaOperacion();
			listaAlumnos = sesion.createQuery("from Alumno").list();
		} finally {
			sesion.close();
		}

		return listaAlumnos;
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