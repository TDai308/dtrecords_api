package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Artist;

public interface ArtistService{
    Iterable<Artist> findAll();

    Artist findById(Long id);

    void save(Artist artist);

    void remove(Long id);
}
