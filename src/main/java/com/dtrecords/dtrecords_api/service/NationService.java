package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Nation;

import java.util.List;

public interface NationService {
    Iterable<Nation> findAll();

    Nation findByNation(String nation);

    void save(Nation nation);
}
