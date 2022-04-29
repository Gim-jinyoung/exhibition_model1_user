package DAO;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import DbConnection.DbConnection;
import VO.MemberVO;

public class UserLoginDAO {
	private static UserLoginDAO ulDAO;
	private UserLoginDAO() {}
	public static UserLoginDAO getInstance() {
		if(ulDAO==null) {
			ulDAO=new UserLoginDAO();
		}//end if
		return ulDAO;
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
	
	
	public int login(MemberVO mVO) throws SQLException ,NamingException{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstmt =null; 
		
		StringBuffer query = new StringBuffer();
		query.append("select *").append(" from member ").append("where userId = ? and password=?");
		int flag=0;
		try {
			con = getConnect();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, mVO.getUserId());
			pstmt.setString(2, mVO.getPassword());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				mVO.setAddress1(rs.getString("address1"));
				mVO.setAddress2(rs.getString("address2"));
				mVO.setName(rs.getString("name"));
				mVO.setTel(rs.getString("tel"));
				//
				flag=1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose(rs, pstmt, con);
		}
		return flag;
	}
	public void dbClose(ResultSet rs,PreparedStatement pstmt,Connection con)throws SQLException {
		if(rs !=null) {rs.close();}
		if(pstmt !=null) {pstmt.close();}
		if(con !=null) {con.close();}
	}//dbClose

}
