package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.List;

public interface UzytkownikRepository{
    Uzytkownik znajdzUzytkownika(String nazwa);

    List<Uzytkownik> znajdzPracownikow(long id);

    void addUzytkownik(Uzytkownik uzytkownik);

    void addPracownik(Uzytkownik pracownik, Uzytkownik kierownik, Hotel hotel);
}
