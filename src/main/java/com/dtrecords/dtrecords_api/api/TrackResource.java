package com.dtrecords.dtrecords_api.api;

import com.dtrecords.dtrecords_api.domain.Track;
import com.dtrecords.dtrecords_api.service.TrackService;
import com.dtrecords.dtrecords_api.service.VinylService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TrackResource {
    private final TrackService trackService;
    private final VinylService vinylService;

    @GetMapping({"/tracks", "/tracks/{idVinyl}"})
    public ResponseEntity<Iterable<Track>> getTrackList(@PathVariable(required = false) String idVinyl) {
        Iterable<Track> trackList;
        if (idVinyl == null) {
            trackList = trackService.findAll();
        } else trackList = trackService.findAllByVinyl(vinylService.findById(Long.parseLong(idVinyl)).orElse(null));
        return new ResponseEntity<Iterable<Track>>(trackList, HttpStatus.OK);
    };
}
