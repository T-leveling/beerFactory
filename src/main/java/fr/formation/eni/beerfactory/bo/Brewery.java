package fr.formation.eni.beerfactory.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brewery implements Serializable {
    private Integer idBrewery;
    private String name;
    private String address;
    private String gpsCoordinates;
    private LocalDate openningDate;
    private List<Beer> beers ;



    public Brewery(String name, String address, String gpsCoordinates, LocalDate openningDate) {
        this.name = name;
        this.address = address;
        this.gpsCoordinates = gpsCoordinates;
        this.openningDate = openningDate;
        beers = new ArrayList<>();
    }
}
