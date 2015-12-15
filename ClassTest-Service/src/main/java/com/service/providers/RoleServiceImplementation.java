package com.service.providers;

import com.domain.Role;
import com.services.RoleDAOService;
import com.services.RoleDAOServiceImpl;

public class RoleServiceImplementation implements RoleService{

	RoleDAOService dao=new RoleDAOServiceImpl();
	public Role getRoleById(int id) {
		return dao.getRoleById(id);
	}

}
