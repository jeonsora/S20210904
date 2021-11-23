package com.oracle.s20210904.ds.dao;

import java.util.List;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Post;

public interface DsAdminDao {

	List<Company> getWaitCompany();
	int joinConfirm(String com_id);
	List<Post> getQnaList();

}
