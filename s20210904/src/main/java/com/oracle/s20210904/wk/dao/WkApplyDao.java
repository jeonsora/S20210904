package com.oracle.s20210904.wk.dao;

import java.util.List;

import com.oracle.s20210904.wk.model.Applycount;

public interface WkApplyDao {

	List<Applycount> countApply(String mbid);

}
