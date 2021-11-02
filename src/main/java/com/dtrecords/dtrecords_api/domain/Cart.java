package com.dtrecords.dtrecords_api.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Vinyl vinyl;
    private Integer quantity;
}
