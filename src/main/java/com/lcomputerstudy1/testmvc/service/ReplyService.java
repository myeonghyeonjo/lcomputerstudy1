package com.lcomputerstudy1.testmvc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.lcomputerstudy1.testmvc.dao.ReplyDAO;
import com.lcomputerstudy1.testmvc.database.DBConnection;
import com.lcomputerstudy1.testmvc.vo.Board;
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
	public ArrayList<Reply> getReplys() {
		return dao.getReplys();
	}

	public Reply getDetail(Reply reply) {
		return dao.getDetail(reply);
	}

	public void insertboardReply(Reply reply) {
		dao.insertboardReply(reply);
		
	}

	public Reply getDetails(Reply reply) {
		return dao.getDetails(reply);
	}

	
}