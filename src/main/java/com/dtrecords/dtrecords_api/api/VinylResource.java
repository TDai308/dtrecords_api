package com.dtrecords.dtrecords_api.api;

import com.dtrecords.dtrecords_api.domain.User;
import com.dtrecords.dtrecords_api.domain.Vinyl;
import com.dtrecords.dtrecords_api.service.VinylService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VinylResource {
    private final VinylService vinylService;

    @GetMapping("/vinyls")
    public ResponseEntity<Iterable<Vinyl>> getVinyls() {
        Iterable<Vinyl> vinyls = vinylService.findAll();
        return new ResponseEntity<Iterable<Vinyl>>(vinyls, HttpStatus.OK);
    }

    @GetMapping("/vinyl/{id}")
    public ResponseEntity<Vinyl> getVinyl(@PathVariable Long id) {
        Optional<Vinyl> vinyl = vinylService.findById(id);
        if (!vinyl.isPresent()) {
            System.out.println("Vinyl with id " + id + " not found");
            return new ResponseEntity<Vinyl>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Vinyl>(vinyl.get(), HttpStatus.OK);
    }

    @PostMapping("/admin/vinyl")
    public ResponseEntity<Void> createVinyl(@RequestBody Vinyl vinyl, UriComponentsBuilder ucBuilder) {
        vinylService.save(vinyl);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/vinyl/{id}").buildAndExpand(vinyl.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/admin/vinyl/{id}")
    public ResponseEntity<Vinyl> updateVinyl(@PathVariable Long id, @RequestBody Vinyl vinyl) {
        Optional<Vinyl> currentVinyl = vinylService.findById(id);
        if (!currentVinyl.isPresent()) {
            System.out.println("Vinyl with id " + id + " not found");
            return new ResponseEntity<Vinyl>(HttpStatus.NOT_FOUND);
        }
        currentVinyl.get().setVinylName(vinyl.getVinylName());
        currentVinyl.get().setArtist(vinyl.getArtist());
        currentVinyl.get().setThumbnail1(vinyl.getThumbnail1());
        currentVinyl.get().setThumbnail2(vinyl.getThumbnail2());
        currentVinyl.get().setQuantity(vinyl.getQuantity());
        currentVinyl.get().setPrice(vinyl.getPrice());
        currentVinyl.get().setGenres(vinyl.getGenres());
        currentVinyl.get().setNation(vinyl.getNation());
        currentVinyl.get().setDiscount(vinyl.getDiscount());
        currentVinyl.get().setRealPrice(vinyl.getRealPrice());

        vinylService.save(currentVinyl.get());
        return new ResponseEntity<Vinyl>(currentVinyl.get(), HttpStatus.OK);
    }

    @DeleteMapping("/admin/vinyl/{id}")
    public ResponseEntity<Vinyl> deleteVinyl(@PathVariable Long id) {
        Optional<Vinyl> vinyl = vinylService.findById(id);
        if (!vinyl.isPresent()) {
            System.out.println("Vinyl with id " + id + " not found");
            return new ResponseEntity<Vinyl>(HttpStatus.NOT_FOUND);
        }
        vinylService.remove(id);
        return new ResponseEntity<Vinyl>(HttpStatus.NO_CONTENT);
    }
}
