package com.example.rezerwacje.hotel;

public class Hotel {
    private String nazwa;
    private String adres;
    private long id;

    public Hotel(String nazwa, String adres) {
        this.nazwa = nazwa;
        this.adres = adres;
    }

    public Hotel(String nazwa, String adres, long id) {
        this.nazwa = nazwa;
        this.adres = adres;
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }
}
