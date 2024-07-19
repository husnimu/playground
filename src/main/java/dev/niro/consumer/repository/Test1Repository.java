package dev.niro.consumer.repository;

import dev.niro.consumer.model.Test1;
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
public class Test1Repository {
  private final JdbcTemplate jdbcTemplateSatu;

  public Test1Repository(@Qualifier("jdbcTemplateSatu") JdbcTemplate jdbcTemplateSatu) {
    this.jdbcTemplateSatu = jdbcTemplateSatu;
  }

  public Optional<Test1> findById(Integer id) {
    String sql = "select * from test where id = ?";
    Test1 test1 = null;
    try {
      test1 = jdbcTemplateSatu.queryForObject(sql, new BeanPropertyRowMapper<>(Test1.class),
              id);
    } catch (DataAccessException ex) {
      System.out.println("data not found");
    }
    return Optional.ofNullable(test1);
  }

  public  Test1 create(Test1 test1){
    String sql = "INSERT INTO test (name) VALUES (:name);";
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("name", test1.getName());
    KeyHolder keyHolder = new GeneratedKeyHolder();

    NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplateSatu);
    namedParameterJdbcTemplate.update(sql, params, keyHolder);

    Number generatedId = keyHolder.getKey();

    assert generatedId != null;
    test1.setId(generatedId.intValue());
    return test1;
  }
}
