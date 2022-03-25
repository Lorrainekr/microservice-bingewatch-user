package com.bingewatch.service.user.microservicebingewatchuser.service;

import com.bingewatch.service.user.microservicebingewatchuser.dto.UserDTO;

import java.util.List;

public interface UserService {
    public List<UserDTO> getAllUsers();
    public UserDTO getUser(Integer id);
    public void deleteUser(Integer id);
    public UserDTO getUSerByEmail(String email);
    public UserDTO createUser(UserDTO userDTO);
    public UserDTO updateUser(UserDTO userDTO, String encodedPassword, String id);

    public UserDTO save(UserDTO userDTO);

}
