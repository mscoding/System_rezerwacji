package com.example.rezerwacje.web;

import com.example.rezerwacje.data.JdbcRezerwacja;
import com.example.rezerwacje.data.JdbcUzytkownicy;
import com.example.rezerwacje.rezerwacja.Rezerwacja;
import com.example.rezerwacje.uzytkownik.Pracownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/pracownik")
public class PracownikKontroler {
    private JdbcRezerwacja jdbcRezerwacja;
    private JdbcUzytkownicy jdbcUzytkownicy;

    @Autowired
    public PracownikKontroler(JdbcRezerwacja jdbcRezerwacja, JdbcUzytkownicy jdbcUzytkownicy) {
        this.jdbcRezerwacja = jdbcRezerwacja;
        this.jdbcUzytkownicy = jdbcUzytkownicy;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Rezerwacja> oknoGlowne(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else{
            username = principal.toString();
        }

        Pracownik pracownik = (Pracownik) jdbcUzytkownicy.znajdzUzytkownika(username);

        return jdbcRezerwacja.znajdzRezerwacje(pracownik.getHotel());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String wybierzRezerwacje(){
        // magia z przekierowaniem wyboru pracownika
        return "redirect:pracownik/rezerwacja";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rezerwacja")
    public String wybranaRezerwacja(){
        return "rezerwacja";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rezerwacja")
    public String oplacRezerwacje(Rezerwacja rezerwacja){
        jdbcRezerwacja.usunRezerwacje(rezerwacja);
        platnosc(rezerwacja);

        return "redirect:/pracownik";
    }

    private String platnosc(Rezerwacja rezerwacja){
        return rezerwacja.toString(); //TODO
    }
}
