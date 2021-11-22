package com.dtrecords.dtrecords_api.repository;

import com.dtrecords.dtrecords_api.domain.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NationRepository extends JpaRepository<Nation, Long> {
    Nation findByNation(String nation);
}
