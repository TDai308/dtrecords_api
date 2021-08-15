package com.dtrecords.dtrecords_api.service.Impl;

import com.dtrecords.dtrecords_api.domain.Vinyl;
import com.dtrecords.dtrecords_api.repository.VinylRepository;
import com.dtrecords.dtrecords_api.service.VinylService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VinylServiceImpl implements VinylService {
    private final VinylRepository vinylRepository;

    @Override
    public Iterable<Vinyl> findAll() {
        return vinylRepository.findAll();
    }

    @Override
    public Vinyl findById(Long id) {
        return vinylRepository.getById(id);
    }

    @Override
    public void save(Vinyl vinyl) {
        vinylRepository.save(vinyl);
    }

    @Override
    public void remove(Long id) {
        vinylRepository.deleteById(id);
    }
}
