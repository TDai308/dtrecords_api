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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String vinylName;

    @ManyToOne
    private Artist artist;
    private String img1;
    private String img2;
    private Long quantity;
    private Float price;
    @ManyToMany
    private Collection<Genre> genres = new ArrayList<>();
    @ManyToOne
    private Nation nation;
    private Boolean onSale;
    private Float salePrice;
    private Float realPrice;

    @OneToMany
    private Collection<Track> tracks = new ArrayList<>();
}
