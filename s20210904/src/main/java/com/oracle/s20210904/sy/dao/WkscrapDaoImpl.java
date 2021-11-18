package com.oracle.s20210904.sy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.Scrap;

@Repository
public class WkscrapDaoImpl implements WkScrapDao{
	@Autowired
	private SqlSession session;

	@Override
	public List<Scrap> listScrap() {
		System.out.println("WkscrapDaoImpl listScrap()");
		List<Scrap> result = null;
		try {
			result=session.selectList("scrapSelectAll2");
		} catch (Exception e) {
			System.out.println("WkscrapDaoImpl listScrap() error : "+e.getMessage());
		}
		return result;
	}
}
