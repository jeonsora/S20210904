package com.oracle.s20210904.ds.dao;

import java.util.List;

import com.oracle.s20210904.comm.model.Announce;
import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Post;
import com.oracle.s20210904.comm.model.User;
import com.oracle.s20210904.ds.model.AnnounceCnt;

public interface DsAdminDao {

	List<Company> getWaitCompany();
	int joinConfirm(String com_id);
	List<Post> getQnaList();
	List<AnnounceCnt> announceCnt();
	List<Announce> getAnnounce();
	List<User> getUserList();

}
