package pl.wwsi.kamilgotuje.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wwsi.kamilgotuje.model.Uzytkownik;
import pl.wwsi.kamilgotuje.service.UzytkownikService;

import java.util.UUID;

@Controller
public class LoginController {
    UzytkownikService userService;

    @Autowired
    public LoginController(UzytkownikService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/loginerror")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "/login";
    }

    @GetMapping("/register")
    public String signUp(Model model) {
        model.addAttribute("uzytkownik", new Uzytkownik());
        return "/register";
    }

    @PostMapping("/register")
    public String signUp(@ModelAttribute("uzytkownik") Uzytkownik uzytkownik) {
        if (userService.findByEmail(uzytkownik.getEmail()) == null) {
            uzytkownik.setHaslo(passwordEncoder().encode(uzytkownik.getHaslo()));
            userService.saveUser(uzytkownik);
            return "index";
        } else
            return "/register";
    }

    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
