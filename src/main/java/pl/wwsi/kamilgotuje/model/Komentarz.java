package pl.wwsi.kamilgotuje.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Komentarz {
    private UUID ID;
    private UUID IDPrzepisu;
    private String Autor;
    private String Tresc;

    public Komentarz(){
        this.ID = UUID.randomUUID();
    }

    @Id
    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public UUID getIDPrzepisu() {
        return IDPrzepisu;
    }

    public void setIDPrzepisu(UUID IDPrzepisu) {
        this.IDPrzepisu = IDPrzepisu;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getTresc() {
        return Tresc;
    }

    public void setTresc(String tresc) {
        Tresc = tresc;
    }
}
