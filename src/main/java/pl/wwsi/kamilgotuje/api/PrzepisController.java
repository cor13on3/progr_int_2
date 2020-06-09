package pl.wwsi.kamilgotuje.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wwsi.kamilgotuje.model.Komentarz;
import pl.wwsi.kamilgotuje.model.Przepis;
import pl.wwsi.kamilgotuje.service.KomentarzService;
import pl.wwsi.kamilgotuje.service.PrzepisService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.UUID;

@Controller
public class PrzepisController {

    private final PrzepisService przepisService;
    private final KomentarzService komentarzService;

    @Autowired
    public PrzepisController(@Qualifier("przepisserv") PrzepisService przepisService, @Qualifier("komentarzserv") KomentarzService komentarzService) {
        this.przepisService = przepisService;
        this.komentarzService = komentarzService;
    }

    @RequestMapping("/")
    public String root(Model model, Principal user) {
        if(user == null){
            model.addAttribute("notlogged",true);
        }
        return "index";
    }

    @RequestMapping(value = "/przepisy", method = RequestMethod.GET)
    public String DajPrzepisy(Model model){
        var lista =  przepisService.dajPrzepisy();
        model.addAttribute("lista",lista);
        return "przepisy";
    }

    @RequestMapping(value = "/nowyprzepis", method = RequestMethod.GET)
    public String NowyPrzepis(Model model){
        Przepis przepis = new Przepis();
        model.addAttribute("przepis", przepis);
        return "nowyprzepis";
    }

    @RequestMapping(value = "/dodajprzepis", method = RequestMethod.POST)
    public String DodajPrzepis(@ModelAttribute("przepis") Przepis przepis ){
        przepisService.dodajPrzepis(przepis);
        return "redirect:/przepisy";
    }

    @RequestMapping(value = "/dajprzepis/{id}", method = RequestMethod.GET)
    public ModelAndView DajPrzepis(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("przepis");
        var przepis = przepisService.dajPrzepis(UUID.fromString(id));
        mav.addObject("przepis", przepis);
        var komentarze = komentarzService.dajKomentarze(UUID.fromString(id));
        mav.addObject("komentarze", komentarze);
        return mav;
    }

    @RequestMapping(value = "/nowykomentarz/{idprzepisu}", method = RequestMethod.GET)
    public String NowyKomentarz(@PathVariable("idprzepisu") String idprzepisu, Model model){
        Komentarz komentarz = new Komentarz();
        komentarz.setIDPrzepisu(UUID.fromString(idprzepisu));
        model.addAttribute("komentarz", komentarz);
        return "nowykomentarz";
    }

    @RequestMapping(value = "/dodajkomentarz", method = RequestMethod.POST)
    public String DodajKomentarz(@ModelAttribute("komentarz") Komentarz komentarz){
        komentarzService.dodajKomentarz(komentarz);
        return "redirect:/dajprzepis/"+komentarz.getIDPrzepisu().toString();
    }
}
