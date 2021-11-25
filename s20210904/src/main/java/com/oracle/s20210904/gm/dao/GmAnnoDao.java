package com.oracle.s20210904.gm.dao;

import java.util.List;

import com.oracle.s20210904.comm.model.ComAnnounce;
import com.oracle.s20210904.comm.model.Comm;

public interface GmAnnoDao {

	int total();

	List<ComAnnounce> listAnno(ComAnnounce comAnnounce);

	ComAnnounce detail(String anno_code);

	//List<Comm> recjob();

	Comm recjob(ComAnnounce com);

	Comm emptype();
	

	

}
