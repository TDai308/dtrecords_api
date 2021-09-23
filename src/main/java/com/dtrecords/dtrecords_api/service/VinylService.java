package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Vinyl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface VinylService extends GeneralService<Vinyl>{
    Page<Vinyl> findAll(Pageable pageable);

    Optional<Vinyl> findById(Long id);

    void save(Vinyl vinyl);

    void remove(Long id);
}
