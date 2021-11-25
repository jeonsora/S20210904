package com.oracle.s20210904.wk.dao;

import java.util.List;

import com.oracle.s20210904.wk.model.WkApply;
import com.oracle.s20210904.wk.model.WkApplyCount;

public interface WkApplyDao {

	List<WkApplyCount> countApply(String mbid);

	List<WkApply> applyList(String mbid);

}
