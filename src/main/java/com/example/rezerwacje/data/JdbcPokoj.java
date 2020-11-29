package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Pokoj;
import com.example.rezerwacje.uzytkownik.Kierownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcPokoj {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcPokoj(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pokoj> znajdzPokoje(Kierownik kierownik){
        return null;
    }
}
