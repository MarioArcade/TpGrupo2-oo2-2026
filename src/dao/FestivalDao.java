package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Festival;
import datos.Plato;
import datos.Staff;
import datos.UnidadVenta;

public class FestivalDao {

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

	public int agregar(Festival objeto) {
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

	public void actualizar(Festival objeto) {
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

	public void eliminar(Festival objeto) {
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

	public Festival traer(long idFestival) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			objeto = (Festival) session.get(Festival.class, idFestival);
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Festival> traer() throws HibernateException {
		List<Festival> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Festival f order by f.fechaInicio asc", Festival.class)
					.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	// Caso de uso de ejemplo (Uno a Muchos): Festival + sus UnidadVenta
	public Festival traerFestivalYUnidadesVenta(long idFestival) throws HibernateException {
		Festival objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Festival f where f.idFestival=:idFestival";
			objeto = (Festival) session.createQuery(hql).setParameter("idFestival", idFestival).uniqueResult();
			Hibernate.initialize(objeto.getUnidadesVenta());
		} finally {
			session.close();
		}
		return objeto;
	}
	// Caso de uso Traer platos del festival
	public List<Plato> traerPlatosDeFestival(long idFestival) {

	    List<Plato> platos = null;

	    try {
	        iniciaOperacion();
	        
	        String hql = "  select distinct p from Festival f inner join f.unidadesVenta u inner join u.platos p where f.id = :idFestival";
	        platos = session.createQuery(hql, Plato.class).setParameter("idFestival", idFestival).getResultList();

	    } finally {
	        session.close();
	    }

	    return platos;
	}
	// Pendiente a implementar
	public List<Staff> traerEncargadosFestival(long idFestival){
		List<Staff> encargados = null;
		try {
			iniciaOperacion();
			String hql = "  select distinct s from Festival f inner join f.unidadesVenta u inner join u.encargado s where f.id = :idFestival";
			encargados = session.createQuery(hql, Staff.class).setParameter("idFestival", idFestival).getResultList();
		}finally {
			session.close();
		}
		return encargados;
	}
	// Traer un foodTrack por patente
	public UnidadVenta traerPorPatenteFestival(long idFestival,String patente) {
		UnidadVenta f1 =  null;
		try {
			iniciaOperacion();
			String hql = "select u from Festival f join f.unidadesVenta u  where f.id = :idFestival and type(u) = FoodTrack and u.patente = :patente";
			f1 = session.createQuery(hql, UnidadVenta.class).setParameter("idFestival", idFestival).setParameter("patente", patente).uniqueResult();
}finally {
			session.close();
		}
		return f1;
	}
}
