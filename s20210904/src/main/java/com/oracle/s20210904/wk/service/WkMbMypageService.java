package com.oracle.s20210904.wk.service;

import java.util.List;

import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.wk.model.Applycount;

public interface WkMbMypageService {

	List<Applycount> countApply(String mbid);

	List<Resume> resumeList(String mbid);

}
