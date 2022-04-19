package DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbcpConnection {
	
	public Connection getConnection() throws SQLException  {
		Connection con=null;
		
		try {
		//1.JNDI 사용객체 생성
		Context ctx=new InitialContext();
		//2.DBCP를 찾아 DataSource 얻기
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dbcp");
		//3.커넥션 얻기
		con=ds.getConnection();
		}catch (NamingException ne) {
			ne.printStackTrace();
		}
		return con;
	}//getConnection
	
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException{
		if(rs != null) {rs.close();} //end if
		if(pstmt != null) {pstmt.close();} //end if
		if(con != null) {con.close();} //end if
	}//dbClose
}
