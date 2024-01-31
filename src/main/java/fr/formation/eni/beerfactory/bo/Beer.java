package fr.formation.eni.beerfactory.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class Beer implements Serializable {

    private Integer beerId;
    private String name;
    private String beerType;
    private String description;
    private  int alcoolDegree;
    private  int note;
    private Brewery brewery;

    public Beer() {
    }

    public Beer(Integer beerId, String name, String beerType, String description, int alcoolDegree, int note) {
        this(name, beerType, description, alcoolDegree, note);
        this.beerId = beerId;

    }

    public Beer(String name, String beerType, String description, int alcoolDegree, int note) {
        this.name = name;
        this.beerType = beerType;
        this.description = description;
        this.alcoolDegree = alcoolDegree;
        this.note = note;
    }

    public Integer getBeerId() {
        return beerId;
    }

    public void setBeerId(Integer beerId) {
        this.beerId = beerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeerType() {
        return beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAlcoolDegree() {
        return alcoolDegree;
    }

    public void setAlcoolDegree(int alcoolDegree) {
        this.alcoolDegree = alcoolDegree;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }
}
