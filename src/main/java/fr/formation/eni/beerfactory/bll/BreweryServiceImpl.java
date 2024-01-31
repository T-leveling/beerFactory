package fr.formation.eni.beerfactory.bll;

import fr.formation.eni.beerfactory.bo.Beer;
import fr.formation.eni.beerfactory.bo.Brewery;
import fr.formation.eni.beerfactory.dal.BreweryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreweryServiceImpl implements BreweryService {

    @Autowired
    private BreweryDAO dao;

    @Override
    public void addBrewery(Brewery brewery) {
        dao.insertBrewery(brewery);
        //System.out.println("test de l'ajout dans le breweryService : " + brewery);
    }

    @Override
    public List<Beer> getAllBeers() {
        return dao.getAll();
    }
}
