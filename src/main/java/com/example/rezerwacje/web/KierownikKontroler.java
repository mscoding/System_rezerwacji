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

        return hotelRepository.znajdzHotele(getKierownik());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Uzytkownik> ekranGlownyPracownicy(){

        return uzytkownikRepository.znajdzPracownikow(getKierownik());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String ekranGlownyWybor(){
        String string=null;
        // todo logika wyboru miedzy wyborem hotelu, dodaniem hotelu, dodaniem pracownika - zwraca odpowiedni widok
        return string;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotele")
    public List<Rezerwacja> listaRezerwacji(Hotel hotel){

        return rezerwacjaRepository.znajdzRezerwacje(hotel);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotele")
    public Set<Pokoj> listaPokoi(Hotel hotel){

        //todo logika wyboru hotelu
        return pokojRepository.znajdzPokoje(getKierownik(),hotel);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hotel")
    public String wyborZHotele(){
        String string=null;
        //todo logika wyboru między: wybór rezerwacji, dodaj pokój
        return string;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotel/submit")
    public String hotelForm(){
        return "hotelForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hotel/submit")
    public String przetworzHotelForm(Hotel hotel){
        hotelRepository.addHotel(getKierownik(),hotel);

        return "redirect:/kierownik";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pokoj/submit")
    public String pokojForm(){
        return "pokojForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pokoj/submit")
    public String przetworzPokojForm(Pokoj pokoj, Hotel hotel){
        pokojRepository.dodajPokoj(pokoj,hotel);

        return "redirect:/kierownik";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pracownik/submit")
    public String pracownikForm(){
        return "pracownikForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pracownik/submit")
    public String przetworzPracownikForm(Uzytkownik pracownik){
        uzytkownikRepository.addPracownik(pracownik,getKierownik());

        return "redirect:/kierownik";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pracownik/usun")
    public String usunPracownika(){
        return "usunPracownika";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pracownik/usun")
    public void usunPracownikProcess(Uzytkownik pracownik){
        uzytkownikRepository.usunPracownika(pracownik,getKierownik());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pracownik/modyfikuj")
    public String modyfikujPracownik(Uzytkownik pracownik){
        return "modyfikujPracownika";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pracownik/modyfikuj")
    public void modyfikujPracownikProcess(Uzytkownik pracownik){
        uzytkownikRepository.modyfikujPracownik(pracownik,getKierownik());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotel/modyfikuj")
    public String modyfikujHotel(Hotel hotel){
        return "modyfikujHotel";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hotel/modyfikuj")
    public void modyfikujHotelProcess(Hotel hotel){
        hotelRepository.modyfikujHotel(hotel);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hotel/usun")
    public String usunHotel(Hotel hotel){
        return "uusnHotel";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hotel/usun")
    public void usunHotelProcess(Hotel hotel){
        hotelRepository.usunHotel(hotel);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pokoj/modyfikuj")
    public String modyfikujPokoj(Pokoj pokoj){
        return "modyfikujPokoj";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pokoj/modyfikuj")
    public void modyfikujPokojProcess(Pokoj pokoj){
        pokojRepository.modyfikujPokoj(pokoj);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pokoj/usun")
    public String usunPokoj(Pokoj pokoj){
        return "usunPokoj";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pokoj/usun")
    public void usunPokojProcess(Pokoj pokoj){
        pokojRepository.usunPokoj(pokoj);
    }

    private Uzytkownik getKierownik(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else{
            username = principal.toString();
        }

        return uzytkownikRepository.znajdzUzytkownika(username);
    }
}
