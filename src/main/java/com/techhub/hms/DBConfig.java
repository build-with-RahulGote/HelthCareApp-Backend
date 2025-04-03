package com.techhub.hms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DBConfig {
    @Bean(name = "jdbctemplate")
    JdbcTemplate jdbctemplate(javax.sql.DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}

}
