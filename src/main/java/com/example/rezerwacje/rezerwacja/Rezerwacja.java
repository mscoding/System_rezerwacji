package com.example.rezerwacje.rezerwacja;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.hotel.Pokoj;

import java.util.Date;

public class Rezerwacja {
    private long id;
    private Hotel hotel;
    private Pokoj pokoj;
    private Date[] terminRezerwacji;

    public Rezerwacja(long id, Hotel hotel, Pokoj pokoj) {
        this.id = id;
        this.hotel = hotel;
        this.pokoj = pokoj;
        terminRezerwacji = new Date[2];
    }

    public Rezerwacja(Hotel hotel, Pokoj pokoj) {
        this.hotel = hotel;
        this.pokoj = pokoj;
        terminRezerwacji = new Date[2];
    }
}
