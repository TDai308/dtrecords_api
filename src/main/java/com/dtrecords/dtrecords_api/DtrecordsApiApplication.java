package com.dtrecords.dtrecords_api;

import com.dtrecords.dtrecords_api.domain.Role;
import com.dtrecords.dtrecords_api.service.RoleService;
import com.dtrecords.dtrecords_api.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class DtrecordsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtrecordsApiApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
