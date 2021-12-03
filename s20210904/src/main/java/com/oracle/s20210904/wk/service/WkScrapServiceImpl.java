package com.oracle.s20210904.wk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210904.comm.model.Scrap;
import com.oracle.s20210904.wk.dao.WkScrapDao;

@Service
public class WkScrapServiceImpl implements WkScrapService{
	@Autowired
	private WkScrapDao sd;
	
	@Override
	public List<Scrap> listScrap() {
		System.out.println("ScrapServiceImpl listScrap()");
		return sd.listScrap();
	}

}
