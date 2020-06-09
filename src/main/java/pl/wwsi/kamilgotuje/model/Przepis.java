package pl.wwsi.kamilgotuje.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Przepis {
    private UUID ID;
    private String Tytul;
    private String Tresc;
    private String Autor;
    private Integer Trudnosc;
    private String Rodzaj;

    public Przepis() {
        this.ID = UUID.randomUUID();
    }

    public Przepis(String tytul, String tresc, String autor, Integer trudnosc, String rodzaj) {
        this.ID = UUID.randomUUID();
        this.Tytul = tytul;
        this.Tresc = tresc;
        this.Autor = autor;
        this.Trudnosc = trudnosc;
        this.Rodzaj = rodzaj;
    }

    @Id
    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getTytul() {
        return Tytul;
    }

    public void setTytul(String tytul) {
        Tytul = tytul;
    }

    public String getTresc() {
        return Tresc;
    }

    public void setTresc(String tresc) {
        Tresc = tresc;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public Integer getTrudnosc() {
        return Trudnosc;
    }

    public void setTrudnosc(Integer trudnosc) {
        Trudnosc = trudnosc;
    }

    public String getRodzaj() {
        return Rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        Rodzaj = rodzaj;
    }
}
