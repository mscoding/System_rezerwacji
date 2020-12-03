package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.hotel.Pokoj;
import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.*;

public class ObjectHotelRepository implements HotelRepository{
    private static ObjectHotelRepository hotel_instance = null; //todo zmienic na bean
    private static int id=0;

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

    @Override
    public void addHotel(Uzytkownik kierownik, Hotel hotel) {
        hotel.setId(id++);
        hotele.put(hotel,kierownik);
    }

    //todo ogarniecie rezerwacji
    @Override
    public void modyfikujHotel(Hotel hotel) {
        Hotel hotelOld=null;
        Uzytkownik uzytkownik=null;
        for (Hotel hotel1 : hotele.keySet()){
            if (hotel1.getId()==hotel.getId()) {
                uzytkownik = hotele.get(hotel1);
                hotelOld = hotel1;
            }
        }
        Set<Pokoj> pokoje = ObjectPokojRepository.getInstance().znajdzPokoje(uzytkownik,hotelOld);
        usunHotel(hotelOld);
        addHotel(uzytkownik,hotel);
        ObjectPokojRepository.getInstance().dodajHotel(hotel,pokoje);
    }

    //todo ogarniecie rezerwacji
    @Override
    public void usunHotel(Hotel hotel) {
        ObjectPokojRepository.getInstance().usunHotel(hotel);
        hotele.remove(hotel);
    }

    public static ObjectHotelRepository getInstance() {
        if(hotel_instance==null){
            hotel_instance = new ObjectHotelRepository();
        }
        return hotel_instance;
    }
}
