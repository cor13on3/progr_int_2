package pl.wwsi.kamilgotuje.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wwsi.kamilgotuje.model.Przepis;
import pl.wwsi.kamilgotuje.model.Uzytkownik;

import java.util.UUID;

@Qualifier("uzytkownikdao")
@Repository
public interface IUzytkownikDAO extends CrudRepository<Uzytkownik, UUID> {
    Uzytkownik findByEmail(String Email);
}
