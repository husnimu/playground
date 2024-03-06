package dev.niro.consumer.repository;

import dev.niro.consumer.model.Tes2 ;
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
public class Tes2Repository {
  private JdbcTemplate jdbcTemplateSatu;

  public Tes2Repository(@Qualifier("jdbcTemplateSatu") JdbcTemplate jdbcTemplateSatu) {
    this.jdbcTemplateSatu = jdbcTemplateSatu;
  }

  public Optional<Tes2 > findById(Integer id) {
    String sql = """
              select * from tes2 where id = ?
            """;
    Tes2  tes2 = null;
    try {
      tes2 = jdbcTemplateSatu.queryForObject(sql, new BeanPropertyRowMapper<>(Tes2 .class),
              id);
    } catch (DataAccessException ex) {
      System.out.println("data not found");
    }
    return Optional.ofNullable(tes2);
  }

  public  Tes2  create(Tes2  tes2){
    String sql = """
              INSERT INTO tes2 (id_test1, name) VALUES (:idTest1, :name);
            """;
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("idTest1", tes2.getIdTest1());
    params.addValue("name", tes2.getName());
    KeyHolder keyHolder = new GeneratedKeyHolder();

    NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplateSatu);
    namedParameterJdbcTemplate.update(sql, params, keyHolder);

    Number generatedId = keyHolder.getKey();

    tes2.setId(generatedId.intValue());
    return tes2;
  }
}
