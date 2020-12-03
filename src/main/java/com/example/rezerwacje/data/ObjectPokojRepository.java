package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.hotel.Pokoj;
import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.*;

public class ObjectPokojRepository implements PokojRepository{
    private static ObjectPokojRepository pokoj_instance = null; //todo zmienic na bean

    private final Map<Pokoj, Hotel> pokoje = new HashMap<>();

    public Set<Pokoj> znajdzPokoje(Uzytkownik kierownik, Hotel hotel){
        Set<Pokoj> pokoje1 = new HashSet<>();

        for (Pokoj pokoj : pokoje.keySet()){
            if (pokoje.get(pokoj).equals(hotel))
                pokoje1.add(pokoj);
        }

        return pokoje1;
    }

    @Override
    public Map<Hotel, List<Pokoj>> znajdzOferty(String adres, Date poczatek, Date koniec) {
        Map<Hotel, List<Pokoj>> oferty = new HashMap<>();
        for (Pokoj pokoj : pokoje.keySet()){
            Hotel hotel = pokoje.get(pokoj);
            if (hotel.getAdres().equals(adres)
                    && pokoj.getPoczatekRezerwacji().equals(poczatek)
                    && pokoj.getKoniecRezerwacji().equals(koniec)){
                if (!oferty.containsKey(hotel)) {
                    oferty.put(hotel, new ArrayList<>());
                }
                oferty.get(hotel).add(pokoj);
            }

        }

        return oferty;
    }

    public static ObjectPokojRepository getInstance() {
        if (pokoj_instance == null){
            pokoj_instance = new ObjectPokojRepository();
        }
        return pokoj_instance;
    }
}
