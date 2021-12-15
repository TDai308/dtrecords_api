package com.dtrecords.dtrecords_api.api;

import com.dtrecords.dtrecords_api.domain.Nation;
import com.dtrecords.dtrecords_api.service.NationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = {"https://detran-records.netlify.app", "http://localhost:3000"})
public class NationResource {
    private final NationService nationService;

    @GetMapping("/nation")
    public ResponseEntity<Iterable<Nation>> getNationList() {
        return new ResponseEntity<Iterable<Nation>>(nationService.findAll(),HttpStatus.OK);
    }
}
