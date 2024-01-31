package fr.formation.eni.beerfactory.bll;

import fr.formation.eni.beerfactory.bo.Beer;
import fr.formation.eni.beerfactory.bo.Brewery;

import java.util.List;

public interface BreweryService {

    void addBrewery(Brewery brewery) throws BreweryServiceException;

    List<Beer> getAllBeers();
}
