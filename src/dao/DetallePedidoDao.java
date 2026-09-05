package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.DetallePedido;
import datos.Plato;

public class DetallePedidoDao {

	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(DetallePedido objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(DetallePedido objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(DetallePedido objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public DetallePedido traer(long idDetallePedido) {
		DetallePedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (DetallePedido) session.get(DetallePedido.class, idDetallePedido);
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<DetallePedido> traer() throws HibernateException {
		List<DetallePedido> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from DetallePedido d", DetallePedido.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	
	public List<DetallePedido> traer(Plato plato) {
		List<DetallePedido> lista = null;
		try {
			iniciaOperacion();
			String hql = "from DetallePedido d inner join fetch d.pedido where d.plato.idPlato=:idPlato";
			lista = session.createQuery(hql, DetallePedido.class).setParameter("idPlato", plato.getIdPlato())
					.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
}
