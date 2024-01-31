package fr.formation.eni.beerfactory.dal;

import fr.formation.eni.beerfactory.bo.Beer;
import fr.formation.eni.beerfactory.bo.Brewery;
import fr.formation.eni.beerfactory.dal.rowmapper.BreweryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    private final String INSERT_DATA = "INSERT INTO BREWERY (name, address, gps_coordinates, openning_date) VALUES (:name, :address, :gps_coordinates, :openning_date)";
    private final String FIND_ALL = "";


    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;


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
    public List<Beer> getAll(int idBrewery) {
return null;
      // return jdbcTemplate.query(FIND_ALL, new BreweryRowMapper(), idBrewery);
    }
}
