package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.rezerwacja.Rezerwacja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcRezerwacja {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcRezerwacja(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Rezerwacja dodajRezerwacje(Rezerwacja rezerwacja){
        return rezerwacja;
    }

    public List<Rezerwacja> znajdzRezerwacje(Hotel hotel){
        return null;
    }

    public Rezerwacja usunRezerwacje(Rezerwacja rezerwacja){
        return rezerwacja;
    }
}
