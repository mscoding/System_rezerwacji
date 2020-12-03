package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.hotel.Pokoj;
import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface HotelRepository {
    List<Hotel> znajdzHotele(Uzytkownik uzytkownik);

    Hotel znajdzHotelPracownika(Uzytkownik pracownik);
}
