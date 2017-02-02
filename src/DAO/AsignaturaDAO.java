package DAO;

import java.util.List;

import org.hibernate.*;

import Common.HibernateUtil;
import Models.Alumno;
import Models.Asignatura;
import Models.Asignatura;
import Models.Aula;

public class AsignaturaDAO extends GenericDAO {

	public AsignaturaDAO() {
		super(Asignatura.class);
	}
	
	public String save(Asignatura Object) throws HibernateException {
		return super.save(Object);
	}

	public void update(Asignatura Object) throws HibernateException {
		super.update(Object);
	}

	public void delete(Asignatura Object) throws HibernateException {
		super.delete(Object);
	}

	public Asignatura get(String idObject) throws HibernateException {
		return (Asignatura) super.get(idObject);
	}
	
	public Asignatura get(int idObject) throws HibernateException {
		return (Asignatura) super.get(idObject);
	}

	public List<Asignatura> find() throws HibernateException {
		return super.find(Asignatura.class.getName());
	}
}