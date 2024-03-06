package dev.niro.consumer.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
  @Bean
  @ConfigurationProperties("spring.datasource.db1")
  public DataSourceProperties dbSatu() {
    return new DataSourceProperties();
  }

  @Bean
  @ConfigurationProperties("spring.datasource.db2")
  public DataSourceProperties dbDua() {
    return new DataSourceProperties();
  }


  @Bean(name = "db1")
  public DataSource dataSource1() {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setJdbcUrl(dbSatu().getUrl());
    dataSource.setUsername(dbSatu().getUsername());
    dataSource.setPassword(dbSatu().getPassword());
    dataSource.setDriverClassName(dbSatu().getDriverClassName());
//    dataSource.setAutoCommit(false);
    return dataSource;
  }

  @Bean(name = "db2")
  public DataSource dataSource2() {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setJdbcUrl(dbDua().getUrl());
    dataSource.setUsername(dbDua().getUsername());
    dataSource.setPassword(dbDua().getPassword());
    dataSource.setDriverClassName(dbDua().getDriverClassName());
    dataSource.setAutoCommit(false);
    return dataSource;
  }
}
