package DbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	private static DbConnection dc;
	/**
	 * 클래스 외부에서 객체화하는 것을 막는다
	 */
	private DbConnection() {
		
	}
	/**
	 * DbConnection 객체를 반환하는 일 
	 * @return
	 */
	public static DbConnection getInstance() {
		
		if(dc==null) {
			dc=new DbConnection();
			
		}
		
		return dc;
	}
	/**
	 * Connection을 얻는 일
	 * @return
	 */
	public Connection getConn() throws SQLException{
		Connection con=null;
		//1. 드라이버 로딩
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		//2.커넥션 얻기
		String url="jdbc:oracle:thin:@211.63.89.133:1521:orcl";
		String id="exhibition";
		String pass="three";
		
		con=DriverManager.getConnection(url,id,pass);
		return con;
	}
	public Statement getStatement() throws SQLException {
		Statement stmt=null;
		stmt=getConn().createStatement();
		return stmt;
	}
	
	/**
	 * DBMS연결종료
	 * @param rs
	 * @param stmt
	 * @param con
	 * @throws SQLException
	 */
	public void close(ResultSet rs,Statement stmt,Connection con)throws SQLException{
		if(rs!=null) {rs.close();}
		if(stmt!=null) {stmt.close();}
		if(con!=null) {con.close();}
	}
}