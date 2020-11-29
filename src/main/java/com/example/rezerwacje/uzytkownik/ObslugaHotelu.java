package com.example.rezerwacje.uzytkownik;

public abstract class ObslugaHotelu extends Uzytkownik {
    public ObslugaHotelu(long id, String nazwa, String haslo, String imie, String nazwisko, String rola) {
        super(id, nazwa, haslo, imie, nazwisko, rola);
    }

    public ObslugaHotelu(String nazwa, String haslo, String imie, String nazwisko, String rola) {
        super(nazwa, haslo, imie, nazwisko, rola);
    }
}
