package com.example.rezerwacje.web;

import com.example.rezerwacje.data.JdbcHotel;
import com.example.rezerwacje.data.JdbcRezerwacja;
import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.rezerwacja.Oferta;
import com.example.rezerwacje.hotel.Pokoj;
import com.example.rezerwacje.rezerwacja.Rezerwacja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/oferty")
public class KlientKontroler {
    private JdbcHotel jdbcHotel;
    private JdbcRezerwacja jdbcRezerwacja;

    @Autowired
    public KlientKontroler(JdbcHotel jdbcHotel, JdbcRezerwacja jdbcRezerwacja) {   //todo
        this.jdbcHotel = jdbcHotel;
        this.jdbcRezerwacja = jdbcRezerwacja;
    }

    //https://stackoverflow.com/questions/23144358/how-to-loop-through-map-in-thymeleaf
    @RequestMapping(method = RequestMethod.GET)
    public Map<Hotel,List<Pokoj>> pokazOferty(){
        return jdbcHotel.znajdzOferty();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String wybierzZOfert(RedirectAttributes redirectAttributes,
                              Oferta oferta){
        redirectAttributes.addAttribute("nazwaHotelu",oferta.getHotel().getNazwa());
        redirectAttributes.addFlashAttribute("oferta",oferta);
        return "redirect:/oferty/{nazwaHotelu}";
    }

    //https://www.baeldung.com/spring-web-flash-attributes
    @RequestMapping(method = RequestMethod.GET, value = "/oferty/{nazwaHotelu}")
    public String pokazOferte(){
        return "oferta";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/oferty/{nazwaHotelu}")
    public String wybierzOferte(Rezerwacja rezerwacja){
        jdbcRezerwacja.dodajRezerwacje(rezerwacja);
        return "redirect:";
    }
}
