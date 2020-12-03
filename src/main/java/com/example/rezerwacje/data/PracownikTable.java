package com.example.rezerwacje.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracownikTable {
    private class Pola{
        int id_kierownik;
        int id_hotel;

        public Pola(int id_kierownik, int id_hotel) {
            this.id_kierownik = id_kierownik;
            this.id_hotel = id_hotel;
        }
    }
    private static PracownikTable instace = null;

    private final Map<Integer, Pola> pracownicy = new HashMap<>();

    public void addPracownik(int id_pracownik, int id_kierownik, int id_hotel){
        pracownicy.put(id_pracownik,new Pola(id_kierownik,id_hotel));
    }

    public Integer getKierownikId(int id_pracownik){
        return pracownicy.get(id_pracownik).id_kierownik;
    }

    public Integer getHotelId(int id_pracownik){
        return pracownicy.get(id_pracownik).id_hotel;
    }

    public static PracownikTable getInstace() {
        if (instace == null){
            instace = new PracownikTable();
        }
        return instace;
    }
}
