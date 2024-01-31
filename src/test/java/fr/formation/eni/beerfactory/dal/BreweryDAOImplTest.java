package fr.formation.eni.beerfactory.dal;

import fr.formation.eni.beerfactory.bo.Beer;
import fr.formation.eni.beerfactory.bo.Brewery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryDAOImplTest {

    @Autowired
    BreweryDAO breweryDAO;

    @Autowired
    BeerDAO beerDAO;
    @Test
    @Transactional
    void addBrewery() {
        Brewery brewery = new Brewery("le chaudron", "rue de la soif", "LAT 325870; LONG 2548285", LocalDate.now().minusYears(5));


        Beer beer1 = new Beer("Castel", "Blonde", "Bonne bière", 4, 2, brewery);
        Beer beer2 = new Beer("Kronnenburg", "Blonde", "Assez bonne bière", 5, 4, brewery);
        Beer beer3 = new Beer("IPA", "Blonde", "Très bonne bière", 6, 5, brewery);
        List<Beer> beers = new ArrayList<>();
        beers.add(beer1);
        beers.add(beer2);
        beers.add(beer3);
//        System.out.println();
        breweryDAO.addBrewery(brewery);
//        breweryDAO.getAll();
    }
}