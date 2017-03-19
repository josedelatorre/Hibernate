package DAO;

import java.util.List;

import org.hibernate.*;

import Common.HibernateUtil;
import Models.Pedido;

public class PedidoDAO extends GenericDAO {
	

	public PedidoDAO() {
		super(Pedido.class);
	}

	public String save(Pedido Pedido) throws HibernateException {
		String id = "";

		try {
			iniciaOperacion();
			id = (String) sesion.save(Pedido);
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

	public void update(Pedido Pedido) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.update(Pedido);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void delete(Pedido Pedido) throws HibernateException {
		try {
			iniciaOperacion();
			sesion.delete(Pedido);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public Pedido get(int idPedido) throws HibernateException {
		Pedido Pedido = null;
		try {
			iniciaOperacion();
			Pedido = (Pedido) sesion.get(Pedido.class, idPedido);
		} finally {
			sesion.close();
		}

		return Pedido;
	}

	public List<Pedido> find() throws HibernateException {
		List<Pedido> listaPedidos = null;

		try {
			iniciaOperacion();
			listaPedidos = sesion.createQuery("from Pedido").list();
		} finally {
			sesion.close();
		}

		return listaPedidos;
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