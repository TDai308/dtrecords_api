package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Nation;

import java.util.List;

public interface NationService {
    List<Nation> findAll();

    void save(Nation nation);
}
