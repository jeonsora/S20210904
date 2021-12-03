package com.oracle.s20210904.wk.dao;

import java.util.List;

import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.wk.model.WkResume;

public interface WkResumeDao {

	List<WkResume> resumeList(String mbid);

	int resumeWrite(WkResume wkResume);

	int resumeDelete(Resume resume);

	Resume resumeselect(Resume resume);

}
