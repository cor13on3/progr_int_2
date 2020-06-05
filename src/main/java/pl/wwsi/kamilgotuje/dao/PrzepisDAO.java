package pl.wwsi.kamilgotuje.dao;

import org.springframework.stereotype.Repository;
import pl.wwsi.kamilgotuje.model.Przepis;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("dao")
public class PrzepisDAO implements IPrzepisDAO {

    private static List<Przepis> DB = new ArrayList<>();

    @Override
    public boolean DodajPrzepis(UUID id, Przepis przepis) {
        DB.add(new Przepis(id, przepis.Tresc));
        return true;
    }

    @Override
    public List<Przepis> dajPrzepisy() {
        return DB;
    }

    @Override
    public Przepis dajPrzepis(UUID id) {
        return new Przepis(UUID.randomUUID(),"dopisz kod do pobierania przepisu po id..");
    }

    @Override
    public void dodajKomentarz(UUID idprzepisu, String autor, String tresc) {
        // dodawanie komentarza do przepisu o podanym id
    }
}
