package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Artist;
import com.dtrecords.dtrecords_api.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findById(Long idRole);

    void save(Role role);
}
