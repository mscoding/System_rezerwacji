package com.example.rezerwacje.hotel;

public class Hotel {
    private String nazwa;
    private String adres;

    private int id;

    public Hotel(String nazwa, String adres) {
        this.nazwa = nazwa;
        this.adres = adres;
    }

    public Hotel(String nazwa, String adres, int id) {
        this.nazwa = nazwa;
        this.adres = adres;
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }
}
