package com.dtrecords.dtrecords_api.service.Impl;

import com.dtrecords.dtrecords_api.domain.Artist;
import com.dtrecords.dtrecords_api.repository.ArtistRepository;
import com.dtrecords.dtrecords_api.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;
    private final EntityManager entityManager;

    @Override
    public Iterable<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public Iterable<Artist> findRandomArtists() {
        return artistRepository.findRandomArtists();
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
