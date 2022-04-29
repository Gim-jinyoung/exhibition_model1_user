package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import VO.MemberVO;
public class IdPassFindDAO {
	private static IdPassFindDAO ipfDAO;
	private IdPassFindDAO() {}
	public static IdPassFindDAO getInstance() {
		if(ipfDAO==null) {
			ipfDAO=new IdPassFindDAO();
		}
		return ipfDAO;
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

	public String selectFindId(MemberVO mVO ) throws SQLException {

		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstmt =null; 
		
		String user_id=null;
		String sql="select userid from member where name=? and tel=?";
		
		try{
			   con=getConnect();
			   pstmt=con.prepareStatement(sql);
			   pstmt.setString(1, mVO.getName()); 
			   pstmt.setString(2, mVO.getTel()); 
			   
			   rs=pstmt.executeQuery(); 
			   
			   while(rs.next()){ 
			    user_id=rs.getString("userid");  
			   }

			  }catch(Exception e){
			   System.out.println(e);
			  }finally{
				  	dbClose(rs, pstmt, con);
				  	
			  }
			  return user_id;
	}//아이디찾기
	
	public String pw_search(MemberVO mVO) throws SQLException{
		  Connection con=null;
		  ResultSet rs=null;  
		  PreparedStatement pstmt =null; 
			/* DbConnection dc=DbConnection.getInstance(); */
		  String user_pwd=null;//찾을비밀번호
		  String sql="select password from member where name=? and userid=? and tel=?";
		  
		  try{
		   con=getConnect();
		   pstmt=con.prepareStatement(sql);
		   pstmt.setString(1, mVO.getName()); 
		   pstmt.setString(2, mVO.getUserId()); 
		   pstmt.setString(3, mVO.getTel());
		   
		   rs=pstmt.executeQuery();
		   while(rs.next()){
		    user_pwd=rs.getString("password");   
		   }
		   System.out.println(user_pwd);
		   

		  }catch(Exception e){
		   System.out.println(e);
		  }finally {
			dbClose(rs, pstmt, con);
		}
		  return user_pwd;
		 }//비밀번호찾기 
	
	
		public boolean updateNewPw(MemberVO mVO) throws SQLException {
			boolean flag=false;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs=null;  
			String user_pwd=null;//바꿀비밀번호
			
			String sql = "update member set password=? where userid=?"; 

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
			dbClose(null, pstmt, con);
			}
			return flag;
			
		}//비밀번호 변경
		
		public void dbClose(ResultSet rs,PreparedStatement pstmt,Connection con)throws SQLException {
			if(rs !=null) {rs.close();}
			if(pstmt !=null) {pstmt.close();}
			if(con !=null) {con.close();}
		}//dbClose

		
	
}//class
	

	 

