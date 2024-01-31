package fr.formation.eni.beerfactory.dal;

import fr.formation.eni.beerfactory.bo.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class BeerDAOImpl implements BeerDAO {

    private final String INSERT_BEER = "INSERT INTO BEER (name, beer_type, description, alcool_degree, note, id_brewery) VALUES (:name, :beer_type, :description, :alcool_degree, :note, :id_brewery)";

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void addBeer(Beer beer) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", beer.getName());
        namedParameters.addValue("beer_type", beer.getBeerType());
        namedParameters.addValue("description", beer.getDescription());
        namedParameters.addValue("alcool_degree", beer.getAlcoolDegree());
        namedParameters.addValue("note", beer.getNote());
        namedParameters.addValue("id_brewery", beer.getBrewery());
        jdbcTemplate.update(INSERT_BEER, namedParameters, keyHolder);
        if (keyHolder.getKey() != null) {
            beer.setBeerId(keyHolder.getKey().intValue());
        }
    //TODO a supprimer
        System.out.println("Beer creation : " + beer);
    }


    @Override
    public List<Beer> getAll() {
        // return jdbcTemplate.query();
        return null;
    }
}
