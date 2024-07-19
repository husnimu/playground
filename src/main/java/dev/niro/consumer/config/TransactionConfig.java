//package dev.niro.consumer.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class TransactionConfig {
//
//  @Bean(name = "transactionManager1")
//  public PlatformTransactionManager transactionManager1(@Qualifier("db1") DataSource dataSource) {
//    return new DataSourceTransactionManager(dataSource);
//  }
//
//  @Bean(name = "transactionManager2")
//  public PlatformTransactionManager transactionManager2(@Qualifier("db2") DataSource dataSource) {
//    return new DataSourceTransactionManager(dataSource);
//  }
//}
