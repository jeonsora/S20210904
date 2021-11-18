package com.oracle.s20210904.comm.configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	private final DataSource dataSource;
	private final EntityManager em;
	public SpringConfig(DataSource dataSource, EntityManager em) {
		super();
		this.dataSource = dataSource;
		this.em = em;
	}
	
	
	
	
}
