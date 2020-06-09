package pl.wwsi.kamilgotuje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wwsi.kamilgotuje.dao.IUzytkownikDAO;
import pl.wwsi.kamilgotuje.model.Uzytkownik;

import java.util.UUID;

@Service
public class UzytkownikService {

    IUzytkownikDAO userRepository;

    @Autowired
    public UzytkownikService(IUzytkownikDAO userRepository) {
        this.userRepository = userRepository;
    }

    public Uzytkownik findById(UUID id) {
        return userRepository.findById(id).get();
    }

    public Uzytkownik findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(Uzytkownik user) {
        userRepository.save(user);
    }
}
