package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbConnection.DbConnection;
import VO.MemberVO;
public class IdPassFindDAO {
	public String selectFindId(MemberVO mVO ) throws SQLException {
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstmt =null; 
		DbConnection dc=DbConnection.getInstance();
		String user_id=null;
		String sql="select userid from MEMBER where NAME=? and TEL=?";
		
		try{
			   con=dc.getConn();
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
			   dc.close(rs, pstmt, con);
			  }
			  return user_id;
	}//아이디찾기
	
	public String pw_search(MemberVO mVO) throws SQLException{
		  Connection con=null;
		  ResultSet rs=null;  
		  PreparedStatement pstmt =null; 
		  DbConnection dc=DbConnection.getInstance();
		  String user_pwd=null;//찾을비밀번호
		  String sql="select password from member where NAME=? and USERID=? and TEL=?";
		  
		  try{
		   con=dc.getConn();
		   pstmt=con.prepareStatement(sql); //쿼리
		   pstmt.setString(1, mVO.getName()); //첫번째 ?를 스트링 이름으로 넣음
		   pstmt.setString(2, mVO.getUserId()); //첫번째 ?를 스트링 id로 넣음
		   pstmt.setString(3, mVO.getTel());//두번째 ?에 스트링 pw 넣음
		   
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
		
	
	
	
}//class
	

	 

