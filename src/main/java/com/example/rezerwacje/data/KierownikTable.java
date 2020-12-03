package com.example.rezerwacje.data;

import com.example.rezerwacje.uzytkownik.Uzytkownik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KierownikTable {
    private static KierownikTable instance = null;

    // kierownik, pracownik
    private final Map<Uzytkownik,List<Uzytkownik>> kierownicy = new HashMap<>();

    public void addKierownik(Uzytkownik kierownik){
        kierownicy.put(kierownik,new ArrayList<>());
    }

    public void addPracownik(Uzytkownik kierownik, Uzytkownik pracownik){
        kierownicy.get(kierownik).add(pracownik);
    }

    public Uzytkownik getKierownik(Uzytkownik pracownik){
        for (Uzytkownik kierownik : kierownicy.keySet())
            if (kierownicy.get(kierownik).contains(pracownik))
                return kierownik;

        return null;
    }

    public static KierownikTable getInstance() {
        if (instance == null){
            instance = new KierownikTable();
        }
        return instance;
    }
}
