package com.lcomputerstudy1.testmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.lcomputerstudy1.testmvc.database.DBConnection;
import com.lcomputerstudy1.testmvc.vo.Board;
import com.lcomputerstudy1.testmvc.vo.Pagination;
import com.lcomputerstudy1.testmvc.vo.User;

public class BoardDAO {
	
	private static BoardDAO dao = null;
    
	private BoardDAO() {
		
	}

	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	public ArrayList<Board> getBoards() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board> list = null;
		
		try {
			conn = DBConnection.getConnection();
			String query = "select * from board order by b_group, b_order, b_depth desc";
	       	pstmt = conn.prepareStatement(query);
	        rs = pstmt.executeQuery();
	        list = new ArrayList<Board>();

	        while(rs.next()){     
	        	Board Board = new Board();
	        	Board.setb_title(rs.getString("b_title"));
	        	Board.setb_count(rs.getInt("b_count"));
	        	Board.setb_content(rs.getString("b_content"));
	        	Board.setb_date(rs.getString("b_date"));
	        	Board.setb_writer(rs.getString("b_writer"));
	        	Board.setb_idx(rs.getInt("b_idx"));
	        	Board.setb_group(rs.getInt("b_group"));
	        	Board.setb_order(rs.getInt("b_order"));
	        	Board.setb_depth(rs.getInt("b_depth"));
	        	
	        	list.add(Board);
	        }
		} catch (Exception e) {
			
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	public void insertBoard(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into board(b_title,b_count,b_content,b_date,b_writer, b_group, b_order, b_depth) values(?,?,?,now(),?, 0, 1, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getb_title());
			pstmt.setInt(2, board.getb_count());
			pstmt.setString(3, board.getb_content());
			pstmt.setString(4, board.getb_writer());
			pstmt.executeUpdate();
			pstmt.close();
			
			sql = "update board set b_group = last_insert_id() where b_idx = last_insert_id()";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
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
	
	public Board getDetail(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ncount = board.getb_count();
		
		
		
		try {
			conn = DBConnection.getConnection();
			String query = "select * from board where b_idx = ?";
	       	pstmt = conn.prepareStatement(query);
	       	pstmt.setInt(1, board.getb_idx());
	        rs = pstmt.executeQuery();
	        
	        while(rs.next()){
	        	
	        	board= new Board();
       	       	board.setb_title(rs.getString("b_title"));
       	       	board.setb_writer(rs.getString("b_writer"));
       	       	board.setb_date(rs.getString("b_date"));
       	       	board.setb_content(rs.getString("b_content"));
       	       	board.setb_count(rs.getInt("b_count"));
       	       	board.setb_idx(rs.getInt("b_idx"));
       	       	
       	       	board.setb_order(rs.getInt("b_order"));
       	       	board.setb_group(rs.getInt("b_group"));
       	       	board.setb_depth(rs.getInt("b_depth"));
       	       	
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return board;
		
		
	}
	public void editBoard(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE board SET b_title = ?,b_writer = ?,b_content = ? where b_idx= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getb_title());
			pstmt.setString(2, board.getb_writer());;
			pstmt.setString(3, board.getb_content());
			pstmt.setInt(4, board.getb_idx());
			pstmt.executeUpdate();
		} catch( Exception ex) {
			System.out.println("SQLException : "+ex.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void getdelete(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			String query = "delete from board where b_idx=?";
	       	pstmt = conn.prepareStatement(query);
	       	pstmt.setInt(1, board.getb_idx());
	        pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}    
	}
	
	public void getdate(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into board(b_title,b_count,b_content,b_date,b_writer) values(?,?,?,?,?)";
			String a = "select getdate() from board";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getb_title());
			pstmt.setInt(2, board.getb_count());
			pstmt.setString(3, board.getb_content());
			pstmt.setString(4, a);
			pstmt.setString(5, board.getb_writer());
			pstmt.executeUpdate();
		} catch( Exception ex) {
			System.out.println("SQLException : "+ex.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	
	public void updatecount(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE board SET b_count = b_count+1 where b_idx= ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board.getb_idx());
			pstmt.executeUpdate();
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

	public void insertReply(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into board(b_title,b_count,b_content,b_date,b_writer, b_group, b_order, b_depth) values(?,?,?,now(),?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getb_title());
			pstmt.setInt(2, board.getb_count());
			pstmt.setString(3, board.getb_content());
			pstmt.setString(4, board.getb_writer());
			pstmt.setInt(5, board.getb_group());
			pstmt.setInt(6, board.getb_order()+1);
			pstmt.setInt(7,board.getb_depth()+1);
			pstmt.executeUpdate();
			pstmt.close();
				
			
			
			
			
			String sql1 = "UPDATE board SET b_order = b_order+1 where b_group = ? and b_order > ?";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, board.getb_group());
			pstmt.setInt(2, board.getb_order());
			pstmt.executeUpdate();
			
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
}



