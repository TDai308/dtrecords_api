package com.dtrecords.dtrecords_api.api;

import com.dtrecords.dtrecords_api.domain.Track;
import com.dtrecords.dtrecords_api.service.TrackService;
import com.dtrecords.dtrecords_api.service.VinylService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = {"https://detran-records.netlify.app", "http://localhost:3000"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TrackResource {
    private final TrackService trackService;
    private final VinylService vinylService;

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    ObjectMapper objectMapper = new ObjectMapper();

    Path staticPath = Paths.get("static");
    Path tracksPreviewPath = Paths.get("trackPreview");

    @GetMapping({"/tracks", "/tracks/{idVinyl}"})
    public ResponseEntity<Iterable<Track>> getTrackList(@PathVariable(required = false) String idVinyl) {
        Iterable<Track> trackList;
        if (idVinyl == null) {
            trackList = trackService.findAll();
        } else trackList = trackService.findAllByVinyl(vinylService.findById(Long.parseLong(idVinyl)).orElse(null));
        return new ResponseEntity<Iterable<Track>>(trackList, HttpStatus.OK);
    }

    @GetMapping("/track/{id}")
    public ResponseEntity<Track> getVinyl(@PathVariable Long id) {
        Optional<Track> track = trackService.findById(id);
        if (!track.isPresent()) {
            System.out.println("Vinyl with id " + id + " not found");
            return new ResponseEntity<Track>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Track>(track.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/admin/track", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> createTrack(@RequestParam("track") String trackJson, @RequestParam("trackPreview") MultipartFile trackPreview, UriComponentsBuilder ucBuilder) throws IOException {
        Track track = objectMapper.readValue(trackJson, Track.class);
        Path albumPath = Paths.get(track.getVinyl().getVinylName() + "-" + track.getVinyl().getArtist().getNameArtist());
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(tracksPreviewPath).resolve(albumPath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(tracksPreviewPath).resolve(albumPath));
        }
        Path trackPreviewPath = CURRENT_FOLDER.resolve(staticPath).resolve(tracksPreviewPath).resolve(albumPath).resolve(Objects.requireNonNull(trackPreview.getOriginalFilename()));

        try (OutputStream os = Files.newOutputStream(trackPreviewPath)) {
            os.write(trackPreview.getBytes());
        }

        track.setTrackPreview((tracksPreviewPath.resolve(albumPath).resolve(Objects.requireNonNull(trackPreview.getOriginalFilename()))).toString());
        trackService.save(track);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/track/{id}").buildAndExpand(track.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/admin/track/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Track> updateTrack(@PathVariable("id") Long id,@RequestParam("track") String trackJson, @RequestParam(value = "trackPreview", required = false) MultipartFile trackPreview, UriComponentsBuilder ucBuilder) throws IOException {
        Track track = objectMapper.readValue(trackJson, Track.class);
        Optional<Track> currentTrack = trackService.findById(id);
        if (!currentTrack.isPresent()) {
            System.out.println("Track with id " + id + " not found");
            return new ResponseEntity<Track>(HttpStatus.NOT_FOUND);
        }
        Path albumPath = Paths.get(track.getVinyl().getVinylName() + "-" + track.getVinyl().getArtist().getNameArtist());
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(tracksPreviewPath).resolve(albumPath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(tracksPreviewPath).resolve(albumPath));
        }
        if (track.getVinyl() != currentTrack.get().getVinyl()) {
            if (trackPreview != null) {
                Path trackPreviewPath = CURRENT_FOLDER.resolve(staticPath).resolve(tracksPreviewPath).resolve(albumPath).resolve(Objects.requireNonNull(trackPreview.getOriginalFilename()));

                try (OutputStream os = Files.newOutputStream(trackPreviewPath)) {
                    os.write(trackPreview.getBytes());
                }
                if (currentTrack.get().getTrackPreview() != null) {
                    Files.deleteIfExists((CURRENT_FOLDER.resolve(staticPath).resolve(currentTrack.get().getTrackPreview())));
                }
                currentTrack.get().setTrackPreview((tracksPreviewPath.resolve(albumPath).resolve(Objects.requireNonNull(trackPreview.getOriginalFilename()))).toString());
            } else {
                File file = new File(CURRENT_FOLDER.resolve(staticPath).resolve(currentTrack.get().getTrackPreview()).toString());
                Files.move((CURRENT_FOLDER.resolve(staticPath).resolve(currentTrack.get().getTrackPreview())),
                        CURRENT_FOLDER.resolve(staticPath).resolve(tracksPreviewPath).resolve(albumPath).resolve(file.getName()));
                currentTrack.get().setTrackPreview((tracksPreviewPath.resolve(albumPath).resolve(file.getName())).toString());
            }
        } else {
            if (trackPreview != null) {
                Path trackPreviewPath = CURRENT_FOLDER.resolve(staticPath).resolve(tracksPreviewPath).resolve(albumPath).resolve(Objects.requireNonNull(trackPreview.getOriginalFilename()));

                try (OutputStream os = Files.newOutputStream(trackPreviewPath)) {
                    os.write(trackPreview.getBytes());
                }
                if (currentTrack.get().getTrackPreview() != null) {
                    Files.deleteIfExists((CURRENT_FOLDER.resolve(staticPath).resolve(currentTrack.get().getTrackPreview())));
                }
                currentTrack.get().setTrackPreview((tracksPreviewPath.resolve(albumPath).resolve(Objects.requireNonNull(trackPreview.getOriginalFilename()))).toString());
            }
        }

        currentTrack.get().setTrackName(track.getTrackName());
        currentTrack.get().setArtists(track.getArtists());
        currentTrack.get().setVinyl(track.getVinyl());

        trackService.save(currentTrack.get());
        return new ResponseEntity<Track>(currentTrack.get(), HttpStatus.OK);
    }
}
