package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Genre;
import com.dtrecords.dtrecords_api.domain.Vinyl;

public interface VinylService{
    Iterable<Vinyl> findAll();

    Vinyl findById(Long id);

    void save(Vinyl vinyl);

    void remove(Long id);
}
