package com.dtrecords.dtrecords_api.repository;

import com.dtrecords.dtrecords_api.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
