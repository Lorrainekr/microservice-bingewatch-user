package com.bingewatch.service.user.microservicebingewatchuser.service;

import com.bingewatch.service.user.microservicebingewatchuser.dao.RoleRepository;
import com.bingewatch.service.user.microservicebingewatchuser.model.Role;
import com.bingewatch.service.user.microservicebingewatchuser.model.TypeRole;
import com.bingewatch.service.user.microservicebingewatchuser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;


    public User roleOfUserRegistrered(User user) {
        Role role = roleRegistreredExist();
        user.setRole(role);
        user.setIsAdmin(false);
        return user;
    }
    public Role roleRegistreredExist() {
        Optional<Role> role = roleRepository.findByTypeRole(TypeRole.REGISTRERED);
        if(!role.isPresent()) {
            Role nouveauRole = new Role();
            nouveauRole.setTypeRole(TypeRole.REGISTRERED);
            roleRepository.save(nouveauRole);
            return nouveauRole;
        }
        return role.get();
    }


    public User roleOfUserAdmin(User user) {
        Role role = roleAdminExist();
        user.setRole(role);
        user.setIsAdmin(true);
        return user;
    }
    public Role roleAdminExist() {

        Optional<Role> role = roleRepository.findByTypeRole(TypeRole.ADMINISTRATOR);
        if(!role.isPresent()) {
            Role nouveauRole = new Role();
            nouveauRole.setTypeRole(TypeRole.ADMINISTRATOR);
            roleRepository.save(nouveauRole);
            return nouveauRole;
        }
        return role.get();
    }
}
