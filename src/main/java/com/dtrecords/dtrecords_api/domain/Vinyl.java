package com.dtrecords.dtrecords_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vinyl {
    @Id
    @SequenceGenerator(
            name = "vinyl_sequence",
            sequenceName = "vinyl_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vinyl_sequence"
    )
    private Long id;
    private String vinylName;

    @ManyToOne
    private Artist artist;
    private String thumbnail1;
    private String thumbnail2;
    private Long quantity;
    private Double price;
    @ManyToMany
    private Collection<Genre> genres = new ArrayList<>();
    @ManyToOne
    private Nation nation;
    private Long discount;
    private Double realPrice;
}
