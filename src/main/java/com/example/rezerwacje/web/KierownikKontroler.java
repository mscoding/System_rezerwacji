package com.example.rezerwacje.web;

import com.example.rezerwacje.data.JdbcHotel;
import com.example.rezerwacje.data.JdbcPokoj;
import com.example.rezerwacje.data.JdbcRezerwacja;
import com.example.rezerwacje.data.JdbcUzytkownicy;
import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.hotel.Pokoj;
import com.example.rezerwacje.rezerwacja.Rezerwacja;
import com.example.rezerwacje.uzytkownik.Kierownik;
import com.example.rezerwacje.uzytkownik.Pracownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/kierownik")
public class KierownikKontroler {
    private JdbcUzytkownicy jdbcUzytkownicy;
    private JdbcHotel jdbcHotel;
    private JdbcPokoj jdbcPokoj;
    private JdbcRezerwacja jdbcRezerwacja;

    @Autowired
    public KierownikKontroler(JdbcUzytkownicy jdbcUzytkownicy, JdbcHotel jdbcHotel, JdbcPokoj jdbcPokoj, JdbcRezerwacja jdbcRezerwacja) {
        this.jdbcUzytkownicy = jdbcUzytkownicy;
        this.jdbcHotel = jdbcHotel;
        this.jdbcPokoj = jdbcPokoj;
        this.jdbcRezerwacja = jdbcRezerwacja;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Hotel> ekranGlownyHotele(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else{
            username = principal.toString();
        }

        Kierownik kierownik = (Kierownik) jdbcUzytkownicy.znajdzUzytkownika(username);

        return jdbcHotel.znajdzHotele(kierownik.getId());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Pracownik> ekranGlownyPracownicy(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else{
            username = principal.toString();
        }

        Kierownik kierownik = (Kierownik) jdbcUzytkownicy.znajdzUzytkownika(username);

        return jdbcUzytkownicy.znajdzPracownikow(kierownik.getId());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String ekranGlownyWybor(){
        String string=null;
        // todo logika wyboru miedzy wyborem hotelu, dodaniem hotelu, dodaniem pracownika - zwraca odpowiedni widok
        return string;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotele")
    public List<Rezerwacja> listaRezerwacji(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else{
            username = principal.toString();
        }

        Kierownik kierownik = (Kierownik) jdbcUzytkownicy.znajdzUzytkownika(username);

        //todo logika wyboru hotelu
        return jdbcRezerwacja.znajdzRezerwacje(kierownik.wybierzHotel(1));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotele")
    public List<Pokoj> listaPokoi(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else{
            username = principal.toString();
        }

        Kierownik kierownik = (Kierownik) jdbcUzytkownicy.znajdzUzytkownika(username);

        //todo logika wyboru hotelu
        return jdbcPokoj.znajdzPokoje(kierownik);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hotel")
    public String wyborZHotele(){
        String string=null;
        //todo logika wyboru między: wybór rezerwacji, dodaj pokój
        return string;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotel/submit")
    public String hotelForm(Model model){
      //  model.addAttribute(new HotelForm());
        return "hotelForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hotel/submit")
    public String przetworzHotelForm(/*@Valid HotelForm hotelForm, BindingResult errors */){
//        if (errors.hasErrors()) {
//            return "hotelForm";
//        }
//        Hotel hotel = hotelForm.toHotel();
//        jdbcHotel.dodajHotel(hotel);

        return "redirect:/kierownik";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pokoj/submit")
    public String pokojForm(Model model){
        //  model.addAttribute(new HotelForm());
        return "pokojForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pokoj/submit")
    public String przetworzPokojForm(/*@Valid PokojForm pokojForm, BindingResult errors */){
//        if (errors.hasErrors()) {
//            return "pokojForm";
//        }
//        Pokoj pokoj = pokojForm.toPokoj();
//        jdbcPokoj.dodajPokoj(pokoj);

        return "redirect:/kierownik";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pracownik/submit")
    public String pracownikForm(Model model){
        //  model.addAttribute(new HotelForm());
        return "pracownikForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pracownik/submit")
    public String przetworzPracownikForm(/*@Valid PracownikForm pracownikForm, BindingResult errors */){
//        if (errors.hasErrors()) {
//            return "pracownikForm";
//        }
//        Pracownik pracownik = pracownikForm.toPracownik();
//        jdbcUzytkownik.dodajUzytkownika(pracownik);

        return "redirect:/kierownik";
    }
}
