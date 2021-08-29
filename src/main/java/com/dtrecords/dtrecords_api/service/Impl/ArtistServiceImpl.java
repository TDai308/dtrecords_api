package com.dtrecords.dtrecords_api.service.Impl;

import com.dtrecords.dtrecords_api.domain.Artist;
import com.dtrecords.dtrecords_api.repository.ArtistRepository;
import com.dtrecords.dtrecords_api.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    @Override
    public Iterable<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public Optional<Artist> findById(Long id) {
        return artistRepository.findById(id);
    }

    @Override
    public void save(Artist artist) {
        artistRepository.save(artist);
    }

    @Override
    public void remove(Long id) {
        artistRepository.deleteById(id);
    }
}
