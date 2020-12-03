package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.hotel.Pokoj;

import java.util.List;
import java.util.Map;

public interface HotelRepository {
    List<Hotel> znajdzHotele(int id);

    Map<Hotel, List<Pokoj>> znajdzOferty();

    Hotel znajdzHotel(int id);
}
