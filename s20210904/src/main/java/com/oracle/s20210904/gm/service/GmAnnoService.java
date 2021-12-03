package com.oracle.s20210904.gm.service;

import java.util.List;

import com.oracle.s20210904.comm.model.ComAnnounce;
import com.oracle.s20210904.comm.model.Comm;

public interface GmAnnoService {

	int total();

	List<ComAnnounce> listAnno(ComAnnounce comAnnounce);

	ComAnnounce detail(String anno_code);

	Comm recjob(ComAnnounce com);

	Comm emptype();
	
	//List<Comm> recjob();



}
