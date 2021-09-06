package com.dtrecords.dtrecords_api.service.Impl;

import com.dtrecords.dtrecords_api.domain.Nation;
import com.dtrecords.dtrecords_api.repository.NationRepository;
import com.dtrecords.dtrecords_api.service.NationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class NationServiceImpl implements NationService {
    private final NationRepository nationRepository;

    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public void save(Nation nation) {
        nationRepository.save(nation);
    }
}
