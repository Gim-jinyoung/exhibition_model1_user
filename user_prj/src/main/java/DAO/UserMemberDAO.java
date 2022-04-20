package DAO;

import java.awt.dnd.DnDConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import DbConnection.DbConnection;
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

	public int selectCheckID(String userId) throws SQLException {
			Connection con =null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        StringBuffer sql = null;
	        int retVal = 0;
	        
	        DbConnection dc=DbConnection.getInstance();
	        try{
	            sql = new StringBuffer();
	            sql.append(" SELECT COUNT(userid) as cnt");
	            sql.append(" FROM " + "member");
	            sql.append(" WHERE userid = ?");
	           
	            pstmt = con.prepareStatement(sql.toString());
	           
	            pstmt.setString(1, userId); 
	           
	            rs = pstmt.executeQuery(); 
	           
	            if ( rs.next() == true ) { 
	                retVal = rs.getInt("cnt");
	            }           
	        }catch(Exception e){
	            System.out.println(e.toString());
	        }finally{
	          dc.close(rs, pstmt, con);
	        }
	       
	        return retVal;
	    }//���̵� �ߺ�Ȯ��
	
	
	public MemberVO selectCheckPass(String password)  throws SQLException {
		String sql = "select * from member where password=? ";
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberVO mVo=null;
        DbConnection dc=DbConnection.getInstance();
        
        
        try{
        	con=dc.getConn();
            pstmt = con.prepareStatement(sql);
           
            pstmt.setString(1, password);
           
           
            rs = pstmt.executeQuery();
           
            if(rs.next()){
                mVo = new MemberVO();
               
                mVo.setPassword(rs.getString("password"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
         dc.close(rs, pstmt, con);
        }
        return mVo;//

	}//��й�ȣã��
	public void insertMember(MemberVO mVO)throws SQLException, NamingException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		String sql;

		//��� ��� �ȵſ�?

		try {
			con=getConnect();
			sql = "insert into member (userid,tel,password,name,address1,address2,zipcode) ";

			sql+= "values (?,?,?,?,?,?,?)"; //? (���ε庯��) �?5���Դϴ�
			
			

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,mVO.getUserId());

			pstmt.setString(2, mVO.getPassword());

			pstmt.setString(3, mVO.getName());

			pstmt.setString(4, mVO.getAddress1());

			pstmt.setString(5, mVO.getAddress2());

			pstmt.setString(6, mVO.getTel()); //���� ��־����?6���Դϴ�.
			
			pstmt.setString(7, mVO.getZipcode()); //���� ��־����?6���Դϴ�.

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

