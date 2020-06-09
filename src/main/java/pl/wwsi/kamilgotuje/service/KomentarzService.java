package pl.wwsi.kamilgotuje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.wwsi.kamilgotuje.dao.IKomentarzDAO;
import pl.wwsi.kamilgotuje.model.Komentarz;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Qualifier("komentarzserv")
@Service
public class KomentarzService {

    private final IKomentarzDAO komentarzDAO;

    @Autowired
    public KomentarzService(@Qualifier("komentarzdao") IKomentarzDAO komentarzDAO) {
        this.komentarzDAO = komentarzDAO;
    }

    public void dodajKomentarz(Komentarz komentarz) {
        if(komentarzDAO.count() < 5) {
            komentarzDAO.save(komentarz);
        }
    }

    public List<Komentarz> dajKomentarze(UUID idprzepisu){
        if(komentarzDAO.count() > 0) {
            var lista = (List<Komentarz>) komentarzDAO.findAll();
            var res = new ArrayList<Komentarz>();
            for (Komentarz kom:lista) {
                if(kom.getIDPrzepisu().equals(idprzepisu))
                    res.add(kom);
            }
            return res;
        }
        return new ArrayList<Komentarz>();
    }
}
