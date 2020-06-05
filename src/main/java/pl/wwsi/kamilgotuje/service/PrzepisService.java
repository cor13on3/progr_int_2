package pl.wwsi.kamilgotuje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.wwsi.kamilgotuje.dao.IPrzepisDAO;
import pl.wwsi.kamilgotuje.model.Przepis;

import java.util.List;
import java.util.UUID;

@Service
public class PrzepisService {

    private final IPrzepisDAO przepisDAO;

    @Autowired
    public PrzepisService(@Qualifier("dao") IPrzepisDAO przepisDAO) {
        this.przepisDAO = przepisDAO;
    }

    public boolean dodajPrzepis(Przepis przepis){
        return przepisDAO.DodajPrzepis(przepis);
    }

    public List<Przepis> dajPrzepisy(){
        return  przepisDAO.dajPrzepisy();
    }

    public Przepis dajPrzepis(UUID id){
        return  przepisDAO.dajPrzepis(id);
    }

    public void dodajKomentarz(UUID idprzepisu, String autor, String tresc) {
        przepisDAO.dodajKomentarz(idprzepisu, autor, tresc);
    }
}
