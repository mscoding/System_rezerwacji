package com.example.rezerwacje.web;

import com.example.rezerwacje.data.ObjectHotelRepository;
import com.example.rezerwacje.data.ObjectPokojRepository;
import com.example.rezerwacje.data.ObjectRezerwacjaRepository;
import com.example.rezerwacje.data.ObjectUzytkownikRepository;
import com.example.rezerwacje.hotel.Hotel;
import com.example.rezerwacje.hotel.Pokoj;
import com.example.rezerwacje.rezerwacja.Rezerwacja;
import com.example.rezerwacje.uzytkownik.Uzytkownik;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/kierownik")
public class KierownikKontroler {
    private ObjectUzytkownikRepository uzytkownikRepository = ObjectUzytkownikRepository.getInstance();
    private ObjectHotelRepository hotelRepository = ObjectHotelRepository.getInstance();
    private ObjectPokojRepository pokojRepository = ObjectPokojRepository.getInstance();
    private ObjectRezerwacjaRepository rezerwacjaRepository = ObjectRezerwacjaRepository.getInstance();

//    @Autowired
//    public KierownikKontroler(ObjectUzytkownikRepository jdbcUzytkownikRepository, ObjectHotelRepository objectHotelRepository, ObjectPokojRepository jdbcPokojRepository, ObjectRezerwacjaRepository jdbcRezerwacjaRepository) {
//        this.jdbcUzytkownikRepository = jdbcUzytkownikRepository;
//        this.objectHotelRepository = objectHotelRepository;
//        this.jdbcPokojRepository = jdbcPokojRepository;
//        this.jdbcRezerwacjaRepository = jdbcRezerwacjaRepository;
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Hotel> ekranGlownyHotele(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else{
            username = principal.toString();
        }

        Uzytkownik kierownik = uzytkownikRepository.znajdzUzytkownika(username);

        return hotelRepository.znajdzHotele(kierownik);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Uzytkownik> ekranGlownyPracownicy(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else{
            username = principal.toString();
        }

        Uzytkownik kierownik = uzytkownikRepository.znajdzUzytkownika(username);

        return uzytkownikRepository.znajdzPracownikow(kierownik.getId());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String ekranGlownyWybor(){
        String string=null;
        // todo logika wyboru miedzy wyborem hotelu, dodaniem hotelu, dodaniem pracownika - zwraca odpowiedni widok
        return string;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotele")
    public List<Rezerwacja> listaRezerwacji(Hotel hotel){
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username;
//        if(principal instanceof UserDetails){
//            username = ((UserDetails)principal).getUsername();
//        }else{
//            username = principal.toString();
//        }
//
//        Uzytkownik kierownik = uzytkownikRepository.znajdzUzytkownika(username);

        return rezerwacjaRepository.znajdzRezerwacje(hotel);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotele")
    public Set<Pokoj> listaPokoi(Hotel hotel){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else{
            username = principal.toString();
        }

        Uzytkownik kierownik = uzytkownikRepository.znajdzUzytkownika(username);

        //todo logika wyboru hotelu
        return pokojRepository.znajdzPokoje(kierownik,hotel);
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
