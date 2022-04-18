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
		query.append("SELECT password").append(" FROM member").append(" WHERE userid = ?");
		try {
			con = dc.getConn();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, mVO.getUserId());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if(rs.getString("password").equals(mVO.getPassword())) {
					return 1;
				} else {
					return 0;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, con);
		}
		return -1;
	}

}
