package com.oracle.s20210904.sy.service;

import com.oracle.s20210904.comm.model.Post;

public interface SyPostService {
	public void postInsert (Post post) throws Exception;
	
	public void postUpdate (Post post) throws Exception;
	
	public void postDelete (Post post) throws Exception;
}
