package com.dtrecords.dtrecords_api.repository;

import com.dtrecords.dtrecords_api.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {
}
