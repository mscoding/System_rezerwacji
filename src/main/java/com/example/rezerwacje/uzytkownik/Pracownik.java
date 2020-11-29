package com.example.rezerwacje.uzytkownik;

import com.example.rezerwacje.hotel.Hotel;

public class Pracownik extends ObslugaHotelu {
    private Kierownik kierownik;
    private Hotel hotel;
    public Pracownik(long id, String nazwa, String haslo, String imie, String nazwisko, String rola, Kierownik kierownik, Hotel hotel) {
        super(id, nazwa, haslo, imie, nazwisko, rola);
        this.kierownik = kierownik;
        this.hotel = hotel;
    }

    public Pracownik(String nazwa, String haslo, String imie, String nazwisko, String rola, Kierownik kierownik, Hotel hotel) {
        super(nazwa, haslo, imie, nazwisko, rola);
        this.kierownik = kierownik;
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
