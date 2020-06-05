package pl.wwsi.kamilgotuje.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Przepis {

    public UUID ID;
    public String Tresc;

    public Przepis(
            @JsonProperty("id") UUID id,
            @JsonProperty("tresc") String tresc
    ){
        this.ID = id;
        this.Tresc = tresc;
    }


}
