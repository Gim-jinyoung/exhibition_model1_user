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
	 * �Խ��� ������ �����ִ� �޼ҵ�
	 * @param bVO : �˻�(�ۼ���, ����)
	 * @return : ������ �����ֱ�
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
			.append("select rownum ,title,views,input_date,userid,cnt ,bd_id ")
			.append("from ")
			.append("(select row_number() over(order by b.input_date desc) rnum, b.bd_id,b.title,b.views,b.input_date,b.userid,count(c.cm_id) cnt ")
			.append("from board b, comment_table c ")
			.append("where (b.bd_id=c.bd_id(+)) and b.cat_num=? ");
			if(bVO.getTitle() != null ) {
				sql
				.append(" and ( b.userid=? or b.title=?) ");
			}
			sql.append("group by b.bd_id,b.title,b.views,b.input_date,b.userid) ")
			.append("where rnum between ? and ? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, bVO.getCat_num());
		
			if(bVO.getTitle() != null ) {
					pstmt.setString(2, bVO.getUserid());
					pstmt.setString(3, bVO.getTitle());
					pstmt.setInt(4, bVO.getPageNum());
					pstmt.setInt(5, bVO.getPageNum()+9);
			}else {
				pstmt.setInt(2, bVO.getPageNum());
				pstmt.setInt(3, bVO.getPageNum()+9);
			}
		
			rs=pstmt.executeQuery();
			
			BoardrVO eVO=null;
			while(rs.next()) {
				eVO=new BoardrVO();
				eVO.setRownum(rs.getInt("rownum"));
				eVO.setTitle(rs.getString("title"));
				eVO.setUserid(rs.getString("userid"));
				eVO.setInput_date(rs.getString("input_date"));
				eVO.setViews(rs.getInt("views"));
				eVO.setRecommend(rs.getInt("cnt"));
				eVO.setBd_id(rs.getInt("bd_id"));
				
				list.add(eVO);
				
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		
		return list;
	}//selectBoard
	
	public List<BoardrVO> selectCategory() throws SQLException{
		List<BoardrVO> list=new ArrayList<BoardrVO>();
		
		DbcpConnection dc=new DbcpConnection();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
			String sql="select cat_name,cat_num from category";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			BoardrVO eVO=null;
			while(rs.next()) {
				eVO=new BoardrVO();
				eVO.setCat_name(rs.getString("cat_name"));
				eVO.setCat_num(rs.getInt("cat_num"));
				
				
				list.add(eVO);
				
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		
		return list;
	}//selectBoard
	
	/**
	 * �Խñ� �����
	 * @param bd_id : �Խñ� ��ȣ
	 * @return ���� �Ϸ�/����
	 */
	public boolean deleteBoard(int bd_id) throws SQLException {
		DbcpConnection dc=new DbcpConnection();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		int n=0;
		
		try {
			con=dc.getConnection();
			pstmt=con.prepareStatement("delete from board where bd_id=?");
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
	
	public boolean deleteComment(int cm_id) throws SQLException {
		DbcpConnection dc=new DbcpConnection();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		int n=0;
		
		try {
			con=dc.getConnection();
			pstmt=con.prepareStatement("delete from comment_table where cm_id=?");
			pstmt.setInt(1, cm_id);			
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
	 * �Խñ� �ۼ�
	 * @param bVO (�ۼ���, ���� �� )
	 */
	public void insertBoard(BoardrVO bVO) throws SQLException{
		DbcpConnection dc=new DbcpConnection();
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=dc.getConnection();
			pstmt=con.prepareStatement("insert into board(bd_id,title,description,cat_num,userid,imgfile) values(bd_seq.nextval,?,?,?,?,?)");
			pstmt.setString(1,bVO.getTitle());			
			pstmt.setString(2,bVO.getDescription().toString().replaceAll("<", "").replaceAll(">", "").replaceAll("/", "").replace("p", ""));			
			pstmt.setInt(3,bVO.getCat_num());			
			pstmt.setString(4,bVO.getUserid());			
			pstmt.setString(5,bVO.getImgfile());			
			pstmt.executeQuery();
				
		}finally {
			dc.dbClose(null, pstmt, con);
		}//end finally
	}//insertBoard
	
	

	public void insertComment(BoardrVO bVO) throws SQLException{
		DbcpConnection dc=new DbcpConnection();
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=dc.getConnection();
			pstmt=con.prepareStatement("insert into comment_table(cm_id,cm_description,bd_id,userid) values(cm_seq.nextval,?,?,?)");
			pstmt.setString(1,bVO.getCm_description());			
			pstmt.setInt(2,bVO.getBd_id());			
			pstmt.setString(3,bVO.getUserid());			
			pstmt.executeQuery();
				
		}finally {
			dc.dbClose(null, pstmt, con);
		}//end finally
	}//insertBoard
	/**
	 * �Խñ� ����
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
			StringBuilder sql=new StringBuilder();
			sql.append("update board set title=?, description=?, cat_num=?  ");
			if (bVO.getImgfile() != null) {
				sql.append(", imgfile= ?");
			}
			sql.append("where bd_id=? and userid=?");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, bVO.getTitle());			
			pstmt.setString(2, bVO.getDescription().toString());			
			pstmt.setInt(3, bVO.getCat_num());		
			if (bVO.getImgfile() != null) {
				pstmt.setString(4, bVO.getImgfile());		
				pstmt.setInt(5, bVO.getBd_id());			
				pstmt.setString(6, bVO.getUserid());		
			}else {
				pstmt.setInt(4, bVO.getBd_id());			
				pstmt.setString(5, bVO.getUserid());	
			}
			
			n=pstmt.executeUpdate();
			if(n>0) {
				result=true;
			}
				
		}finally {
			dc.dbClose(null, pstmt, con);
		}//end finally
		return result;
	}//updateBoard
	
	public void updateView(int bd_id)  throws SQLException{
		DbcpConnection dc=new DbcpConnection();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		int n=0;
		
		try {
			con=dc.getConnection();
			pstmt=con.prepareStatement("update board set views =views+1 where bd_id=? ");
			pstmt.setInt(1, bd_id);			
			n=pstmt.executeUpdate();
			
				
		}finally {
			dc.dbClose(null, pstmt, con);
		}//end finally
	}//updateBoard
	
	
	/**
	 * �Խñ� ���� ����
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
			.append("select ct.cat_name,b.title,b.userid,b.input_date,b.description,b.bd_id,b.imgfile ")
			.append("from board b, comment_table c,CATEGORY ct ")
			.append("where (b.bd_id=c.bd_id(+) and b.cat_num(+)=ct.cat_num) and b.bd_id=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1,bd_id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bVO=new BoardrVO();
				bVO.setCat_name(rs.getString("cat_name"));
				bVO.setBd_id(rs.getInt("bd_id"));
				bVO.setTitle(rs.getString("title"));
				bVO.setUserid(rs.getString("userid"));
				bVO.setInput_date(rs.getString("input_date"));
				bVO.setDescription(rs.getString("description"));
				bVO.setImgfile(rs.getString("imgfile"));
				
				
				
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		return bVO; 
		
	}//selectBoardDetail
	public List<BoardrVO> selectcomment(int bd_id) throws SQLException{
		List<BoardrVO> list=new ArrayList<BoardrVO>();
		
		DbcpConnection dc=new DbcpConnection();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
			String sql="select cm_description,input_date ,cm_id,userid from comment_table where bd_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,bd_id);
			rs=pstmt.executeQuery();
			
			BoardrVO bVO=null;
			while(rs.next()) {
				bVO=new BoardrVO();
				bVO.setCm_description(rs.getString("cm_description"));
				bVO.setCm_id(rs.getInt("cm_id"));
				bVO.setCm_userid(rs.getString("userid"));
				bVO.setCm_input_date(rs.getString("input_date"));
				list.add(bVO);
				
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		
		return list;
	}//selectBoard
	

	public int selectTotalBoard(int cat_num) throws SQLException{
		
		int result = 0;
		DbcpConnection dc=new DbcpConnection();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
			String sql="select count(bd_id) cnt from board where cat_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,cat_num);
			rs=pstmt.executeQuery();
			
			BoardrVO bVO=null;
			while(rs.next()) {
				result=rs.getInt("cnt");
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		
		return result;
	}//selectBoard

}//class
