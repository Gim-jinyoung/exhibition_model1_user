package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import DbConnection.DbConnection;
import VO.CategoryVO;
import VO.MemberVO;


public class MyinfoDAO {
	private static MyinfoDAO miDAO;
	private MyinfoDAO() {}
	public static MyinfoDAO  getInstance() {
		if(miDAO==null) {
			miDAO=new MyinfoDAO();
		}
		return miDAO;
	}
	private Connection getConnect() throws SQLException,NamingException{
		Connection con=null;
		
		//1.JNDI사용객체 생성
		Context ctx=new InitialContext();
		//2.DBCP를찾아 DataSource 얻기
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dbcp");
		//3.커넥션 얻기
		con=ds.getConnection();
		return con;
	}//getConnection
	
	public MemberVO selectMember(MemberVO mVO) throws SQLException{
		
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
		try {
		con=getConnect();
		pstmt=con.prepareStatement("select * from member where userid=?" );
		pstmt.setString(1, mVO.getUserId());
		rs=pstmt.executeQuery();
		if(rs.next()) {
			
			mVO.setUserId(rs.getString("userId"));
			mVO.setName(rs.getString("name"));
			mVO.setTel(rs.getString("tel"));
			mVO.setAddress1(rs.getString("address1"));
			mVO.setAddress2(rs.getString("address2"));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(rs, pstmt, con);
		}
		return mVO;
	}//회원내정보
	
	public boolean updateNewPw(MemberVO mVO) {
		boolean flag = false;
		
		String sql = "UPDATE member "
				+ "SET password=? WHERE userid=?"; 

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=getConnect();
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
	
	public boolean updateaddr(MemberVO mVO) throws SQLException {
		boolean flag = false;
		
		String sql = "update member set name=?,address1=?,address2=? where userid=?"; 

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=getConnect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mVO.getName());
			pstmt.setString(2, mVO.getAddress1());
			pstmt.setString(3, mVO.getAddress2());
			pstmt.setString(4, mVO.getUserId());
			

			int i = pstmt.executeUpdate();

			if(i == 1) {
				flag = true;
			} else {
				flag = false;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		dbClose(null, pstmt, con);
		}

		return flag;
	}//주소변경
	
	public int checkPass(MemberVO mVO) throws SQLException {
		int flag=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs=null;  
		String sql="select *"
				+"from member where password=?";
		try {
			con=getConnect();
			pstmt = con.prepareStatement(sql);
			/* pstmt.setString(1, mVO.getUserId()); */
			pstmt.setString(1, mVO.getPassword());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				mVO.setUserId(rs.getString("userId"));
				mVO.setAddress1(rs.getString("address1"));
				mVO.setAddress2(rs.getString("address2"));
				mVO.setName(rs.getString("name"));
				mVO.setTel(rs.getString("tel"));
				flag=1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(rs, pstmt, con);
		}
		
		return flag;
		
	}//비밀번호확인
	
	public void dbClose(ResultSet rs,PreparedStatement pstmt,Connection con)throws SQLException {
		if(rs !=null) {rs.close();}
		if(pstmt !=null) {pstmt.close();}
		if(con !=null) {con.close();}
	}//dbClose

	
	
}//class
