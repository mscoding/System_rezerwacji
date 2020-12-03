package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Pokoj;
import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.List;

public interface PokojRepository {
    List<Pokoj> znajdzPokoje(Uzytkownik uzytkownik);
}
