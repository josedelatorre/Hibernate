package DAO;

import java.util.List;

import org.hibernate.*;

import Common.HibernateUtil;
import Models.Alumno;
import Models.Profesor;

public class ProfesorDAO extends GenericDAO {
	
	public ProfesorDAO(){
		super(Profesor.class);
	}
	
	public String save(Profesor Object) throws HibernateException {
		return super.save(Object);
	}

	public void update(Profesor Object) throws HibernateException {
		super.update(Object);
	}

	public void delete(Profesor Object) throws HibernateException {
		super.delete(Object);
	}

	public Profesor get(String idObject) throws HibernateException {
		return (Profesor) super.get(idObject);
	}
	
	public Profesor get(int idObject) throws HibernateException {
		return (Profesor) super.get(idObject);
	}

	public List<Profesor> find() throws HibernateException {
		return super.find(Profesor.class.getName());
	}
	
}