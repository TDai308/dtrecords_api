package com.dtrecords.dtrecords_api.repository;

import com.dtrecords.dtrecords_api.domain.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationRepository extends JpaRepository<Nation, Long> {
    Nation findByNation(String nation);
}
