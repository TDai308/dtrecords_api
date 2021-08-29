package com.dtrecords.dtrecords_api.repository;

import com.dtrecords.dtrecords_api.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByRoleName(String roleName);
}
