package org.spontaneous.serviceinfra.auth.dataaccess.api.repo;

import org.spontaneous.serviceinfra.auth.dataaccess.api.RoleEntity;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<RoleEntity, Long>{

	 RoleEntity findByName(String name);
	 
}
