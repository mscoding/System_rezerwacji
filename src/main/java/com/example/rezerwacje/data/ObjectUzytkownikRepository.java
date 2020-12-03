package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectUzytkownikRepository implements UzytkownikRepository {
    private static ObjectUzytkownikRepository uzytkownik_instance;
    private static int id=0;
    private final Map<Integer,Uzytkownik> uzytkownicy = new HashMap<>();

    public Uzytkownik znajdzUzytkownika(String nazwa){
        for (Uzytkownik uzytkownik : uzytkownicy.values())
            if (uzytkownik.getNazwa().equals(nazwa))
                return uzytkownik;
        return null;
    }

    public List<Uzytkownik> znajdzPracownikow(long id){
        return null;
    }

    @Override
    public void addUzytkownik(Uzytkownik uzytkownik) {
        uzytkownik.setId(id);
        if (uzytkownik.getRola().equals("KIEROWNIK"))
            KierownikTable.getInstance().addKierownik(uzytkownik);
        uzytkownicy.put(id,uzytkownik);
        id++;
    }

    @Override
    public void addPracownik(Uzytkownik pracownik, Uzytkownik kierownik) {
        KierownikTable.getInstance().addPracownik(kierownik, pracownik);
        addUzytkownik(pracownik);
    }

    public static ObjectUzytkownikRepository getInstance() {
        if (uzytkownik_instance == null){
            uzytkownik_instance = new ObjectUzytkownikRepository();
        }
        return uzytkownik_instance;
    }
}
