package DAO;

import java.util.List;

import org.hibernate.*;

import Common.HibernateUtil;
import Models.Alumno;
import Models.Aula;
import Models.Aula;

public class AulaDAO extends GenericDAO {
	
	public AulaDAO(){
		super(Aula.class);
	}
	
	public String save(Aula Object) throws HibernateException {
		return super.save(Object);
	}

	public void update(Aula Object) throws HibernateException {
		super.update(Object);
	}

	public void delete(Aula Object) throws HibernateException {
		super.delete(Object);
	}

	public Aula get(String idObject) throws HibernateException {
		return (Aula) super.get(idObject);
	}
	
	public Aula get(int idObject) throws HibernateException {
		return (Aula) super.get(idObject);
	}

	public List<Aula> find() throws HibernateException {
		return super.find(Aula.class.getName());
	}
}