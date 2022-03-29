package com.bingewatch.service.user.microservicebingewatchuser.dao;

import com.bingewatch.service.user.microservicebingewatchuser.model.Role;
import com.bingewatch.service.user.microservicebingewatchuser.model.TypeRole;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByTypeRole(TypeRole typeRole);
}
