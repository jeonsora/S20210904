package com.oracle.s20210904.sy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210904.comm.model.Post;
import com.oracle.s20210904.sy.dao.SyPostDao;

@Service("SyPostServiceImpl")
public class SyPostServiceImpl implements SyPostService{

	@Autowired
	private SyPostDao syPostDao;
	
	@Override
	public void postInsert(Post post) throws Exception {
		syPostDao.postInsert(post);
	}

	@Override
	public void postUpdate(Post post) throws Exception {
		syPostDao.postUpdate(post);
	}

	@Override
	public void postDelete(Post post) throws Exception {
		syPostDao.postDelete(post);
	}
	
	
}
