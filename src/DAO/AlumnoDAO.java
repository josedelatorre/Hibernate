package DAO;

import java.util.List;

import org.hibernate.*;

import Common.HibernateUtil;
import Models.Alumno;
import Models.Profesor;

public class AlumnoDAO extends GenericDAO {

	public AlumnoDAO(){
		super(Alumno.class);
	}
	
	public String save(Alumno Object) throws HibernateException {
		return super.save(Object);
	}

	public void update(Alumno Object) throws HibernateException {
		super.update(Object);
	}

	public void delete(Alumno Object) throws HibernateException {
		super.delete(Object);
	}

	public Alumno get(String idObject) throws HibernateException {
		return (Alumno) super.get(idObject);
	}
	
	public Alumno get(int idObject) throws HibernateException {
		return (Alumno) super.get(idObject);
	}

	public List<Alumno> find() throws HibernateException {
		return super.find(Alumno.class.getName());
	}
}