package DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Models.Alumno;
import Models.Profesor;

@Component
public class ProfesorDAO extends GenericDAO {
	
	@Autowired
	private Profesor profesor;
	
	@Autowired
	private Alumno alumno;
	
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

	public void probando(){
		profesor.probando();
		alumno.setNombre("Pepe");
		System.out.println(alumno);
	}
	
}