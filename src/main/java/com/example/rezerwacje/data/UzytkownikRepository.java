package com.example.rezerwacje.data;

import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.List;

public interface UzytkownikRepository{
    Uzytkownik znajdzUzytkownika(String nazwa);

    List<Uzytkownik> znajdzPracownikow(Uzytkownik id);

    void addUzytkownik(Uzytkownik uzytkownik);

    void addPracownik(Uzytkownik pracownik, Uzytkownik kierownik);

    void usunUzytkownika(Uzytkownik uzytkownik);

    void usunPracownika(Uzytkownik pracownik, Uzytkownik kierownik);

    void modyfikujUzytkownik(Uzytkownik uzytkownik);

    void modyfikujPracownik(Uzytkownik pracownik, Uzytkownik kierownik);
}
