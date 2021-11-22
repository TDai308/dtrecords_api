package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Nation;

import java.util.List;
import java.util.Optional;

public interface NationService {
    Iterable<Nation> findAll();

    Nation findByNation(String nation);

    Optional<Nation> findById(Long id);

    void save(Nation nation);
}
