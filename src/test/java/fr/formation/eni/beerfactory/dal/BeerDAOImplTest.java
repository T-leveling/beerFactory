package fr.formation.eni.beerfactory.dal;

import fr.formation.eni.beerfactory.bo.Beer;
import fr.formation.eni.beerfactory.bo.Brewery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BeerDAOImplTest {
    @Autowired
BeerDAO beerDAO;
    @Test
    void addBeer() {
        Brewery brewery = new Brewery("le chaudron", "rue de la soif", "LAT 325870; LONG 2548285", LocalDate.now().minusYears(5));

        Beer beer1 = new Beer("Castel", "Blonde", "Bonne bière", 4, 2, brewery);

        beerDAO.addBeer(beer1);
    }
}