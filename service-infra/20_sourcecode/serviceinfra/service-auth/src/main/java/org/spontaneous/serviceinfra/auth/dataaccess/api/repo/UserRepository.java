package org.spontaneous.serviceinfra.auth.dataaccess.api.repo;

import java.util.List;
import java.util.Optional;

import org.spontaneous.serviceinfra.auth.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserEntity, Long>{

	Optional<UserEntity> findByEmail(String email);
	 
	List<UserEntity> findByLastname(String lastname);
}
