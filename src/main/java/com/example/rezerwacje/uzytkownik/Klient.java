package com.example.rezerwacje.uzytkownik;

import com.example.rezerwacje.rezerwacja.Rezerwacja;

import java.util.ArrayList;

public class Klient extends Uzytkownik {
    private ArrayList<Rezerwacja> rezerwacje;

    public Klient(long id, String nazwa, String haslo, String imie, String nazwisko, String rola) {
        super(id, nazwa, haslo, imie, nazwisko, rola);
        rezerwacje = new ArrayList<>();
    }

    public Klient(String nazwa, String haslo, String imie, String nazwisko, String rola) {
        super(nazwa, haslo, imie, nazwisko, rola);
        rezerwacje = new ArrayList<>();
    }


}
