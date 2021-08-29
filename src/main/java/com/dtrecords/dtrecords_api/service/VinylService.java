package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Vinyl;

import java.util.Optional;

public interface VinylService extends GeneralService<Vinyl>{
    Iterable<Vinyl> findAll();

    Optional<Vinyl> findById(Long id);

    void save(Vinyl vinyl);

    void remove(Long id);
}
