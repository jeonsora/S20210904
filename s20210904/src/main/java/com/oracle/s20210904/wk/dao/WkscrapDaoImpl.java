package com.oracle.s20210904.wk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.Scrap;
import com.oracle.s20210904.wk.model.WkScrap;

@Repository
public class WkscrapDaoImpl implements WkScrapDao{
	@Autowired
	private SqlSession session;

	@Override
	public List<Scrap> listScrap() {
		System.out.println("WkscrapDaoImpl listScrap()");
		List<Scrap> result = null;
		try {
			result=session.selectList("scrapSelectAll");
		} catch (Exception e) {
			System.out.println("WkscrapDaoImpl listScrap() error : "+e.getMessage());
		}
		return result;
	}

	@Override
	public List<WkScrap> scarpList(String mbid) {
		System.out.println("WkscrapDaoImpl scarpList()");
		List<WkScrap> result = null;
		try {
			result=session.selectList("WkScrapList", mbid);
		} catch (Exception e) {
			System.out.println("WkscrapDaoImpl scarpList() error : "+e.getMessage());
		}
		return result;
	}

	@Override
	public int scarpCount(String mbid) {
		System.out.println("WkscrapDaoImpl scarpCount()");
		int result = 0;
		try {
			result=session.selectOne("WkScrapCount", mbid);
		} catch (Exception e) {
			System.out.println("WkscrapDaoImpl scarpCount() error : "+e.getMessage());
		}
		return result;
	}
}
