package fr.formation.eni.beerfactory.bll;

import fr.formation.eni.beerfactory.bo.Brewery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
class BreweryServiceImplTest {

@Autowired
BreweryService service;
    @Test
    @Transactional
    void contextLoads() {
        Brewery brewery = new Brewery("le chaudron", "rue de la soif", "LAT 325870; LONG 2548285", LocalDate.now().minusYears(5));
        service.addBrewery(brewery);


    }
}