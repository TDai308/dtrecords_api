package com.dtrecords.dtrecords_api.repository;

import com.dtrecords.dtrecords_api.domain.Vinyl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VinylRepository extends JpaRepository<Vinyl, Long> {
}
