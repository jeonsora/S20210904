package com.oracle.s20210904.dj.domain;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DjAnnoDaoImpl implements DjAnnoDao {

	@Autowired
	private SqlSession session;
	
	
}
