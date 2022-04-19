package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import DbConnection.DbcpConnection;
import VO.ExhibitionVO;
import VO.LocalVO;
import VO.ReservationManagerVO;

public class UserReservationDAO {
	
	private static UserReservationDAO urDAO;
	
	public static UserReservationDAO getInstance() {
		if(urDAO == null) {
			urDAO=new UserReservationDAO();
		}//end if
		return urDAO;
	}//getInstance
	
	
	
	/**
	 * 날짜 출력
	 * @param ex_num : 전시 번호
	 * @return 전시 시작일/ 마지막일 출력
	 */
	public ExhibitionVO selectDate(int ex_num) throws SQLException{
		
		DbcpConnection dc=new DbcpConnection();
		ExhibitionVO eVO=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
			String sql="select exhibit_date,deadline from exhibition where ex_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,ex_num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				eVO=new ExhibitionVO();
				eVO.setExhibit_date(rs.getString("exhibit_date"));
				eVO.setDead_line(rs.getString("deadlind"));
				
				
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		return eVO; //리턴은 어떻게..?
	}//selectDate
	

	/**
	 * 전시 리스트 보여주기
	 * @param ex_loc 지역 이름
	 * @return 전시 이름, 전시 번호
	 */
	public List<ExhibitionVO> selectExhibition(String ex_loc) throws SQLException{
		List<ExhibitionVO> list=new ArrayList<ExhibitionVO>();
		
		DbcpConnection dc=new DbcpConnection();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
			String sql="select e.ex_num, e.ex_name from exhibition e, exhibition_loc el where (e.ex_num=el.ex_num(+)) and el.ex_loc=?";
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, ex_loc);
			rs=pstmt.executeQuery();
			
			ExhibitionVO eVO=null;
			while(rs.next()) {
				eVO=new ExhibitionVO();
				eVO.setEx_num(rs.getInt("ex_num"));
				eVO.setEx_name(rs.getString("ex_name"));
				
				list.add(eVO);
				
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		
		return list;
	}//selectExhibition
	
	/**
	 * 지역 리스트 출력
	 * @return
	 */
	public List<LocalVO> selectLocal() throws SQLException{
		List<LocalVO> list=new ArrayList<LocalVO>();
		
		DbcpConnection dc=new DbcpConnection();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
			String sql="select ex_loc from exhibition_loc";
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery(sql);
			
			LocalVO lVO=null;
			while(rs.next()) {
				lVO=new LocalVO();
				lVO.setEx_loc("ex_loc");
				
				list.add(lVO);
				
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		
		return list;
	}//selectLocal
	
	/**
	 * 전시 안내 출력
	 * @param ex_num
	 * @return
	 */
	public ExhibitionVO selectInform(int ex_num) throws SQLException {
		DbcpConnection dc=new DbcpConnection();
		
		ExhibitionVO eVO=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
			String sql="select e.ex_intro, p.adult, p.teen, p.child from exhibition e, price p where  (e.ex_num=p.ex_num) and e.ex_num=?";
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1,ex_num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				eVO=new ExhibitionVO();
				eVO.setEx_intro(rs.getString("ex_intro"));
				eVO.setAdult(rs.getInt("adult"));
				eVO.setTeen(rs.getInt("teen"));
				eVO.setChild(rs.getInt("child"));
			
				
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		return eVO; 
	}//selectInform
	
	/**
	 * 예약하기
	 * @return
	 */
	public void insertReservation(ReservationManagerVO rVO) throws SQLException {
		DbcpConnection dc=new DbcpConnection();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=dc.getConnection();
			StringBuilder sql=new StringBuilder();
			sql
			.append("insert into reservation(rez_date, rez_count, visit_date, ex_num, userid,rez_status)")
			.append("values(?,?,?,?,?) ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, rVO.getRez_date());			
			pstmt.setInt(2, rVO.getRez_count());			
			pstmt.setString(3, rVO.getVisit_date());			
			pstmt.setInt(4, rVO.getEx_num());			
			pstmt.setString(5, rVO.getUserid());			
			pstmt.setString(6, String.valueOf(rVO.getRez_status()));			
			
			pstmt.executeUpdate();
			
				
		}finally {
			dc.dbClose(null, pstmt, con);
		}//end finally
	}//insertReservation




}//class
