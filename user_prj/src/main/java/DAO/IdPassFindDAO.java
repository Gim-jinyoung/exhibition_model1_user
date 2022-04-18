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
	}//���̵�ã��
	
	public String pw_search(MemberVO mVO) throws SQLException{
		  Connection con=null;
		  ResultSet rs=null;  
		  PreparedStatement pstmt =null; 
		  DbConnection dc=DbConnection.getInstance();
		  String user_pwd=null;//ã����й�ȣ
		  String sql="select password from member where NAME=? and USERID=? and TEL=?";
		  
		  try{
		   con=dc.getConn();
		   pstmt=con.prepareStatement(sql); //����
		   pstmt.setString(1, mVO.getName()); //ù��° ?�� ��Ʈ�� �̸����� ����
		   pstmt.setString(2, mVO.getUserId()); //ù��° ?�� ��Ʈ�� id�� ����
		   pstmt.setString(3, mVO.getTel());//�ι�° ?�� ��Ʈ�� pw ����
		   
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
		}//��й�ȣ ����
		
	
	
	
}//class
	

	 

