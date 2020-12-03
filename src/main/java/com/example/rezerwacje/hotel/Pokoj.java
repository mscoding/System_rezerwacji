package com.example.rezerwacje.hotel;

import java.util.Date;

public class Pokoj {
    private long id;
    private int nr;
    private int cena;
    private int ocena;
    private int liczbaOsob;
    private Date poczatekRezerwacji;
    private Date koniecRezerwacji;

    public Pokoj(int nr, int cena, int ocena, int liczbaOsob) {
        this.nr = nr;
        this.cena = cena;
        this.ocena = ocena;
        this.liczbaOsob = liczbaOsob;
    }

    public Pokoj(long id, int nr, int cena, int ocena, int liczbaOsob) {
        this.id = id;
        this.nr = nr;
        this.cena = cena;
        this.ocena = ocena;
        this.liczbaOsob = liczbaOsob;
    }

    public Date getPoczatekRezerwacji() {
        return poczatekRezerwacji;
    }

    public void setPoczatekRezerwacji(Date poczatekRezerwacji) {
        this.poczatekRezerwacji = poczatekRezerwacji;
    }

    public Date getKoniecRezerwacji() {
        return koniecRezerwacji;
    }

    public void setKoniecRezerwacji(Date koniecRezerwacji) {
        this.koniecRezerwacji = koniecRezerwacji;
    }
}
