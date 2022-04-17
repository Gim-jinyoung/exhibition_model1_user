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
	}//���̵�ã��
	
	public String pw_search(String name ,String userid, String tel) throws SQLException{
		  Connection con=null;
		  ResultSet rs=null;  
		  PreparedStatement pstmt =null; 
		  DbConnection dc=DbConnection.getInstance();
		  String user_pwd=null;//ã����й�ȣ
		  String sql="select password from member where NAME=? and USERID=? and TEL=?";
		  
		  try{
		   con=dc.getConn();
		   pstmt=con.prepareStatement(sql); //����
		   pstmt.setString(1, name); //ù��° ?�� ��Ʈ�� id�� ����
		   pstmt.setString(2, userid); //ù��° ?�� ��Ʈ�� id�� ����
		   pstmt.setString(3, tel);//�ι�° ?�� ��Ʈ�� pw ����
		   
		   rs=pstmt.executeQuery();//������ �����ؼ� ������� rs�� ����
		   while(rs.next()){ //rs�� ���������� �ݺ�
		    user_pwd=rs.getString("password"); //cnt�� ��񿡼� ������ cnt�� ����  
		   }
		   System.out.println(user_pwd);
		   

		  }catch(Exception e){
		   System.out.println(e);
		  }finally {
			dc.close(rs, pstmt, con);
		}
		  return user_pwd;
		 }//��й�ȣã�� 
	
	
	
	
}//class
	

	 

