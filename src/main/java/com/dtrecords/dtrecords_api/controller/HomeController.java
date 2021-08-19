package com.dtrecords.dtrecords_api.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dtrecords.dtrecords_api.domain.User;
import com.dtrecords.dtrecords_api.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser() {
        org.springframework.security.core.userdetails.User userDetail = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetail.getUsername();
        log.info("email " + email);
        User user = userService.findByEmail(email);
        return ResponseEntity.ok().body(user);
//        String authorizationHeader = request.getHeader(AUTHORIZATION);
//        String token = authorizationHeader.substring("Bearer ".length());
//        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
//        JWTVerifier verifier = JWT.require(algorithm).build();
//        DecodedJWT decodedJWT = verifier.verify(token);
//        String email = decodedJWT.getSubject();
//        log.info("email " + email);
//        User user = userService.findByEmail(email);
//        return ResponseEntity.ok().body(user);
    }
}
