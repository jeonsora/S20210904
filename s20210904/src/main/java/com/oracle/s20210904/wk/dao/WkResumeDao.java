package com.oracle.s20210904.wk.dao;

import java.util.List;

import com.oracle.s20210904.wk.model.WkResume;

public interface WkResumeDao {

	List<WkResume> resumeList(String mbid);

}
