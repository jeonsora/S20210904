package com.oracle.s20210904.gm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210904.comm.model.ComAnnounce;
import com.oracle.s20210904.comm.model.Comm;
import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.comm.model.Scrap;

@Repository
public class GmAnnoDaoImpl implements GmAnnoDao {
	
	@Autowired
	private SqlSession session;

	public int total() {
		int tot = 0;
		System.out.println("GmAnnoDaoImpl total Start...");
		try {
			tot = session.selectOne("GmAnnoTotal");
		} catch (Exception e) {
			System.out.println("GmAnnoDaoImpl total Exception"+e.getMessage());
		}
		return tot;
	}

	@Override
	public List<ComAnnounce> listAnno(ComAnnounce comAnnounce) {
		List<ComAnnounce> annoList = null;
		System.out.println("GmAnnoDaoImpl listAnno Start...");
		try {
			annoList = session.selectList("GmAnnoListAll", comAnnounce);
		} catch (Exception e) {
			System.out.println("GmAnnoDaoImpl listAnno Exception"+e.getMessage());
		}
		
		return annoList;
	}

	@Override
	public ComAnnounce detail(String anno_code) {
		ComAnnounce comanno = new ComAnnounce();
		System.out.println("GmAnnoDaoImpl detail Start...");
		try {
			comanno = session.selectOne("GmAnnoSelOne", anno_code);
			System.out.println("GmAnnoDaoImpl comanno.getCom_name()->"+comanno.getCom_name());
			System.out.println("GmAnnoDaoImpl comanno.getAnno_code()->"+comanno.getAnno_code());
		} catch (Exception e) {
			System.out.println("GmAnnoDaoImpl detail Exception"+e.getMessage());
		}
		
		return comanno;
	}
	/*
	@Override
	public List<Comm> recjob() {
		List<Comm> recjob = null;
		System.out.println("GmAnnoDaoImpl recjob Start...");
		try {
			recjob = session.selectList("GmCommRecjob");
			System.out.println("GmAnnoDaoImpl recjob.size()->"+recjob.size());
		} catch (Exception e) {
			System.out.println("GmAnnoDaoImpl recjob Exception"+e.getMessage());
		}
		return recjob;
	}
	*/
	// 모집 직종
	@Override
	public Comm recjob(ComAnnounce com) {
		Comm comm = null;
		System.out.println("GmAnnoDaoImpl recjob Start...");
		try {
			comm = session.selectOne("GmCommRecjob",com);
			System.out.println("comm에는 무엇이 있나?->"+comm.getComm_ctx());
			System.out.println("GmAnnoDaoImpl comm.getComm_ctx()->"+comm.getComm_ctx());
		} catch (Exception e) {
			System.out.println("GmAnnoDaoImpl recjob Exception"+e.getMessage());
		}
		
		return comm;
	}

	// 고용 형태
	
		@Override
		public Comm emptype(ComAnnounce com) {
			Comm comm = null;
			System.out.println("GmAnnoDaoImpl emptype Start...");
			try {
				comm = session.selectOne("GmCommEmptype", com);
				System.out.println("GmAnnoDaoImpl comm.getComm_ctx()->"+comm.getComm_ctx());
			} catch (Exception e) {
				System.out.println("GmAnnoDaoImpl emptype Exception"+e.getMessage());
			}
			return comm;
		}

		/*
		@Override
		public List<Comm> emptype(ComAnnounce com) {
			List<Comm> comm = null;
			System.out.println("GmAnnoDaoImpl emptype Start...");
			try {
				comm = session.selectList("GmCommEmptype", com);
				System.out.println("GmAnnoDaoImpl comm.getComm_ctx()->"+comm.size());
			} catch (Exception e) {
				System.out.println("GmAnnoDaoImpl emptype Exception"+e.getMessage());
			}
			return comm;
		}
		 */
		
		// 기술 스택 1
		@Override
		public Comm Techtag1(ComAnnounce comanno) {
			Comm comm = null;
			System.out.println("GmAnnoDaoImpl Techtag1 Start...");
			try {
				comm = session.selectOne("GmCommTechtag1", comanno);
				System.out.println("GmAnnoDaoImpl Techtag1 comm.getComm_ctx()->"+comm.getComm_ctx());
			} catch (Exception e) {
				System.out.println("GmAnnoDaoImpl Techtag1 Exception"+e.getMessage());
			}
			return comm;
		}
		
