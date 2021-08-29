package com.dtrecords.dtrecords_api.service.Impl;

import com.dtrecords.dtrecords_api.domain.Artist;
import com.dtrecords.dtrecords_api.domain.Track;
import com.dtrecords.dtrecords_api.repository.ArtistRepository;
import com.dtrecords.dtrecords_api.repository.TrackRepository;
import com.dtrecords.dtrecords_api.service.TrackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepository;

    @Override
    public Iterable<Track> findAll() {
        return trackRepository.findAll();
    }

    @Override
    public Optional<Track> findById(Long id) {
        return trackRepository.findById(id);
    }

    @Override
    public void save(Track track) {
        trackRepository.save(track);
    }

    @Override
    public void remove(Long id) {
        trackRepository.deleteById(id);
    }
}
