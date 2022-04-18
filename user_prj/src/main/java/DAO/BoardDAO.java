package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbConnection.DbConnection;
import VO.BoardrVO;

public class BoardDAO {
	
	/**
	 * 게시판 페이지 보여주는 메소드
	 * @param bVO : 검색(작성자, 제목)
	 * @return : 페이지 보여주기
	 */
	public List<BoardrVO> selectBoard(BoardrVO bVO) throws SQLException{
		List<BoardrVO> list=new ArrayList<BoardrVO>();
		
		DbConnection dc=DbConnection.getInstance();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConn();
			StringBuilder sql=new StringBuilder();
			sql
			.append("select bd_id,title,recommend,views,input_date,userid")
			.append("from board")
			.append("where cat_num=? and userId=? or title=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, bVO.getCat_num());
			pstmt.setString(2, bVO.getUserid());
			pstmt.setString(3, bVO.getTitle());
			rs=pstmt.executeQuery();
			
			BoardrVO eVO=null;
			while(rs.next()) {
				eVO=new BoardrVO();
				eVO.setBd_id(rs.getInt("bd_id"));
				eVO.setTitle(rs.getString("title"));
				eVO.setInput_date(rs.getString("input_date"));
				eVO.setRecommend(rs.getInt("recommend"));
				eVO.setViews(rs.getInt("views"));
				
				list.add(eVO);
				
			}//end while
		}finally {
			dc.close(rs, pstmt, con);
		}//end finally
		
		return list;
	}//selectBoard
	
	/**
	 * 게시글 지우기
	 * @param bd_id : 게시글 번호
	 * @return 삭제 완료/실패
	 */
	public boolean deleteBoard(int bd_id) throws SQLException {
		DbConnection dc=DbConnection.getInstance();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		int n=0;
		
		try {
			con=dc.getConn();
			pstmt=con.prepareStatement("delete from board where=bd_id=?");
			pstmt.setInt(1, bd_id);			
			n=pstmt.executeUpdate();
			if(n>0) {
				result=true;
			}
				
		}finally {
			dc.close(null, pstmt, con);
		}//end finally
		return result;
	}//deleteBoard
	
	/**
	 * 게시글 작성
	 * @param bVO (작성자, 일자 등 )
	 */
	public void insertBoard(BoardrVO bVO) throws SQLException{
		DbConnection dc=DbConnection.getInstance();
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=dc.getConn();
			pstmt=con.prepareStatement("insert into board(title,description,cat_num,userid) values(?,?,?,?)");
			pstmt.setString(1,bVO.getTitle());			
			pstmt.setString(2,bVO.getDescription().toString());			
			pstmt.setInt(3,bVO.getCat_num());			
			pstmt.setString(4,bVO.getUserid());			
			pstmt.executeQuery();
				
		}finally {
			dc.close(null, pstmt, con);
		}//end finally
	}//insertBoard

	/**
	 * 게시글 수정
	 * @param bVO
	 * @return
	 */
	public boolean updateBoard(BoardrVO bVO)  throws SQLException{
		DbConnection dc=DbConnection.getInstance();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		int n=0;
		
		try {
			con=dc.getConn();
			pstmt=con.prepareStatement("update board set title=?, description=?, cat_num=? where bd_id=? and userid=?");
			pstmt.setString(1, bVO.getTitle());			
			pstmt.setString(2, bVO.getDescription().toString());			
			pstmt.setInt(3, bVO.getCat_num());			
			pstmt.setInt(4, bVO.getBd_id());			
			pstmt.setString(5, bVO.getUserid());			
			n=pstmt.executeUpdate();
			if(n>0) {
				result=true;
			}
				
		}finally {
			dc.close(null, pstmt, con);
		}//end finally
		return result;
	}
	
	/**
	 * 게시글 내용 보기
	 * @param bd_id
	 * @return
	 */
	public BoardrVO selectBoardDetail(int bd_id) throws SQLException {
		
		DbConnection dc=DbConnection.getInstance();
		
		BoardrVO eVO=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConn();
			StringBuilder sql=new StringBuilder();
			sql
			.append("select c.cat_name,b.title,b.userid,b.input_date,b.description,c.cm_description,c.input_date,c.cm_id,c.user_id")
			.append("from board b, comment c")
			.append("where (b.bd_id=c.bd_id) and bd_id=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1,bd_id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				eVO=new BoardrVO();
				eVO.setCat_name(rs.getString("cat_name"));
				eVO.setTitle(rs.getString("title"));
				eVO.setUserid(rs.getString("userid"));
				eVO.setInput_date(rs.getString("input_date"));
			//	eVO.setDescription(rs.getstring("description"));//질문(String Bulider는 어떻게, 같은 이름 input_date는 어떻게
			//	eVO.setCm_description(rs.getString("cm_description"));
				eVO.setCm_id(rs.getInt("cm_id"));
				eVO.setUserid(rs.getString("userid"));
				
				
			}//end while
		}finally {
			dc.close(rs, pstmt, con);
		}//end finally
		return eVO; //리턴은 어떻게..?
		
	}//selectBoardDetail


}//class
