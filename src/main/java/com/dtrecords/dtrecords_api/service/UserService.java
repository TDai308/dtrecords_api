package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Genre;
import com.dtrecords.dtrecords_api.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends GeneralService<User>{
    List<User> findAll();

    Optional<User> findById(Long id);

    void addRoleToUser(String userEmail, String roleName);

    void deleteRoleToUser(String userEmail, String roleName);

    User findByEmail(String email);

    void save(User user);

    void remove(Long id);
}
