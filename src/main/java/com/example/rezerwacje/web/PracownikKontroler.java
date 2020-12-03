package com.example.rezerwacje.web;

import com.example.rezerwacje.data.ObjectRezerwacjaRepository;
import com.example.rezerwacje.data.ObjectUzytkownikRepository;
import com.example.rezerwacje.rezerwacja.Rezerwacja;
import com.example.rezerwacje.uzytkownik.Uzytkownik;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/pracownik")
public class PracownikKontroler {
    private ObjectRezerwacjaRepository rezerwacjaRepository = ObjectRezerwacjaRepository.getInstance();
    private ObjectUzytkownikRepository uzytkownikRepository = ObjectUzytkownikRepository.getInstance();

//    @Autowired
//    public PracownikKontroler(ObjectRezerwacjaRepository jdbcRezerwacjaRepository, ObjectUzytkownikRepository jdbcUzytkownikRepository) {
//        this.jdbcRezerwacjaRepository = jdbcRezerwacjaRepository;
//        this.jdbcUzytkownikRepository = jdbcUzytkownikRepository;
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Rezerwacja> oknoGlowne(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else{
            username = principal.toString();
        }

        Uzytkownik pracownik = uzytkownikRepository.znajdzUzytkownika(username);

        return rezerwacjaRepository.znajdzRezerwacjePracownik(pracownik);
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
        rezerwacjaRepository.usunRezerwacje(rezerwacja);
        platnosc(rezerwacja);

        return "redirect:/pracownik";
    }

    private String platnosc(Rezerwacja rezerwacja){
        return rezerwacja.toString(); //TODO
    }
}
