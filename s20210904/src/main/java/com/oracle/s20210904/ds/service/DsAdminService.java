package com.oracle.s20210904.ds.service;

import java.util.List;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Post;

public interface DsAdminService {

	List<Company> getWaitCompany();
	int joinConfirm(String com_id);
	List<Post> getQnaList();

}
