package fr.formation.eni.beerfactory.dal;

import fr.formation.eni.beerfactory.bo.Beer;
import fr.formation.eni.beerfactory.bo.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BreweryDAOImpl implements BreweryDAO {

    // Map fields name from database with attributs name of bean

    private final String INSERT_DATA = "INSERT INTO BREWERY (name, address, gps_coordinates, openning_date) VALUES (:name, :address, :gpsCoordinates, :openningDate)";


    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
   

    RowMapper<Brewery> breweryRowMapper = (rs, i) -> {
        Brewery b = new Brewery(rs.getInt("id_brewery"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("gps_coordinates"),
                rs.getDate("openning_date").toLocalDate());
    return b;
    };
    @Override
    public void addBrewery(Brewery brewery) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", brewery.getName());
        namedParameters.addValue("address", brewery.getAddress());
        namedParameters.addValue("gps_coordinates", brewery.getGpsCoordinates());
        namedParameters.addValue("openning_date", java.sql.Date.valueOf(brewery.getOpenningDate()));
        jdbcTemplate.update(INSERT_DATA, namedParameters, keyHolder);
        if (keyHolder.getKey() != null) {
            brewery.setIdBrewery(keyHolder.getKey().intValue());
        }
//TODO a supprimer
        System.out.println("Brewery building : " + brewery);
    }

    @Override
    public Brewery findById(int id) {
        String findById = "SELECT * FROM BREWERY WHERE id = :id_brewery";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id_brewery", id);

        return jdbcTemplate.queryForObject(findById, namedParameters, breweryRowMapper);
    }

    @Override
    public void setBeerToBrewery(Beer beer, Brewery brewery) {
        String setBeerToBrewery = "INSERT INTO BREWERY (id_brewery, id_beer) VALUES (:idBrewery, :idBeer)";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id_brewery", brewery.getIdBrewery());
        namedParameters.addValue("id_beer", beer.getBeerId());

        List<Beer> beers = brewery.getBeers();

        beers.add(beer);

        jdbcTemplate.update(setBeerToBrewery, namedParameters);
    }
}
