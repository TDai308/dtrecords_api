package com.dtrecords.dtrecords_api;

import com.dtrecords.dtrecords_api.domain.Role;
import com.dtrecords.dtrecords_api.domain.User;
import com.dtrecords.dtrecords_api.service.RoleService;
import com.dtrecords.dtrecords_api.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DtrecordsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtrecordsApiApplication.class, args);
    }

//    @Bean
//    CommandLineRunner run(UserService userService, RoleService roleService) {
//        return args -> {
//            roleService.save(new Role(null,"ROLE_USER"));
//            roleService.save(new Role(null,"ROLE_ADMIN"));
//
//            userService.addRoleToUser("batman123@gmail.com","ROLE_USER");
//            userService.addRoleToUser("batman123@gmail.com","ROLE_ADMIN");
//        };
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
