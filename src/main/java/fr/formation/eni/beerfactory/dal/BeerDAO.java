package fr.formation.eni.beerfactory.dal;

import fr.formation.eni.beerfactory.bo.Beer;
import fr.formation.eni.beerfactory.bo.Brewery;

import java.util.List;

public interface BeerDAO {

    void addBeer(Beer beer);

    List<Beer> getAll();
}