		// 기술 스택 2
			@Override
			public Comm Techtag2(ComAnnounce comanno) {
				Comm comm = null;
				System.out.println("GmAnnoDaoImpl Techtag2 Start...");
				try {
					comm = session.selectOne("GmCommTechtag2", comanno);
					System.out.println("GmAnnoDaoImpl Techtag2 comm.getComm_ctx()->"+comm.getComm_ctx());
				} catch (Exception e) {
					System.out.println("GmAnnoDaoImpl Techtag2 Exception"+e.getMessage());
				}
				return comm;
			}

			// 경력
			@Override
			public Comm career(ComAnnounce comanno) {
				Comm comm = null;
				System.out.println("GmAnnoDaoImpl career Start...");
				try {
					comm = session.selectOne("GmCommCareer", comanno);
					System.out.println("GmAnnoDaoImpl career comm.getComm_ctx()->"+comm.getComm_ctx());
				} catch (Exception e) {
					System.out.println("GmAnnoDaoImpl career Exception"+e.getMessage());
				}
				return comm;
			}

			// 업종
			@Override
			public Comm comsec(ComAnnounce comanno) {
				Comm comm = null;
				System.out.println("GmAnnoDaoImpl comsec Start...");
				try {
					comm = session.selectOne("GmCommComsec", comanno);
					System.out.println("GmAnnoDaoImpl comsec comm.getComm_ctx()->"+comm.getComm_ctx());
				} catch (Exception e) {
					System.out.println("GmAnnoDaoImpl comsec Exception"+e.getMessage());
				}
				return comm;
			}
			// 스크랩
			@Override
			public int likecnt(Scrap scrap) {
				int check = 0;
				System.out.println("GmAnnoDaoImpl likecnt Start...");
				try {
					check = session.selectOne("GmLikeCount", scrap);
				} catch (Exception e) {
					System.out.println("GmAnnoDaoImpl likecnt Exception "+e.getMessage());
				}
				System.out.println("Dao check->"+check);
				return check;
			}

			// 스크랩 추가
			@Override
			public void likeinsert(Scrap scrap) {
				System.out.println("GmAnnoDaoImpl likeinsert Start...");
				try {
					session.insert("GmLikeInsert", scrap);
				} catch (Exception e) {
					System.out.println("GmAnnoDaoImpl likeinsert Exception "+e.getMessage());
				}
				
			}

			// 스크랩 유무
			@Override
			public int likegetinfo(Scrap scrap) {
				int like = 0;
				System.out.println("GmAnnoDaoImpl likegetinfo Start...");
				try {
					like = session.selectOne("GmLikeGetInfo", scrap);
				} catch (Exception e) {
					System.out.println("GmAnnoDaoImpl likegetinfo Exception "+e.getMessage());
				}
				return like;
			}

			@Override
			public void likeupdate(Scrap scrap) {
				System.out.println("GmAnnoDaoImpl likeupdate Start...");
				try {
					session.update("GmLikeUpdate", scrap);
				} catch (Exception e) {
					System.out.println("GmAnnoDaoImpl likeupdate Exception "+e.getMessage());
				}
				
			}

			// 이력서 total
			@Override
			public int applytotal() {
				System.out.println("GmAnnoDaoImpl applytotal Start...");
				int tot = 0;
				try {
					tot = session.selectOne("GmResumeTotal");
				} catch (Exception e) {
					System.out.println("GmAnnoDaoImpl applytotal Exception "+e.getMessage());
				}
				return tot;
			}

			//이력서 list
			@Override
			public List<Resume> listres(Resume resume) {
				List<Resume> resList = null;
				System.out.println("GmAnnoDaoImpl listres Start...");
				try {
					resList = session.selectList("GmResumeList", resume);
				} catch (Exception e) {
					System.out.println("GmAnnoDaoImpl resume Exception "+e.getMessage());
				}
				return resList;
			}

			// 이력서 제출
			@Override
			public Resume selResume(Resume resume) {
				Resume res = null;
				try {
					res = session.selectOne("GmSelResume", resume);
				} catch (Exception e) {
					System.out.println("GmAnnoDaoImpl selResume Exception "+e.getMessage());
				}
			
				return res;
			}
	
	


	

}
