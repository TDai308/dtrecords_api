package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Genre;
import com.dtrecords.dtrecords_api.domain.Track;

import java.util.Optional;

public interface TrackService extends GeneralService<Track>{
    Iterable<Track> findAll();

    Optional<Track> findById(Long id);

    void save(Track track);

    void remove(Long id);
}
