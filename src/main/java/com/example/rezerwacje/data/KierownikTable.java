package com.example.rezerwacje.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KierownikTable {
    private static KierownikTable instance = null;

    private final Map<Integer,List<Integer>> kierownicy = new HashMap<>();

    public void addKierownik(int id){
        kierownicy.put(id,new ArrayList<>());
    }

    public void addHotel(int id_kierownik, int id_hotel){
        kierownicy.get(id_kierownik).add(id_hotel);
    }

    public List<Integer> getHoteleId(int id_kierownik){
        return kierownicy.get(id_kierownik);
    }

    public static KierownikTable getInstance() {
        if (instance == null){
            instance = new KierownikTable();
        }
        return instance;
    }
}
