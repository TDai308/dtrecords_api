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

//    @Bean
//    CommandLineRunner run(NationService nationService) {
//        return args -> {
//            nationService.save(new Nation(null, "Việt Nam"));
//            nationService.save(new Nation(null, "Mỹ"));
//            nationService.save(new Nation(null, "Hàn Quốc"));
//        };
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
