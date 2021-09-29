package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Track;
import com.dtrecords.dtrecords_api.domain.Vinyl;

import java.util.Optional;

public interface TrackService extends GeneralService<Track>{
    Iterable<Track> findAll();

    Iterable<Track> findAllByVinyl(Vinyl vinyl);

    Optional<Track> findById(Long id);

    void save(Track track);

    void remove(Long id);
}
