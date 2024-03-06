package dev.niro.consumer.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {
  @Bean
  public JdbcTemplate jdbcTemplateSatu(@Qualifier("db1") DataSource satuDb) {
    return new JdbcTemplate(satuDb);
  }

  @Bean
  public JdbcTemplate jdbcTemplateDua(@Qualifier("db2") DataSource duaDb) {
    return new JdbcTemplate(duaDb);
  }
}
