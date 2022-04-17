package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbConnection.DbConnection;
public class IdPassFindDAO {
	public String selectFindId(String name,String tel ) throws SQLException {
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstmt =null; 
		DbConnection dc=DbConnection.getInstance();
		String user_id=null;
		String sql="select userid from MEMBER where NAME=? and TEL=?";
		
		try{
			   pstmt=con.prepareStatement(sql);
			   pstmt.setString(1, name); 
			   pstmt.setString(2, tel); 
			   
			   rs=pstmt.executeQuery(); 
			   while(rs.next()){ 
			    user_id=rs.getString("userid");  
			   }

			  }catch(Exception e){
			   System.out.println(e);
			  }finally{
			   dc.close(rs, pstmt, con);
			  }
			  return user_id;
	}//아이디찾기
	
	public String pw_search(String name ,String userid, String tel) throws SQLException{
		  Connection con=null;
		  ResultSet rs=null;  
		  PreparedStatement pstmt =null; 
		  DbConnection dc=DbConnection.getInstance();
		  String user_pwd=null;//찾을비밀번호
		  String sql="select password from member where NAME=? and USERID=? and TEL=?";
		  
		  try{
		   con=dc.getConn();
		   pstmt=con.prepareStatement(sql); //쿼리
		   pstmt.setString(1, name); //첫번째 ?를 스트링 id로 넣음
		   pstmt.setString(2, userid); //첫번째 ?를 스트링 id로 넣음
		   pstmt.setString(3, tel);//두번째 ?에 스트링 pw 넣음
		   
		   rs=pstmt.executeQuery();//쿼리를 실행해서 결과값을 rs로 저장
		   while(rs.next()){ //rs가 끝날때까지 반복
		    user_pwd=rs.getString("password"); //cnt를 디비에서 가져온 cnt에 저장  
		   }
		   System.out.println(user_pwd);
		   

		  }catch(Exception e){
		   System.out.println(e);
		  }finally {
			dc.close(rs, pstmt, con);
		}
		  return user_pwd;
		 }//비밀번호찾기 
	
	
	
	
}//class
	

	 

