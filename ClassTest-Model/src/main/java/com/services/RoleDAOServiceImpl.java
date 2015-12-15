package com.services;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.domain.Role;
import com.repository.EntityManagerUtil;

public class RoleDAOServiceImpl implements RoleDAOService {

	

	private EntityManager em;
	
	public RoleDAOServiceImpl() {
	 
		
		em = EntityManagerUtil.entityM;
	}

	public Role getRoleById(int id) {
	
		TypedQuery<Role> query = em.createQuery(
				"Select x from Role x where x.role_id =:id ", Role.class);
		query.setParameter("id", id);
		Role p = query.getSingleResult();
		return p;
	}

}
