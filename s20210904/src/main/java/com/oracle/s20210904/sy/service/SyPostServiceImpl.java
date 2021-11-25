package com.oracle.s20210904.sy.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210904.comm.model.Post;
import com.oracle.s20210904.sy.dao.SyPostDao;
import com.oracle.s20210904.sy.dao.SyPostDaoImpl;

@Service("syPostServiceImpl")
public class SyPostServiceImpl implements SyPostService{

	@Autowired
	private SyPostDao syPostDao;
	
	// 게시글 목록
	@Override
	public List<Post> postList(Post post) throws Exception {
		return syPostDao.postList(post);
	}
	
	// 게시글 작성
	@Override
	public void postInsert(Post post) throws Exception {
		String post_title = post.getPost_title();
		String post_ctx = post.getPost_ctx();
		String member_id = member.getUser_id();
		
		post.setPost_title(post_title);
		post.setPost_ctx(post_ctx);
		member.setUser_id(user_id);
		
		syPostDao.postInsert(post);
	}
	
	// 작성글 조회
	@Override
	public Post postRead(int post_code) throws Exception {
		return syPostDao.postRead(post_code);
	}
	
	// 게시글 수정
	@Override
	public void postUpdate(Post post) throws Exception {
		syPostDao.postUpdate(post);
	}
	
	// 게시글 삭제
	@Override
	public void postDelete(int post_code) throws Exception {
		syPostDao.postDelete(post_code);
	}
	
	// 게시글 조회수
	@Override
	public void increasePostView(int post_code, HttpSession session) throws Exception {
		long updateTime = 0;
		
		if(session.getAttribute("updateTime" + post_code) != null) {
			updateTime = (long)session.getAttribute("UpdateTime" + post_code);
		}
		
		long currentTime = System.currentTimeMillis();
		
		if(currentTime - updateTime > 5*1000) {
			syPostDao.increasePostView(post_code);
			session.setAttribute("UpdateTime" + post_code, currentTime);
		}
	}
	
}
