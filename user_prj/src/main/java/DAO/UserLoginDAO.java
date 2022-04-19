package DAO;

import java.sql.*;


import DbConnection.DbConnection;
import VO.MemberVO;

public class UserLoginDAO {
	public int login(MemberVO mVO) throws SQLException{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstmt =null; 
		DbConnection dc=DbConnection.getInstance();
		StringBuffer query = new StringBuffer();
		query.append("select name").append(" from member ").append("where userid = ? and password=?");
		int flag=0;
		try {
			con = dc.getConn();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, mVO.getUserId());
			pstmt.setString(2, mVO.getPassword());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				flag=1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, con);
		}
		return flag;
	}

}
