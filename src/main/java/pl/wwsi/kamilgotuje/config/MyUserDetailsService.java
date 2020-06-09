package pl.wwsi.kamilgotuje.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.wwsi.kamilgotuje.model.Uzytkownik;
import pl.wwsi.kamilgotuje.service.UzytkownikService;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UzytkownikService uzService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Uzytkownik user = uzService.findByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException("Brak użytkownika o podanym adresie e-mail: " + s);
        }
        return new MyUserDetails(user);
    }
}