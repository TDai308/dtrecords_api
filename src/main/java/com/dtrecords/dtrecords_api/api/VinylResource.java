package com.dtrecords.dtrecords_api.api;

import com.dtrecords.dtrecords_api.domain.Genre;
import com.dtrecords.dtrecords_api.domain.Vinyl;
import com.dtrecords.dtrecords_api.service.GenreService;
import com.dtrecords.dtrecords_api.service.NationService;
import com.dtrecords.dtrecords_api.service.VinylService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VinylResource {
    private final VinylService vinylService;
    private final GenreService genreService;
    private final NationService nationService;

    ObjectMapper objectMapper = new ObjectMapper();

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    private Pageable checkTheSort(Pageable pageable, int page, int size, String sort, String direction) {
        if (direction != null && sort != null) {
            pageable = PageRequest.of(
                    page, size,
                    direction.equalsIgnoreCase("asc") ? Sort.by(sort).ascending() : Sort.by(sort).descending()
            );
        }
        return pageable;
    }

    @GetMapping("/vinyls")
    public ResponseEntity<Page<Vinyl>> getVinyls(Pageable pageable,@RequestParam(required = false) int page, @RequestParam(required = false) int size, @RequestParam(required = false) String sort, @RequestParam(required = false) String direction) {
        pageable = checkTheSort(pageable,page,size,sort,direction);
        Page<Vinyl> vinyls = vinylService.findAll(pageable);
        return new ResponseEntity<Page<Vinyl>>(vinyls, HttpStatus.OK);
    }

    @GetMapping("/vinyls/{productsOption}")
    public ResponseEntity<Page<Vinyl>> getVinylsOption(Pageable pageable,@RequestParam(required = false) int page, @RequestParam(required = false) int size, @RequestParam(required = false) String sort, @RequestParam(required = false) String direction, @PathVariable(name = "productsOption") String productsOption) {
        pageable = checkTheSort(pageable,page,size,sort,direction);
        Page<Vinyl> vinyls = null;
        switch (productsOption) {
            case "saleProducts":
                vinyls = vinylService.findAllByDiscountGreaterThan(0L, pageable);
                break;
            case "under10Dollars":
                vinyls = vinylService.findAllByRealPriceLessThanEqual(10D, pageable);
                break;
            case "under20Dollars":
                vinyls = vinylService.findAllByRealPriceLessThanEqual(20D, pageable);
                break;
            case "under30Dollars":
                vinyls = vinylService.findAllByRealPriceLessThanEqual(30D, pageable);
                break;
            case "over30Dollars":
                vinyls = vinylService.findAllByRealPriceGreaterThanEqual(30D, pageable);
                break;
            case "VietnamVinyls":
                vinyls = vinylService.findAllByNation(nationService.findByNation("Việt Nam"), pageable);
                break;
            case "UsUkVinyls":
                vinyls = vinylService.findAllByNation(nationService.findByNation("Mỹ"), pageable);
                break;
            case "KoreanVinyls":
                vinyls = vinylService.findAllByNation(nationService.findByNation("Hàn Quốc"), pageable);
                break;
            case "popVinyl":
                vinyls = vinylService.findAllByGenre(genreService.findByGenreName("Pop"), pageable, sort, direction);
                break;
            case "rockVinyl":
                vinyls = vinylService.findAllByGenre(genreService.findByGenreName("Rock"), pageable, sort, direction);
                break;
            case "r&bVinyl":
                vinyls = vinylService.findAllByGenre(genreService.findByGenreName("R&B"), pageable, sort, direction);
                break;
            case "hiphopVinyl":
                vinyls = vinylService.findAllByGenre(genreService.findByGenreName("HipHop"), pageable, sort, direction);
                break;
            case "countryVinyl":
                vinyls = vinylService.findAllByGenre(genreService.findByGenreName("Country"), pageable, sort, direction);
                break;
            case "edmVinyl":
                vinyls = vinylService.findAllByGenre(genreService.findByGenreName("EDM"), pageable, sort, direction);
                break;
            case "indieVinyl":
                vinyls = vinylService.findAllByGenre(genreService.findByGenreName("Indie"), pageable, sort, direction);
                break;
            case "jazzVinyl":
                vinyls = vinylService.findAllByGenre(genreService.findByGenreName("Jazz"), pageable, sort, direction);
                break;
        }
        return new ResponseEntity<Page<Vinyl>>(vinyls, HttpStatus.OK);
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

    @PostMapping(value = "/admin/vinyl", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> createVinyl(@RequestParam("vinyl") String vinylJson, @RequestParam("thumbnail1") MultipartFile thumbnail1 , @RequestParam("thumbnail2") MultipartFile thumbnail2, UriComponentsBuilder ucBuilder) throws IOException {
        Vinyl vinyl = objectMapper.readValue(vinylJson, Vinyl.class);
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        Path vinylsImagePath = Paths.get("vinylsImage");
        Path vinylImagePath = Paths.get(vinyl.getVinylName() + " - " + vinyl.getArtist().getNameArtist());
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(vinylsImagePath).resolve(vinylImagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(vinylsImagePath).resolve(vinylImagePath));
        }
        Path thumbnail1Image = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(vinylsImagePath).resolve(vinylImagePath).resolve(Objects.requireNonNull(thumbnail1.getOriginalFilename()));
        Path thumbnail2Image = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(vinylsImagePath).resolve(vinylImagePath).resolve(Objects.requireNonNull(thumbnail2.getOriginalFilename()));

        try (OutputStream os = Files.newOutputStream(thumbnail1Image)) {
            os.write(thumbnail1.getBytes());
        }
        try (OutputStream os = Files.newOutputStream(thumbnail2Image)) {
            os.write(thumbnail2.getBytes());
        }
        vinyl.setThumbnail1((imagePath.resolve(vinylsImagePath).resolve(vinylImagePath).resolve(Objects.requireNonNull(thumbnail1.getOriginalFilename()))).toString());
        vinyl.setThumbnail2((imagePath.resolve(vinylsImagePath).resolve(vinylImagePath).resolve(Objects.requireNonNull(thumbnail2.getOriginalFilename()))).toString());
        vinylService.save(vinyl);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/vinyl/{id}").buildAndExpand(vinyl.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/admin/vinyl/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Vinyl> updateVinyl(@PathVariable Long id, @RequestParam("vinyl") String vinylJson,@RequestParam(name = "thumbnail1",required = false) MultipartFile thumbnail1 , @RequestParam(name = "thumbnail2",required = false) MultipartFile thumbnail2) throws IOException {
        Vinyl vinyl = objectMapper.readValue(vinylJson, Vinyl.class);
        Optional<Vinyl> currentVinyl = vinylService.findById(id);
        if (!currentVinyl.isPresent()) {
            System.out.println("Vinyl with id " + id + " not found");
            return new ResponseEntity<Vinyl>(HttpStatus.NOT_FOUND);
        }

        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        Path vinylsImagePath = Paths.get("vinylsImage");
        Path vinylImagePath = Paths.get(vinyl.getVinylName() + " - " + vinyl.getArtist().getNameArtist());
        Path currentVinylImagePath = Paths.get(currentVinyl.get().getVinylName() + " - " + currentVinyl.get().getArtist().getNameArtist());

        if (!vinyl.getVinylName().equals(currentVinyl.get().getVinylName()) || !vinyl.getArtist().getNameArtist().equals(currentVinyl.get().getArtist().getNameArtist())) {
            if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(vinylsImagePath).resolve(vinylImagePath))) {
                Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(vinylsImagePath).resolve(vinylImagePath));
            }
            if (thumbnail1 != null) {
                Path thumbnail1Image = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(vinylsImagePath).resolve(vinylImagePath).resolve(Objects.requireNonNull(thumbnail1.getOriginalFilename()));
                try (OutputStream os = Files.newOutputStream(thumbnail1Image)) {
                    os.write(thumbnail1.getBytes());
                }
                Files.deleteIfExists(Paths.get(CURRENT_FOLDER + "\\" + staticPath.toString() + "\\" + currentVinyl.get().getThumbnail1()));
                currentVinyl.get().setThumbnail1((imagePath.resolve(vinylsImagePath).resolve(vinylImagePath).resolve(Objects.requireNonNull(thumbnail1.getOriginalFilename()))).toString());
            } else {
                File file = new File(CURRENT_FOLDER + "\\" + staticPath.toString() + "\\" + currentVinyl.get().getThumbnail1());
                Files.move(Paths.get(CURRENT_FOLDER + "\\" + staticPath.toString() + "\\" + currentVinyl.get().getThumbnail1()),
                        CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(vinylsImagePath).resolve(vinylImagePath).resolve(file.getName()));
                currentVinyl.get().setThumbnail1((imagePath.resolve(vinylsImagePath).resolve(vinylImagePath).resolve(file.getName())).toString());
            }
            if (thumbnail2 != null) {
                Path thumbnail2Image = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(vinylsImagePath).resolve(vinylImagePath).resolve(Objects.requireNonNull(thumbnail2.getOriginalFilename()));
                try (OutputStream os = Files.newOutputStream(thumbnail2Image)) {
                    os.write(thumbnail2.getBytes());
                }
                Files.deleteIfExists(Paths.get(CURRENT_FOLDER + "\\" + staticPath.toString() + "\\" + currentVinyl.get().getThumbnail2()));
                currentVinyl.get().setThumbnail1((imagePath.resolve(vinylsImagePath).resolve(vinylImagePath).resolve(Objects.requireNonNull(thumbnail2.getOriginalFilename()))).toString());
            } else {
                File file = new File(CURRENT_FOLDER + "\\" + staticPath.toString() + "\\" + currentVinyl.get().getThumbnail2());
                Files.move(Paths.get(CURRENT_FOLDER + "\\" + staticPath.toString() + "\\" + currentVinyl.get().getThumbnail2()),
                        CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(vinylsImagePath).resolve(vinylImagePath).resolve(file.getName()));
                currentVinyl.get().setThumbnail2((imagePath.resolve(vinylsImagePath).resolve(vinylImagePath).resolve(file.getName())).toString());
            }
            Files.delete(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(vinylsImagePath).resolve(currentVinylImagePath));
        } else {
            if (thumbnail1 != null) {
                Path thumbnail1Image = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(vinylsImagePath).resolve(vinylImagePath).resolve(Objects.requireNonNull(thumbnail1.getOriginalFilename()));
                try (OutputStream os = Files.newOutputStream(thumbnail1Image)) {
                    os.write(thumbnail1.getBytes());
                }
                Files.deleteIfExists(Paths.get(CURRENT_FOLDER + "\\" + staticPath.toString() + "\\" + currentVinyl.get().getThumbnail1()));
                currentVinyl.get().setThumbnail1((imagePath.resolve(vinylsImagePath).resolve(vinylImagePath).resolve(Objects.requireNonNull(thumbnail1.getOriginalFilename()))).toString());
            }
            if (thumbnail2 != null) {
                Path thumbnail2Image = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(vinylsImagePath).resolve(vinylImagePath).resolve(Objects.requireNonNull(thumbnail2.getOriginalFilename()));
                try (OutputStream os = Files.newOutputStream(thumbnail2Image)) {
                    os.write(thumbnail2.getBytes());
                }
                Files.deleteIfExists(Paths.get(CURRENT_FOLDER + "\\" + staticPath.toString() + "\\" + currentVinyl.get().getThumbnail2()));
                currentVinyl.get().setThumbnail2((imagePath.resolve(vinylsImagePath).resolve(vinylImagePath).resolve(Objects.requireNonNull(thumbnail2.getOriginalFilename()))).toString());
            }
        }

        currentVinyl.get().setVinylName(vinyl.getVinylName());
        currentVinyl.get().setArtist(vinyl.getArtist());
        currentVinyl.get().setQuantity(vinyl.getQuantity());
        currentVinyl.get().setPrice(vinyl.getPrice());
        currentVinyl.get().setGenres(vinyl.getGenres());
        currentVinyl.get().setNation(vinyl.getNation());
        currentVinyl.get().setDiscount(vinyl.getDiscount());

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

    @GetMapping("/genres")
    public ResponseEntity<Iterable<Genre>> getGenreList() {
        return new ResponseEntity<Iterable<Genre>>(genreService.findAll(), HttpStatus.OK);
    }
}
