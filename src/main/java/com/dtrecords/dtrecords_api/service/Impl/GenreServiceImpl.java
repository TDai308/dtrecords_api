package com.dtrecords.dtrecords_api.service.Impl;

import com.dtrecords.dtrecords_api.domain.Genre;
import com.dtrecords.dtrecords_api.repository.GenreRepository;
import com.dtrecords.dtrecords_api.service.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public Iterable<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> findById(Long id) {
        return genreRepository.findById(id);
    }

    @Override
    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void remove(Long id) {
        genreRepository.deleteById(id);
    }
}
