package fr.formation.eni.beerfactory.dal;

import fr.formation.eni.beerfactory.bo.Brewery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryDAOImplTest {

    @Autowired
    BreweryDAO breweryDAO;
    @Test
    @Transactional
    void addBrewery() {
        Brewery brewery = new Brewery("le chaudron", "rue de la soif", "LAT 325870; LONG 2548285", LocalDate.now().minusYears(5));
        breweryDAO.addBrewery(brewery);
    }
}