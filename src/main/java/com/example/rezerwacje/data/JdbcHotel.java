package com.example.rezerwacje.data;

import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.hotel.Pokoj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class JdbcHotel {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcHotel(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //TODO
    public Map<Hotel, List<Pokoj>> znajdzOferty(){
        return null;
    }

    public List<Hotel> znajdzHotele(long id){
        return null;
    }
}
