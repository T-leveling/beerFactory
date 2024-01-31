package fr.formation.eni.beerfactory.dal;

import fr.formation.eni.beerfactory.bo.Beer;
import fr.formation.eni.beerfactory.bo.Brewery;

import java.util.List;

public interface BreweryDAO {

    void addBrewery(Brewery brewery);

    List<Beer> getAll(int idBrewery);

    Brewery findById(int id);

    void setBeerToBrewery(Beer beer, Brewery brewery);
}
