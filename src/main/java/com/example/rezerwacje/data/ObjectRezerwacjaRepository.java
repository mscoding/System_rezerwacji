package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.rezerwacja.Rezerwacja;
import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.*;

public class ObjectRezerwacjaRepository implements RezerwacjaRepository{
    private static ObjectRezerwacjaRepository rezerwacja_instance = null;   //todo zmienic na bean
    private final Map<Uzytkownik,List<Rezerwacja>> rezerwacje = new HashMap<>();

    public List<Rezerwacja> znajdzRezerwacje(Hotel hotel){
        List<Rezerwacja> rezerwacjeHotelu = new ArrayList<>();
        for (List<Rezerwacja> rezerwacjaList : rezerwacje.values()){
            for (Rezerwacja rezerwacja : rezerwacjaList)
                if (rezerwacja.getHotel().equals(hotel))
                    rezerwacjeHotelu.add(rezerwacja);
        }
        return rezerwacjeHotelu;
    }

    //pobierz liste rezerwacji przy zmianie danych uzytkownika
    List<Rezerwacja> znajdzRezerwacje(Uzytkownik uzytkownik){
        return rezerwacje.get(uzytkownik);
    }

    @Override
    public List<Rezerwacja> znajdzRezerwacjePracownik(Uzytkownik pracownik) {
        return znajdzRezerwacje(ObjectHotelRepository.getInstance()
                .znajdzHotelPracownika(pracownik));
    }

    public Rezerwacja usunRezerwacje(Rezerwacja rezerwacja){
        for (Uzytkownik uzytkownik : rezerwacje.keySet()){
            rezerwacje.get(uzytkownik).removeIf(rezerwacja1 -> rezerwacja1.equals(rezerwacja));
        }
        return rezerwacja;
    }

    @Override
    public void dodajRezerwacje(Rezerwacja rezerwacja, Uzytkownik uzytkownik) {
        if (!rezerwacje.containsKey(uzytkownik)){
            rezerwacje.put(uzytkownik,new ArrayList<>());
        }
        rezerwacje.get(uzytkownik).add(rezerwacja);
    }

    @Override
    public void modyfikujRezerwacje(Rezerwacja rezerwacja, Uzytkownik uzytkownik) {
        Rezerwacja rezerwacjaOld=null;
        for (Rezerwacja rezerwacja1 : rezerwacje.get(uzytkownik)){
            if (rezerwacja1.getHotel().equals(rezerwacja.getHotel())){
                rezerwacjaOld=rezerwacja1;
            }
        }
        rezerwacje.get(uzytkownik).remove(rezerwacjaOld);
        rezerwacje.get(uzytkownik).add(rezerwacja);
    }

    // usuawanie rezerwacji przy usunieciu uzytkownika
    void usunUzytkownika(Uzytkownik uzytkownik){
        rezerwacje.remove(uzytkownik);
    }

    // dodawanie rzerwacje po modyfikacji uzytkownika
    void dodajUzytkownika(Uzytkownik uzytkownik, List<Rezerwacja> rezerwacjeNew){
        rezerwacje.put(uzytkownik, rezerwacjeNew);
    }

    public static ObjectRezerwacjaRepository getInstance() {
        if (rezerwacja_instance == null){
            rezerwacja_instance = new ObjectRezerwacjaRepository();
        }
        return rezerwacja_instance;
    }
}
