package com.example.rezerwacje.uzytkownik;

import com.example.rezerwacje.hotel.Hotel;

import java.util.ArrayList;

public class Kierownik extends ObslugaHotelu {
    private ArrayList<Hotel> hotele;
    private ArrayList<Pracownik> pracownicy;

    public Kierownik(long id, String nazwa, String haslo, String imie, String nazwisko, String rola) {
        super(id, nazwa, haslo, imie, nazwisko, rola);
        hotele = new ArrayList<>();
        pracownicy = new ArrayList<>();
    }

    public Kierownik(String nazwa, String haslo, String imie, String nazwisko, String rola) {
        super(nazwa, haslo, imie, nazwisko, rola);
        hotele = new ArrayList<>();
        pracownicy = new ArrayList<>();
    }

    public Hotel wybierzHotel(int i){
        return hotele.get(i);
    }
}
