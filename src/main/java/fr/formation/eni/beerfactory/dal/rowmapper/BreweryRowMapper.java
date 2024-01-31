package fr.formation.eni.beerfactory.dal.rowmapper;

import fr.formation.eni.beerfactory.bo.Beer;
import fr.formation.eni.beerfactory.bo.Brewery;
import fr.formation.eni.beerfactory.dal.BeerDAO;
import fr.formation.eni.beerfactory.dal.BreweryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BreweryRowMapper implements RowMapper<Brewery> {

    @Autowired
    //BreweryDAO beerDAO;

    @Override
    public Brewery mapRow(ResultSet rs, int rowNum) throws SQLException {
        Brewery b = new Brewery();
        b.setIdBrewery(rs.getInt("id_brewery"));
        b.setName(rs.getString("name"));
        b.setAddress(rs.getString("address"));
        b.setGpsCoordinates(rs.getString("gpsCoordinates"));
        b.setOpenningDate(rs.getDate("openningDate").toLocalDate());

      //  List<Beer> beers = beerDAO.findByBreweryId(rs.getInt("id_brewery"));
      //  b.setBeers(beers);

        return b;
    }
}

