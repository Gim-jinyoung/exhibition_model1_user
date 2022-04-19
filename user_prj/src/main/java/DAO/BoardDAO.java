package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbConnection.DbcpConnection;
import VO.BoardrVO;

public class BoardDAO {
	
private static BoardDAO bDAO;
	
	public static BoardDAO getInstance() {
		if(bDAO == null) {
			bDAO=new BoardDAO();
		}//end if
		return bDAO;
	}//getInstance
	
	/**
	 * 게시판 페이지 보여주는 메소드
	 * @param bVO : 검색(작성자, 제목)
	 * @return : 페이지 보여주기
	 */
	public List<BoardrVO> selectBoard(BoardrVO bVO) throws SQLException{
		List<BoardrVO> list=new ArrayList<BoardrVO>();
		
		DbcpConnection dc=new DbcpConnection();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
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
			dc.dbClose(rs, pstmt, con);
		}//end finally
		
		return list;
	}//selectBoard
	
	/**
	 * 게시글 지우기
	 * @param bd_id : 게시글 번호
	 * @return 삭제 완료/실패
	 */
	public boolean deleteBoard(int bd_id) throws SQLException {
		DbcpConnection dc=new DbcpConnection();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		int n=0;
		
		try {
			con=dc.getConnection();
			pstmt=con.prepareStatement("delete from board where=bd_id=?");
			pstmt.setInt(1, bd_id);			
			n=pstmt.executeUpdate();
			if(n>0) {
				result=true;
			}
				
		}finally {
			dc.dbClose(null, pstmt, con);
		}//end finally
		return result;
	}//deleteBoard
	
	/**
	 * 게시글 작성
	 * @param bVO (작성자, 일자 등 )
	 */
	public void insertBoard(BoardrVO bVO) throws SQLException{
		DbcpConnection dc=new DbcpConnection();
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=dc.getConnection();
			pstmt=con.prepareStatement("insert into board(title,description,cat_num,userid) values(?,?,?,?)");
			pstmt.setString(1,bVO.getTitle());			
			pstmt.setString(2,bVO.getDescription().toString());			
			pstmt.setInt(3,bVO.getCat_num());			
			pstmt.setString(4,bVO.getUserid());			
			pstmt.executeQuery();
				
		}finally {
			dc.dbClose(null, pstmt, con);
		}//end finally
	}//insertBoard

	/**
	 * 게시글 수정
	 * @param bVO
	 * @return
	 */
	public boolean updateBoard(BoardrVO bVO)  throws SQLException{
		DbcpConnection dc=new DbcpConnection();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		int n=0;
		
		try {
			con=dc.getConnection();
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
			dc.dbClose(null, pstmt, con);
		}//end finally
		return result;
	}//updateBoard
	
	/**
	 * 게시글 내용 보기
	 * @param bd_id
	 * @return
	 */
	public BoardrVO selectBoardDetail(int bd_id) throws SQLException {
		
		DbcpConnection dc=new DbcpConnection();
		
		BoardrVO bVO=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
			StringBuilder sql=new StringBuilder();
			sql
			.append("select c.cat_name,b.title,b.userid,b.input_date,b.description,c.cm_description,c.input_date ci,c.cm_id,c.user_id")
			.append("from board b, comment_table  c,CATEGORY ct")
			.append("where (b.bd_id=c.bd_id and b.cat_num=ct.cat_num) and bd_id=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1,bd_id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bVO=new BoardrVO();
				bVO.setCat_name(rs.getString("cat_name"));
				bVO.setTitle(rs.getString("title"));
				bVO.setUserid(rs.getString("userid"));
				bVO.setInput_date(rs.getString("input_date"));
				bVO.setDescription(new StringBuilder(rs.getString("description")));
				bVO.setCm_description(new StringBuilder(rs.getString("cm_description")));
				bVO.setCm_id(rs.getInt("cm_id"));
				bVO.setUserid(rs.getString("userid"));
				bVO.setCm_input_date(rs.getString("ci"));
				
				
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		return bVO; 
		
	}//selectBoardDetail


}//class
