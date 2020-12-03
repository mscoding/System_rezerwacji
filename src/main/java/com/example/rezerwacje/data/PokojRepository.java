package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.hotel.Pokoj;
import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PokojRepository {
    Set<Pokoj> znajdzPokoje(Uzytkownik kierownik, Hotel hotel);

    Map<Hotel, List<Pokoj>> znajdzOferty(String adres, Date poczatek, Date koniec);

    void dodajPokoj(Pokoj pokoj, Hotel hotel);

    void usunPokoj(Pokoj pokoj);

    void modyfikujPokoj(Pokoj pokoj);
}
