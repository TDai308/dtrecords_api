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
//    CommandLineRunner run(ArtistService artistService, GenreService genreService) {
//        return args -> {
//            genreService.save(new Genre(null, "Pop"));
//            genreService.save(new Genre(null, "Rock"));
//            genreService.save(new Genre(null, "R&B"));
//            genreService.save(new Genre(null, "HipHop"));
//            genreService.save(new Genre(null, "Country"));
//            genreService.save(new Genre(null, "EDM"));
//            genreService.save(new Genre(null, "Indie"));
//            genreService.save(new Genre(null, "Jazz"));
//        };
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
