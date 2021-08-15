package com.dtrecords.dtrecords_api.controller;

import com.dtrecords.dtrecords_api.domain.Nation;
import com.dtrecords.dtrecords_api.domain.User;
import com.dtrecords.dtrecords_api.service.NationService;
import com.dtrecords.dtrecords_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<Iterable<User>> getUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }
}
