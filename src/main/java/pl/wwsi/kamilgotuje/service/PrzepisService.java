package pl.wwsi.kamilgotuje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.wwsi.kamilgotuje.dao.IPrzepisDAO;
import pl.wwsi.kamilgotuje.model.Przepis;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Qualifier("przepisserv")
@Service
public class PrzepisService {

    private final IPrzepisDAO przepisDAO;

    @Autowired
    public PrzepisService(@Qualifier("przepisdao") IPrzepisDAO przepisDAO) {
        this.przepisDAO = przepisDAO;
        if(przepisDAO.count() == 0) {
            var res = new ArrayList<Przepis>();
            res.add(new Przepis("Zupa z kraba","*Tutaj przepis na zupę z kraba*", "Hom Lui", 5, "Zupy"));
            res.add(new Przepis("Wieprzowina po chińsku", "*Tutaj przepis na wieprzowinę po chińsku*", "Lan hon", 4, "Dania główne"));
            res.add(new Przepis("Pinacolada", "*Tutaj przepis na pinacoladę*", "Edward", 3, "Drinki"));
            przepisDAO.saveAll(res);
        }
    }

    public void dodajPrzepis(Przepis przepis){
        przepisDAO.save(przepis);
    }

    public List<Przepis> dajPrzepisy(){
        return (List<Przepis>) przepisDAO.findAll();
    }

    public Przepis dajPrzepis(UUID id){
        return  przepisDAO.findById(id).get();
    }
}
