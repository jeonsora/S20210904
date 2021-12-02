package com.oracle.s20210904.wk.dao;

import java.util.List;

import com.oracle.s20210904.comm.model.Scrap;
import com.oracle.s20210904.wk.model.WkScrap;

public interface WkScrapDao {

	List<Scrap> listScrap();

	List<WkScrap> scarpList(String mbid);

	int scarpCount(String mbid);

}
