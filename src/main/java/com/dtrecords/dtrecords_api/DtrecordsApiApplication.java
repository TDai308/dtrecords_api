package com.dtrecords.dtrecords_api;

import com.dtrecords.dtrecords_api.domain.Track;
import com.dtrecords.dtrecords_api.domain.Vinyl;
import com.dtrecords.dtrecords_api.service.TrackService;
import com.dtrecords.dtrecords_api.service.UserService;
import com.dtrecords.dtrecords_api.service.VinylService;
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

//    @Bean
//    CommandLineRunner run() {
//        return args -> {
//
//        };
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
