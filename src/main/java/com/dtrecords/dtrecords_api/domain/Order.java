package com.dtrecords.dtrecords_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    @ManyToOne
    private Vinyl vinyl;
    private Integer quantity;
    private Float price;
    private String delivery;
    private String orderCode;
    private String dateTime;
}
