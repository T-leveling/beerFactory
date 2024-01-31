package fr.formation.eni.beerfactory.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beer {

    private Integer beerId;
    private String name;
    private String beerType;
    private String description;
    private  int alcoolDegree;
    private  int note;
    private Brewery brewery;

    public Beer(String name, String beerType, String description, int alcoolDegree, int note, Brewery brewery) {
        this.name = name;
        this.beerType = beerType;
        this.description = description;
        this.alcoolDegree = alcoolDegree;
        this.note = note;
        this.brewery = brewery;
    }
}
