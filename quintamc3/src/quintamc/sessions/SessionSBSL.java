package quintamc.sessions;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Stateless
@LocalBean
public class SessionSBSL implements SessionSBSLLocal {

	private static final String PERSISTENCE_UN = "quintamc";

	public SessionSBSL() {
		super();
	}

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory(PERSISTENCE_UN).createEntityManager();
	}

	public boolean insertar(Class<? extends Serializable> entidad, Object o) {
		boolean retorno = true;

		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		try {

			if (!et.isActive()) {
				et.begin();
			}

			em.persist(entidad.cast(o));
			et.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (em != null) {
				em.clear();
				em.close();
			}
		}

		return retorno;
	}

	public List<?> buscar(Class<? extends Serializable> entidad, String condicion, String order) {

		List<?> lista = null;
		EntityManager em = getEntityManager();

		try {
			String consulta = "select object(o) from " + entidad.getSimpleName() + " as o";

			if (condicion != null && condicion.length() > 0) {
				consulta = consulta + " where " + condicion;
			}

			if (order != null && order.length() > 0) {
				consulta = consulta + " order by " + order;
			}

			em.getTransaction().begin();

			Query q = em.createQuery(consulta);
			q.setHint("javax.persistence.storeMode", "REFRESH");

			lista = q.getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (em != null) {
				em.clear();
				em.close();
			}
		}

		return lista;
	}

	public Object actualizar(Class<? extends Serializable> entidad, Object o) throws Exception {

		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			if (!et.isActive()) {
				et.begin();
			}

			em.merge(entidad.cast(o));
			et.commit();
		}

		catch (Exception e) {
			if (et != null)
				et.rollback();
			throw new Exception(e);

		}

		finally {
			if (em != null) {
				em.clear();
				em.close();
			}
		}

		return o;
	}

	public String obtenerPropiedadBD(String propiedad) {

		String retorno = "";
		EntityManager em = getEntityManager();

		try {
			String consulta = "select cnfValor from Configuracione where cnfDescripcion = '" + propiedad + "'";

			em.getTransaction().begin();

			Query q = em.createQuery(consulta);
			q.setHint("javax.persistence.storeMode", "REFRESH");

			retorno = (String) q.getSingleResult();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (em != null) {
				em.clear();
				em.close();
			}
		}

		return retorno;
	}

}
