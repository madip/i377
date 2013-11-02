package dao;

import java.util.List;
import javax.persistence.*;
import model.Unit;
import util.JpaUtil;

public class UnitDao {

	private static void close(EntityManager em) {
		if (em != null)
			em.close();
	}

	public List<Unit> findAllUnits() {
		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();

			List<Unit> query = em.createQuery("SELECT p FROM Unit p",
					Unit.class).getResultList();
			return query;
		} finally {
			close(em);
		}
	}

	public Unit findByCode(String code) {
		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();

			Unit query = em.createQuery(
					"select p from Unit p where p.code='" + code + "'",
					Unit.class).getSingleResult();
			return query;
		} finally {
			close(em);
		}
	}

	public List<Unit> findChildUnits(Long id) {
		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();

			List<Unit> query = em.createQuery(
					"select p from Unit p where p.super_unit_id = " + id,
					Unit.class).getResultList();
			return query;
		} finally {
			close(em);
		}
	}
	
	public Unit findById(Long id) {
		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();
			return em.find(Unit.class, id);
		} finally {
			em.close();
		}
	}

	public void delete() {
		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("delete from Unit where 1=1");
			query.executeUpdate();
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public void delete(Long id) {

		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();
			em.getTransaction().begin();

			Unit unitx = em.find(Unit.class, id);
			if (unitx != null)
				em.remove(unitx);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public List<Unit> search(String s) {
		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();
			List<Unit> query = em.createQuery(
					"select p from Unit p where LOWER(p.name) LIKE '%"
							+ s.toLowerCase() + "%'", Unit.class)
					.getResultList();
			return query;
		} finally {
			em.close();
		}
	}

	public void save(Unit unit) {
		EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();
			em.getTransaction().begin();
			if (unit.getId() == null) {
				em.persist(unit);
			} else {
				em.merge(unit);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
