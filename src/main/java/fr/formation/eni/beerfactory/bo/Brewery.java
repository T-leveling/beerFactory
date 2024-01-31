package fr.formation.eni.beerfactory.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brewery {
    private Integer idBrewery;
    private String name;
    private String address;
    private String gpsCoordinates;
    private LocalDate openningDate;

    public Brewery(String name, String address, String gpsCoordinates, LocalDate openningDate) {
        this.name = name;
        this.address = address;
        this.gpsCoordinates = gpsCoordinates;
        this.openningDate = openningDate;
    }
}
