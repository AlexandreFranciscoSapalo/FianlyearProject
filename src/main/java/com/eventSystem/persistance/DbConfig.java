/*
 *  Alexandre Francisco Sapalo
 */

package com.eventSystem.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DbConfig {
	
  @Bean
  @Autowired
  public DriverManagerDataSource dataSource(Environment env) {
    DriverManagerDataSource ds = new DriverManagerDataSource();
   
    
    ds.setDriverClassName("com.mysql.jdbc.Driver");
    ds.setUrl(env.getProperty("db.url"));
    ds.setUsername(env.getProperty("db.user"));
    ds.setPassword(env.getProperty("db.password"));   
    return ds;
    
  }
}
