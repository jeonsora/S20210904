package com.oracle.s20210904.wk.service;

import java.util.List;

import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.wk.model.WkApply;
import com.oracle.s20210904.wk.model.WkApplyCount;
import com.oracle.s20210904.wk.model.WkResume;

public interface WkMbMypageService {

	List<WkApplyCount> countApply(String mbid);

	List<WkResume> resumeList(String mbid);

	List<WkApply> applyList(String mbid);

}
