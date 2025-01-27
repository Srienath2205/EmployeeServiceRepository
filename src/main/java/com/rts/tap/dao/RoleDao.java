package com.rts.tap.dao;

import java.util.List;
import com.rts.tap.model.Role;

public interface RoleDao {


	List<Role> getAllRole();
	Role getRoleByName(String roleName);
	Role getRoleById(Long id);
	
}

