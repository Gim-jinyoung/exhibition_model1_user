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

public class UserMemberDAO {
	private static UserMemberDAO umDAO;
	private UserMemberDAO() {}
	public static UserMemberDAO getInstance() {
		
		if(umDAO==null) {
			umDAO=new UserMemberDAO();
		}
		return umDAO;
	}
	private Connection getConnect() throws SQLException,NamingException{
		Connection con=null;
		
		//1.JNDI��밴ü ����
		Context ctx=new InitialContext();
		//2.DBCP��ã�� DataSource ���
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dbcp");
		//3.Ŀ�ؼ� ���
		con=ds.getConnection();
		return con;
	}//getConnection

	public int selectCheckID(MemberVO mVO) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from member where userid=?";
	    int retVal = 0;
	        
	        
	        try{
	           con=getConnect();
	           
	            pstmt = con.prepareStatement(sql);
	           
	            pstmt.setString(1, mVO.getUserId()); 
	           
	            rs = pstmt.executeQuery(); 
	           
	            if ( rs.next() ==mVO.getUserId().equals("")) { 
	               retVal=1;
	            }else {
	            	retVal=0;
	            }
	        }catch(Exception e){
	            System.out.println(e.toString());
	        }finally{
	         dbClose(rs, pstmt, con);
	        }
	       
	        return retVal;
	    }//���̵� �ߺ�Ȯ��
	
	
		/*
		 * public MemberVO selectCheckPass(String password) throws SQLException { String
		 * sql = "select * from member where password=? "; Connection con = null;
		 * PreparedStatement pstmt = null; ResultSet rs = null; MemberVO mVo=null;
		 * 
		 * 
		 * 
		 * try{ con=dc.getConn(); pstmt = con.prepareStatement(sql);
		 * 
		 * pstmt.setString(1, password);
		 * 
		 * 
		 * rs = pstmt.executeQuery();
		 * 
		 * if(rs.next()){ mVo = new MemberVO();
		 * 
		 * mVo.setPassword(rs.getString("password"));
		 * 
		 * } }catch(Exception e){ e.printStackTrace(); }finally{ dc.close(rs, pstmt,
		 * con); } return mVo;//
		 * 
		 * }//��й�ȣã��
		 */	
		public void insertMember(MemberVO mVO)throws SQLException, NamingException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		String sql;

		//��� ��� �ȵſ�?

		try {
			con=getConnect();
			sql = "insert into member (userid,tel,password,name,address1,address2,zipcode) ";

			sql+= "values (?,?,?,?,?,?,?)"; 
			
			

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,mVO.getUserId());

			pstmt.setString(2, mVO.getTel());

			pstmt.setString(3, mVO.getPassword());

			pstmt.setString(4, mVO.getName());

			pstmt.setString(5, mVO.getAddress1());

			pstmt.setString(6, mVO.getAddress2()); 
			
			pstmt.setString(7, mVO.getZipcode()); 

			pstmt.executeUpdate();

			pstmt.close();


		}finally {
			//7.�������
				dbClose(rs, pstmt, con);
			}

}//ȸ������
	public void dbClose(ResultSet rs,PreparedStatement pstmt,Connection con)throws SQLException {
		if(rs !=null) {rs.close();}
		if(pstmt !=null) {pstmt.close();}
		if(con !=null) {con.close();}
	}//dbClose

}//class

