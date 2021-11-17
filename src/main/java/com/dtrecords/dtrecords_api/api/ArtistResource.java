package com.dtrecords.dtrecords_api.api;

import com.dtrecords.dtrecords_api.domain.Artist;
import com.dtrecords.dtrecords_api.domain.Vinyl;
import com.dtrecords.dtrecords_api.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/artists/random5Artists")
    public ResponseEntity<Iterable<Artist>> get5RandomArtists() {
        return new ResponseEntity<Iterable<Artist>>(artistService.findRandomArtists(5), HttpStatus.OK);
    };

    @PostMapping("/admin/artist")
    public ResponseEntity<Void> addNewArtist(@RequestParam("newArtist") String newArtist) {
        System.out.println(newArtist);
        artistService.save(new Artist(null,newArtist));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/admin/artist/{id}")
    public ResponseEntity<Artist> deleteArtist(@PathVariable Long id) {
        Optional<Artist> artist = artistService.findById(id);
        if (!artist.isPresent()) {
            System.out.println("Vinyl with id " + id + " not found");
            return new ResponseEntity<Artist>(HttpStatus.NOT_FOUND);
        }
        artistService.remove(id);
        return new ResponseEntity<Artist>(HttpStatus.NO_CONTENT);
    }
}
