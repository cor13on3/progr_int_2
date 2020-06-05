package pl.wwsi.kamilgotuje.dao;

import pl.wwsi.kamilgotuje.model.Przepis;

import java.util.List;
import java.util.UUID;

public interface IPrzepisDAO {
    boolean DodajPrzepis(UUID id, Przepis przepis);
    default  boolean DodajPrzepis(Przepis przepis){
        UUID id = UUID.randomUUID();
        return  DodajPrzepis(id, przepis);
    }

    List<Przepis> dajPrzepisy();
    Przepis dajPrzepis(UUID id);
    void dodajKomentarz(UUID idprzepisu, String autor, String tresc);
}
