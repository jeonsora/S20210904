package com.oracle.s20210904.wk.dao;

import java.util.List;

import com.oracle.s20210904.comm.model.Resume;

public interface WkResumeRepository {

	List<Resume> resumeList(String mbid);

}
