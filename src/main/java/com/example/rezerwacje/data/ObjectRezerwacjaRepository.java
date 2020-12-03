package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.rezerwacja.Rezerwacja;
import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.ArrayList;
import java.util.List;

public class ObjectRezerwacjaRepository implements RezerwacjaRepository{
    private static ObjectRezerwacjaRepository rezerwacja_instance = null;   //todo zmienic na bean
    private List<Rezerwacja> rezerwacje = new ArrayList<>();

    public Rezerwacja dodajRezerwacje(Rezerwacja rezerwacja){
        rezerwacje.add(rezerwacja);
        return rezerwacja;
    }

    public List<Rezerwacja> znajdzRezerwacje(Hotel hotel){
        List<Rezerwacja> rezerwacjeHotelu = new ArrayList<>();
        for (Rezerwacja rezerwacja : rezerwacje){
            if (rezerwacja.getHotel().equals(hotel))
                rezerwacjeHotelu.add(rezerwacja);
        }
        return rezerwacjeHotelu;
    }

    @Override
    public List<Rezerwacja> znajdzRezerwacjePracownik(Uzytkownik pracownik) {
        return znajdzRezerwacje(ObjectHotelRepository.getInstance()
                .znajdzHotelPracownika(pracownik));
    }

    public Rezerwacja usunRezerwacje(Rezerwacja rezerwacja){
        rezerwacje.remove(rezerwacja);
        return rezerwacja;
    }

    public static ObjectRezerwacjaRepository getInstance() {
        if (rezerwacja_instance == null){
            rezerwacja_instance = new ObjectRezerwacjaRepository();
        }
        return rezerwacja_instance;
    }
}
