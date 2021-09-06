package com.dtrecords.dtrecords_api.api;

import com.dtrecords.dtrecords_api.domain.Artist;
import com.dtrecords.dtrecords_api.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ArtistResource {
    private final ArtistService artistService;

    @GetMapping("/artists")
    public ResponseEntity<Iterable<Artist>> getArtists() {
      return new ResponseEntity<Iterable<Artist>>(artistService.findAll(), HttpStatus.OK);
    };
}
