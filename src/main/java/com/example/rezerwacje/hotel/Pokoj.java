package com.example.rezerwacje.hotel;

import java.util.Date;

public class Pokoj {
    private long id;
    private int nr;
    private int cena;
    private int ocena;
    private int liczbaOsob;
    private Date[] dataRezerwacji;

    public Pokoj(int nr, int cena, int ocena, int liczbaOsob) {
        this.nr = nr;
        this.cena = cena;
        this.ocena = ocena;
        this.liczbaOsob = liczbaOsob;
        dataRezerwacji = new Date[2];
    }

    public Pokoj(long id, int nr, int cena, int ocena, int liczbaOsob) {
        this.id = id;
        this.nr = nr;
        this.cena = cena;
        this.ocena = ocena;
        this.liczbaOsob = liczbaOsob;
        dataRezerwacji = new Date[2];
    }
}
