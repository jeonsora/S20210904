package com.oracle.s20210904.sy.dao;

import com.oracle.s20210904.comm.model.Post;

public interface SyPostDao {
	
	void postInsert (Post post) throws Exception;
	
	void postUpdate (Post post) throws Exception;
	
	void postDelete (Post post) throws Exception;
}
