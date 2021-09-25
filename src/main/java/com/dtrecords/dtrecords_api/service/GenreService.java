package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Artist;
import com.dtrecords.dtrecords_api.domain.Genre;

import java.util.Optional;

public interface GenreService extends GeneralService<Genre>{
    Iterable<Genre> findAll();

    Optional<Genre> findById(Long id);

    Genre findByGenreName (String genreName);

    void save(Genre genre);

    void remove(Long id);
}
