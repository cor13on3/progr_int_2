package pl.wwsi.kamilgotuje.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Uzytkownik {
    private UUID ID;
    private String Email;
    private String Haslo;

    public Uzytkownik() {
        this.ID = UUID.randomUUID();
    }

    @Id
    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getHaslo() {
        return Haslo;
    }

    public void setHaslo(String haslo) {
        Haslo = haslo;
    }
}
