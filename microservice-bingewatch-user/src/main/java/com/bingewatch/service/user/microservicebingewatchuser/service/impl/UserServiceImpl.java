package com.bingewatch.service.user.microservicebingewatchuser.service.impl;

import com.bingewatch.service.user.microservicebingewatchuser.dao.UserRepository;
import com.bingewatch.service.user.microservicebingewatchuser.dto.UserDTO;
import com.bingewatch.service.user.microservicebingewatchuser.entity.User;
import com.bingewatch.service.user.microservicebingewatchuser.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        //liste user de la base
        List<User> users = userRepository.findAll();
        // transfert vers une liste de favori dto
        List<UserDTO> usersDTO = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            usersDTO.add(userDTO);
        }
        return usersDTO;
    }

    @Override
    public UserDTO getUser(Integer id) {
        User user = userRepository.findById(id).get();
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public void deleteUser(Integer id) {}

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        User newUser = userRepository.save(user);
        BeanUtils.copyProperties(newUser, userDTO);

        System.out.println(user);
        return userDTO;
    }

    @Override
    public UserDTO updateUser(Integer id, UserDTO userDTO) {return null;}
}
