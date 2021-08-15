package com.dtrecords.dtrecords_api.repository;

import com.dtrecords.dtrecords_api.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
