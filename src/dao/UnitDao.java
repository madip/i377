package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import model.Unit;

@Repository
public class UnitDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	public List<Unit> findAll() {

		List<Unit> query = em.createQuery("SELECT p FROM Unit p", Unit.class)
				.getResultList();
		return query;

	}

	@Transactional(readOnly = true)
	public Unit findById(Long id) {

		return em.find(Unit.class, id);

	}

	@Transactional(readOnly = true)
	public Unit findByCode(String code) {

		Unit temp = em.createQuery(
				"SELECT p FROM Unit p WHERE p.code='" + code + "'", Unit.class)
				.getSingleResult();

		return temp;
	}

	@Transactional(readOnly = true)
	public List<Unit> findSubUnits(String id) {

		TypedQuery<Unit> query = em.createQuery(
				"SELECT p FROM Unit p WHERE p.superUnitId = '" + id + "'",
				Unit.class);
		return query.getResultList();

	}

	@Transactional(readOnly = true)
	public List<Unit> searchByString(String find) {

		TypedQuery<Unit> query = em.createQuery(
				"SELECT e FROM Unit e WHERE LCASE(e.name) LIKE '%"
						+ find.toLowerCase() + "%'", Unit.class);
		return query.getResultList();
	}

	@Transactional
	public boolean deleteByCode(String code) {

		Query q = em.createQuery("DELETE FROM Unit u WHERE u.code = '" + code
				+ "' OR u.superUnitId= '" + code + "'");
		q.executeUpdate();

		return true;
	}

	@Transactional
	public boolean deleteAll() {

		Query q = em.createQuery("DELETE FROM Unit");
		q.executeUpdate();

		return true;
	}

	@Transactional
	public void save(Unit item) {

		if (item.getId() == null) {
			em.persist(item);
		} else {
			em.merge(item);
		}

	}
}
