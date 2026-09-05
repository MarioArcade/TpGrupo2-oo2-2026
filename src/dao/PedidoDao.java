package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Pedido;

public class PedidoDao {

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
	public List<Pedido> traerPedidosFoodTrucksPorFechas(LocalDate desde, LocalDate hasta) {
	    List<Pedido> lista = null;
	    try {
	        iniciaOperacion();
	        // Se agrega "join fetch d.plato" para inicializar los precios de los platos antes de cerrar la sesión
	        String hql = "select distinct p from Pedido p " +
	                     "join fetch p.unidadVentaEntrega u " +
	                     "join fetch p.detalles d " +
	                     "join fetch d.plato " +
	                     "where TYPE(u) = FoodTrack " +
	                     "and p.fechaTransaccion between :desde and :hasta";
	                     
	        lista = session.createQuery(hql, Pedido.class)
	                .setParameter("desde", desde)
	                .setParameter("hasta", hasta)
	                .getResultList();
	    } finally {
	        session.close();
	    }
	    return lista;
	}
	public int agregar(Pedido objeto) {
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

	public void actualizar(Pedido objeto) {
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

	public void eliminar(Pedido objeto) {
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

	public Pedido traer(long idPedido) {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (Pedido) session.get(Pedido.class, idPedido);
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Pedido> traer() throws HibernateException {
		List<Pedido> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Pedido p order by p.idPedido asc", Pedido.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	// Caso de uso de ejemplo (Uno a Muchos): Pedido + sus DetallePedido (platos y cantidades)
	public Pedido traerPedidoYDetalles(long idPedido) throws HibernateException {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Pedido p where p.idPedido=:idPedido";
			objeto = (Pedido) session.createQuery(hql).setParameter("idPedido", idPedido).uniqueResult();
			Hibernate.initialize(objeto.getDetalles());
		} finally {
			session.close();
		}
		return objeto;
	}
}
