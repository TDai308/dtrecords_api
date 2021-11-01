package com.dtrecords.dtrecords_api.domain;

public class Cart {
    private Vinyl vinyl;
    private Integer quantity;

    public Cart() {
    }

    public Cart(Vinyl vinyl, Integer quantity) {
        this.vinyl = vinyl;
        this.quantity = quantity;
    }

    public Vinyl getVinyl() {
        return vinyl;
    }

    public void setVinyl(Vinyl vinyl) {
        this.vinyl = vinyl;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
