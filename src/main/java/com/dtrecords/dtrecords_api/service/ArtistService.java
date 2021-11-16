package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Artist;

import java.util.Optional;

public interface ArtistService extends GeneralService<Artist>{
    Iterable<Artist> findAll();

    Iterable<Artist> findRandomArtists();

    Optional<Artist> findById(Long id);

    void save(Artist artist);

    void remove(Long id);
}
