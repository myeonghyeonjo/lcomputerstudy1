package com.lcomputerstudy1.testmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lcomputerstudy1.testmvc.database.DBConnection;
import com.lcomputerstudy1.testmvc.vo.Reply;

public class ReplyDAO {

	private static ReplyDAO dao = null;
	
	private ReplyDAO() {
		
	}
	
	
	public void insertReply(Reply reply) {
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into reply(r_content,r_writer,r_date,r_idx ) values(?,?,now(),?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reply.getr_content());
			pstmt.setString(2, reply.getr_writer());
			pstmt.setInt(3, reply.getr_idx());
			pstmt.executeUpdate();
			pstmt.close();
		} catch( Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static ReplyDAO getInstance() {
		if(dao == null) {
			dao = new ReplyDAO();
		}
		return dao;
	}

}
