package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.hotel.Pokoj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectHotelRepository implements HotelRepository{
    private static ObjectHotelRepository hotel_instance = null; //todo zmienic na bean

    private final Map<Integer,Hotel> hotele = new HashMap<>();

    public List<Hotel> znajdzHotele(int id){
        return null;
    }

    public Map<Hotel, List<Pokoj>> znajdzOferty(){
        return null;
    }

    @Override
    public Hotel znajdzHotel(int id) {
        return hotele.get(id);
    }

    public static ObjectHotelRepository getInstance() {
        if(hotel_instance==null){
            hotel_instance = new ObjectHotelRepository();
        }
        return hotel_instance;
    }
}
