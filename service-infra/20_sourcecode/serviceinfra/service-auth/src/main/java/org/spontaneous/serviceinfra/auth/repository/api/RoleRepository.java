package org.spontaneous.serviceinfra.auth.repository.api;

import org.spontaneous.serviceinfra.auth.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<RoleEntity, Long>{

	 RoleEntity findByName(String name);
	 
}
