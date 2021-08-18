package com.dtrecords.dtrecords_api.repository;

import com.dtrecords.dtrecords_api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
