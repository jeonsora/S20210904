package com.oracle.s20210904.ds.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DsAdminDaoImpl implements DsAdminDao {
	@Autowired
	SqlSession session;
}
