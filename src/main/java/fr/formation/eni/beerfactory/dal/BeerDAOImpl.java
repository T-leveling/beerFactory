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

import java.sql.Date;
import java.util.List;

@Repository
public class BeerDAOImpl implements BeerDAO {

    @Autowired
    private BreweryDAO breweryDAO;

    private final String INSERT_BEER = "INSERT INTO BEER (name, beer_type, description, alcool_degree, note, id_brewery) VALUES (:name, :beer_type, :description, :alcool_degree, :note, :id_brewery)";

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    RowMapper<Beer> beerRowMapper = (rs, i)-> {
             Beer b = new Beer(rs.getInt("id_beer"),
                    rs.getString("name"),
                            rs.getString("beer_type"),
                            rs.getString("description"),
                            rs.getInt("alcool_degree"),
                            rs.getInt("note"));
             b.setBrewery(breweryDAO.findById(rs.getInt("id_brewery")));
             return b;
};


    @Override
    public void addBeer(Beer beer) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", beer.getName());
        namedParameters.addValue("beer_type", beer.getBeerType());
        namedParameters.addValue("description", beer.getDescription());
        namedParameters.addValue("alcool_degree", beer.getAlcoolDegree());
        namedParameters.addValue("note", beer.getNote());
        namedParameters.addValue("id_brewery",beer.getBrewery().getIdBrewery());
        jdbcTemplate.update(INSERT_BEER, namedParameters, keyHolder);
        if (keyHolder.getKey() != null) {
            beer.setBeerId(keyHolder.getKey().intValue());
        }
    //TODO a supprimer
        System.out.println("Beer creation : " + beer);
    }


    @Override
    public List<Beer> getAll() {
        String sql = "SELECT * FROM BEER";
        return jdbcTemplate.query(sql, beerRowMapper);

    }
}
