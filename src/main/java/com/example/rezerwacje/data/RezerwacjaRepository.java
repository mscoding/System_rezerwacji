package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.hotel.Pokoj;
import com.example.rezerwacje.rezerwacja.Rezerwacja;
import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.List;
import java.util.Map;

public interface RezerwacjaRepository {
    List<Rezerwacja> znajdzRezerwacje(Hotel hotel);

    List<Rezerwacja> znajdzRezerwacjePracownik(Uzytkownik uzytkownik);

    Rezerwacja usunRezerwacje(Rezerwacja rezerwacja);

    void dodajRezerwacje(Rezerwacja rezerwacja, Uzytkownik uzytkownik);

    void modyfikujRezerwacje(Rezerwacja rezerwacja, Uzytkownik uzytkownik);
}
