package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Pokoj;
import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.List;

public class ObjectPokojRepository implements PokojRepository{
    private static ObjectPokojRepository pokoj_instance = null; //todo zmienic na bean
    public List<Pokoj> znajdzPokoje(Uzytkownik uzytkownik){
        return null;
    }

    public static ObjectPokojRepository getInstance() {
        if (pokoj_instance == null){
            pokoj_instance = new ObjectPokojRepository();
        }
        return pokoj_instance;
    }
}
