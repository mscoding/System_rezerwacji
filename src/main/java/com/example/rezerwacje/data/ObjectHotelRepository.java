package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.hotel.Pokoj;
import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.*;

public class ObjectHotelRepository implements HotelRepository{
    private static ObjectHotelRepository hotel_instance = null; //todo zmienic na bean

    // hotel, kierownik
    private final Map<Hotel, Uzytkownik> hotele = new HashMap<>();

    public List<Hotel> znajdzHotele(Uzytkownik uzytkownik){
        List<Hotel> hotelList = new ArrayList<>();
        for (Hotel hotel : hotele.keySet()){
            if (hotele.get(hotel).equals(uzytkownik)){
                hotelList.add(hotel);
            }
        }

        return hotelList;
    }

    @Override
    public Hotel znajdzHotelPracownika(Uzytkownik pracownik) {
        for (Hotel hotel : hotele.keySet()){
            if (hotele.get(hotel).equals(KierownikTable.getInstance().getKierownik(pracownik)))
                return hotel;
        }
        return null;
    }

    public static ObjectHotelRepository getInstance() {
        if(hotel_instance==null){
            hotel_instance = new ObjectHotelRepository();
        }
        return hotel_instance;
    }
}
