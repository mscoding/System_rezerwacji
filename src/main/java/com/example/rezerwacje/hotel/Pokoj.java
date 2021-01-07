package com.example.rezerwacje.hotel;

import java.util.Date;

public class Pokoj {
    private int id;
    private int nr;
    private int cena;
    private int ocena;
    private int liczbaOsob;

    public Pokoj(int nr, int cena, int ocena, int liczbaOsob) {
        this.nr = nr;
        this.cena = cena;
        this.ocena = ocena;
        this.liczbaOsob = liczbaOsob;
    }

    public Pokoj(int id, int nr, int cena, int ocena, int liczbaOsob) {
        this.id = id;
        this.nr = nr;
        this.cena = cena;
        this.ocena = ocena;
        this.liczbaOsob = liczbaOsob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
