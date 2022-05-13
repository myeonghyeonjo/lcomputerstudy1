package com.lcomputerstudy1.testmvc.service;

import java.util.ArrayList;


import com.lcomputerstudy1.testmvc.dao.ReplyDAO;

import com.lcomputerstudy1.testmvc.vo.Reply;

public class ReplyService {
	private static ReplyService service = null;
	private static ReplyDAO dao = null;
    
	private ReplyService() {
		
	}

	public static ReplyService getInstance() {
		if(service == null) {
			service = new ReplyService();
			dao = ReplyDAO.getInstance();
		}
		return service;
	}

	public void insertReply(Reply reply) {
		dao.insertReply(reply);
	}

	
}
