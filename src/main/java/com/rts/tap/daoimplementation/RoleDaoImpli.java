package com.rts.tap.daoimplementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rts.tap.dao.RoleDao;
import com.rts.tap.model.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RoleDaoImpli implements RoleDao {

	private EntityManager entityManager;

	public RoleDaoImpli(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRole() {
		String hql = "from Role";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	public Role getRoleById(Long id) {
		return entityManager.find(Role.class, id);
	}

	public Role getRoleByName(String roleName) {
		try {
			return entityManager.createQuery("SELECT r FROM Role r WHERE r.roleName = :roleName", Role.class)
					.setParameter("roleName", roleName).getSingleResult();
		} catch (NoResultException e) {
			// Handle the case when no role is found
			System.err.println("Role not found for roleName: " + roleName);
			return null; // Or throw a custom exception depending on the use case
		}
	}

}
