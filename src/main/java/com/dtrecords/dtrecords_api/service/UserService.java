package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Genre;
import com.dtrecords.dtrecords_api.domain.User;

public interface UserService{
    Iterable<User> findAll();

    User findById(Long id);

    void addRoleToUser(Long idUser, Long idRole);

    void save(User user);

    void remove(Long id);
}
