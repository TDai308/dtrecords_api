package com.dtrecords.dtrecords_api;

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

//    @Bean
//    CommandLineRunner runner(UserService userService, RoleService roleService) {
//        return args -> {
//            roleService.save(new Role(null,"ROLE_USER"));
//            roleService.save(new Role(null,"ROLE_ADMIN"));
//
//            userService.save(new User(null,"Bruce Wayne","Batman","1234","0123456789","batman123@gmail.com","Gotham City",new ArrayList<>()));
//            userService.addRoleToUser(3L,1L);
//            userService.addRoleToUser(3L,2L);
//            userService.save(new User(null,"Tony Start","Ironman","1234","0123456789","ironman123@gmail.com","Gotham City",new ArrayList<>()));
//            userService.addRoleToUser(4L,1L);
//            userService.save(new User(null,"Steve Roger","CaptainA","1234","0123456789","captainamerican@gmail.com","Gotham City",new ArrayList<>()));
//            userService.addRoleToUser(5L,1L);
//        };
//    }
}
