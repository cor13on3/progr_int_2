package pl.wwsi.kamilgotuje.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wwsi.kamilgotuje.model.Przepis;
import pl.wwsi.kamilgotuje.service.PrzepisService;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class PrzepisController {

    private final PrzepisService przepisService;

    @Autowired
    public PrzepisController(PrzepisService przepisService) {
        this.przepisService = przepisService;
    }

    @GetMapping("/")
    public String root(Model model) {
        return "index";
    }

    @GetMapping("/przepisy")
    public String DajPrzepisy(Model model){
        var lista =  przepisService.dajPrzepisy();
        model.addAttribute("lista",lista);
        return "przepisy";
    }

    @GetMapping("/nowyprzepis")
    public String NowyPrzepis(Model model){
        return "nowyprzepis";
    }

    @PostMapping("/dodajprzepis")
    public String DodajPrzepis(HttpServletRequest request, Model model){
        String tresc = request.getParameter("tresc");
        przepisService.dodajPrzepis(new Przepis(UUID.randomUUID(), tresc));
        return "przepisy";
    }

    @GetMapping("/dajprzepis/{id}")
    public String DajPrzepis(@PathVariable("id") String id, Model model){
        var przepis = przepisService.dajPrzepis(UUID.fromString(id));
        model.addAttribute("przepis", przepis);
        return "przepis";
    }

    @GetMapping("/nowykomentarz")
    public String NowyKomentarz(Model model){
        return "nowykomentarz";
    }

    @PostMapping("/dodajkomentarz")
    public String DodajKomentarz(HttpServletRequest request, Model model){
        var idprzepisu = UUID.fromString(request.getParameter("idprzepisu"));
        String autor = request.getParameter("autor");
        String tresc = request.getParameter("tresc");
        przepisService.dodajKomentarz(idprzepisu, autor, tresc);
        return "przepisy";
    }
}
