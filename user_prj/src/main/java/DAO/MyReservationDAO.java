package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbConnection.DbcpConnection;
import VO.MyReservationVO;

public class MyReservationDAO {
	
private static MyReservationDAO mrDAO;
	
	public static MyReservationDAO getInstance() {
		if(mrDAO == null) {
			mrDAO=new MyReservationDAO();
		}//end if
		return mrDAO;
	}//getInstance
	
	
	/**
	 * ���� ��Ȳ �����ֱ�
	 * @param userId
	 * @return
	 */
	public List<MyReservationVO> selectAllReservation(String userid) throws SQLException{
		List<MyReservationVO> list=new ArrayList<MyReservationVO>();
		
		DbcpConnection dc=new DbcpConnection();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
			StringBuilder sql=new StringBuilder();
			sql
			.append("select e.ex_name , r.visit_date, r.rez_count, r.rez_date, r.rez_status,r.rez_num ")
			.append("from reservation r, exhibition e ")
			.append("where (e.ex_num(+)=r.ex_num) and userid=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			
			MyReservationVO mVO=null;
			while(rs.next()) {
				mVO=new MyReservationVO();
				mVO.setEx_name(rs.getString("ex_name"));
				mVO.setRez_num(rs.getInt("rez_num"));
				mVO.setVisit_date(rs.getString("visit_date"));
				mVO.setRez_count(rs.getInt("rez_count"));
				mVO.setRez_date(rs.getString("rez_date"));
				mVO.setRez_status(rs.getString("rez_status"));
				
				list.add(mVO);
				
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		
		return list;
	}//selectAllReservation

	/**
	 * ���� �� ��Ȳ �����ֱ�
	 * @param rez_num : ���� ��ȣ
	 * @return
	 */
	public MyReservationVO selectReservationDetail(MyReservationVO mrVO) throws SQLException {
		DbcpConnection dc=new DbcpConnection();
		
		MyReservationVO mVO=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
			StringBuilder sql=new StringBuilder();
			sql
			.append("select r.userid, r.rez_num, e.ex_name, eh.ex_hall_name ehx, r.visit_date, r.rez_count ")
			.append("from exhibition e, reservation r, exhibition_hall eh ")
			.append("where (e.ex_num=r.ex_num and e.ex_hall_num=eh.ex_hall_num) and r.rez_num=? and r.userid=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1,mrVO.getRez_num());
			pstmt.setString(2,mrVO.getUserid());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				mVO=new MyReservationVO(); //���� �� ����
				mVO.setUserid(rs.getString("userid"));
				mVO.setRez_num(rs.getInt("rez_num"));
				mVO.setEx_name(rs.getString("ex_name"));
				mVO.setEx_hall_name(rs.getString("ehx"));
				mVO.setVisit_date(rs.getString("visit_date"));
				mVO.setRez_count(rs.getInt("rez_count"));
				
			
				
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		return mVO; 
	}//selectReservationDetail
	
	/**
	 * ���� ���
	 * @param mVO : ���̵�, ���� ��ȣ
	 */
	public boolean deleteReservation(MyReservationVO mVO) throws SQLException {
		DbcpConnection dc=new DbcpConnection();
		Connection con=null;
		PreparedStatement pstmt=null;
		int n=0;
		boolean result=false;
		
		try {
			con=dc.getConnection();
			pstmt=con.prepareStatement("delete from reservation where userid=? and rez_num=?");
			pstmt.setString(1,mVO.getUserid());			
			pstmt.setInt(2,mVO.getRez_num());			
					
			n=pstmt.executeUpdate();
			if(n>0) {
				result=true;
			}
		}finally {
			dc.dbClose(null, pstmt, con);
		}//end finally
		return result;
	}//deleteReservation
	

}//class