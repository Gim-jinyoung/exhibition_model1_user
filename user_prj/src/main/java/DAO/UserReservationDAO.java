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
	 * ��¥ ���
	 * @param ex_num : ���� ��ȣ
	 * @return ���� ������/ �������� ���
	 */
	public String selectDate(int ex_num) throws SQLException{
		
		DbcpConnection dc=new DbcpConnection();
		ExhibitionVO eVO=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
			String sql="select deadline from exhibition where ex_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,ex_num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				eVO=new ExhibitionVO();
				eVO.setDead_line(rs.getString("deadline"));
				
				
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		return eVO.getDead_line(); //������ ���..?
	}//selectDate
	

	/**
	 * ���� ����Ʈ �����ֱ�
	 * @param ex_loc ���� �̸�
	 * @return ���� �̸�, ���� ��ȣ
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
	 * ���� ����Ʈ ���
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
			pstmt=con.prepareStatement("select ex_loc from exhibition_loc");
			rs=pstmt.executeQuery();
			
			LocalVO lVO=null;
			while(rs.next()) {
				lVO=new LocalVO();
				lVO.setEx_loc(rs.getString("ex_loc"));
				
				list.add(lVO);
				
			}//end while
		}finally {
			dc.dbClose(rs, pstmt, con);
		}//end finally
		
		return list;
	}//selectLocal
	
	/**
	 * ���� �ȳ� ���
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
	 * �����ϱ�
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
			.append("insert into reservation(rez_num, rez_count, visit_date, ex_num, userid,rez_status) ")
			.append("values(res_seq.nextval,?,?,?,?,?) ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, rVO.getRez_count());			
			pstmt.setString(2, rVO.getVisit_date());			
			pstmt.setInt(3, rVO.getEx_num());			
			pstmt.setString(4, rVO.getUserid());			
			pstmt.setString(5, String.valueOf(rVO.getRez_status()));			
			
			pstmt.executeUpdate();
			
				
		}finally {
			dc.dbClose(null, pstmt, con);
		}//end finally
	}//insertReservation




}//class
