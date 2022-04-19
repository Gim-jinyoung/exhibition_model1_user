package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbConnection.DbConnection;
import VO.CategoryVO;
import VO.MemberVO;


public class MyinfoDAO {
	public List<CategoryVO> selectAllCategory() throws SQLException{
		List<CategoryVO> list=new ArrayList<CategoryVO>();
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DbConnection dc=DbConnection.getInstance();
		try {
		con=dc.getConn();
		pstmt=con.prepareStatement("select * from CATEGORT" );
		rs=pstmt.executeQuery();
		while(rs.next()) {
			CategoryVO cVO=new CategoryVO();
			cVO.setMyinfo(rs.getString("myinfo"));
			cVO.setRsv(rs.getString("rsv"));
			list.add(cVO);
		}//end while
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dc.close(rs, pstmt, con);
		}
		return list;
	}//카테고리 전체보기
	public boolean updateNewPw(MemberVO mVO) {
		boolean flag = false;
		DbConnection dc=DbConnection.getInstance();
		String sql = "UPDATE member "
				+ "SET password=? WHERE userid=?"; 

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=dc.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mVO.getPassword());
			pstmt.setString(2, mVO.getUserId());
			

			int i = pstmt.executeUpdate();

			if(i == 1) {
				flag = true;
			} else {
				flag = false;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
		}

		return flag;
	}//비밀번호 변경
	public boolean updateaddr(MemberVO mVO) {
		boolean flag = false;
		DbConnection dc=DbConnection.getInstance();
		String sql = "UPDATE member "
				+ "SET address1=?,address2=? WHERE userid=?"; 

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=dc.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mVO.getAddress1());
			pstmt.setString(2, mVO.getAddress2());
			pstmt.setString(3, mVO.getUserId());
			

			int i = pstmt.executeUpdate();

			if(i == 1) {
				flag = true;
			} else {
				flag = false;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
		}

		return flag;
	}//주소변경
	
	public boolean checkPass(MemberVO mVO) {
		boolean flag=false;
		DbConnection dc=DbConnection.getInstance();
		String sql="select password"
				+"from member where userid=? ";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=dc.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mVO.getAddress1());
			
			int i = pstmt.executeUpdate();
			if(i == 1) {
				flag = true;
			} else {
				flag = false;
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
		}
		
		return flag;
		
	}//비밀번호확인
	
	
}//class
