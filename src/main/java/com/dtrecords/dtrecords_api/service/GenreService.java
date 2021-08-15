package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Artist;
import com.dtrecords.dtrecords_api.domain.Genre;

public interface GenreService{
    Iterable<Genre> findAll();

    Genre findById(Long id);

    void save(Genre genre);

    void remove(Long id);
}
