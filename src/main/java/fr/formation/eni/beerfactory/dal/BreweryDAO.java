package fr.formation.eni.beerfactory.dal;

import fr.formation.eni.beerfactory.bo.Beer;
import fr.formation.eni.beerfactory.bo.Brewery;

import java.util.List;

public interface BreweryDAO {

    void insertBrewery(Brewery brewery);

    List<Beer> getAll();
}
