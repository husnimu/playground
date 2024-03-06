package dev.niro.consumer.repository;

import dev.niro.consumer.model.Tos;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TosRepository {
  private final JdbcTemplate jdbcTemplateSatu;

  public TosRepository(@Qualifier("jdbcTemplateSatu") JdbcTemplate jdbcTemplateSatu) {
    this.jdbcTemplateSatu = jdbcTemplateSatu;
  }

  public Optional<Tos> findById(Integer id) {
    String sql = """
              select * from tos where id = ?
            """;
    Tos tos = null;
    try {
      tos = jdbcTemplateSatu.queryForObject(sql, new BeanPropertyRowMapper<>(Tos.class),
              id);
    } catch (DataAccessException ex) {
      System.out.println("data not found");
    }
    return Optional.ofNullable(tos);
  }

  public  Tos create(Tos tos){
    String sql = """
              INSERT INTO tos (name) VALUES (:name);
            """;
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("name", tos.getName());
    KeyHolder keyHolder = new GeneratedKeyHolder();

    NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplateSatu);
    namedParameterJdbcTemplate.update(sql, params, keyHolder);

    Number generatedId = keyHolder.getKey();

    tos.setId(generatedId.intValue());
    return tos;
  }
}
