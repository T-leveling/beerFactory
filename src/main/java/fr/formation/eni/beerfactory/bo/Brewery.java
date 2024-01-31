package fr.formation.eni.beerfactory.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Brewery implements Serializable {
    private Integer idBrewery;
    private String name;
    private String address;
    private String gpsCoordinates;
    private LocalDate openningDate;
    private List<Beer> beers ;


    {
        beers= new ArrayList<>();
    }

    public Brewery(String name, String address, String gpsCoordinates, LocalDate openningDate) {
        this.name = name;
        this.address = address;
        this.gpsCoordinates = gpsCoordinates;
        this.openningDate = openningDate;
    }

    public Brewery() {
    }

    public Brewery(Integer idBrewery, String name, String address, String gpsCoordinates, LocalDate openningDate) {
        this(name, address, gpsCoordinates,openningDate);
        this.idBrewery = idBrewery;

    }

    public Integer getIdBrewery() {
        return idBrewery;
    }

    public void setIdBrewery(Integer idBrewery) {
        this.idBrewery = idBrewery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGpsCoordinates() {
        return gpsCoordinates;
    }

    public void setGpsCoordinates(String gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    public LocalDate getOpenningDate() {
        return openningDate;
    }

    public void setOpenningDate(LocalDate openningDate) {
        this.openningDate = openningDate;
    }

    public List<Beer> getBeers() {
        return beers;
    }


}
