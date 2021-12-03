package com.oracle.s20210904.wk.dao;

import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.wk.model.WkResumeDetail;

public interface WkResumeDetailDao {

	int resumeDetailWrite(WkResumeDetail wkResumeDetail);

	int resumeDetailDelete(Resume resume);

}
