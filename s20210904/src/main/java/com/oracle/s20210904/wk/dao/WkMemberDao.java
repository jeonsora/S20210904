package com.oracle.s20210904.wk.dao;

import com.oracle.s20210904.comm.model.Member;

public interface WkMemberDao {

	Member memberDetail(String mbid);

	int memberUpdate(Member member);

}
