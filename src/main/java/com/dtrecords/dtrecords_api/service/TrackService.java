package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Genre;
import com.dtrecords.dtrecords_api.domain.Track;

public interface TrackService {
    Iterable<Track> findAll();

    Track findById(Long id);

    void save(Track track);

    void remove(Long id);
}
