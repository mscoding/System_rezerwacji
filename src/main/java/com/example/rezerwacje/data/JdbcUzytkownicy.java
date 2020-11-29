package com.example.rezerwacje.data;

import com.example.rezerwacje.uzytkownik.Pracownik;
import com.example.rezerwacje.uzytkownik.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcUzytkownicy {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcUzytkownicy(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Uzytkownik znajdzUzytkownika(String nazwa){
        return null;
    }

    public List<Pracownik> znajdzPracownikow(long id){
        return null;
    }
}
