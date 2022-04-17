package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbConnection.DbConnection;
import VO.MemberVO;

public class UserMemberDAO {
	

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
	    }//아이디 중복확인
	
	
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

	}//비밀번호찾기
	public void insertMember(MemberVO mVO) {
		int result = 0;
		Connection con=null;
		DbConnection dc=DbConnection.getInstance();
		PreparedStatement pstmt = null;

		String sql;

		

		try {
			con=dc.getConn();
			sql = "insert into member (userid,password,name,address1,address2,tel) ";

			sql+= "values (?,?,?,?,?,?)";

			

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,mVO.getUserId());

			pstmt.setString(2, mVO.getPassword());

			pstmt.setString(3, mVO.getName());

			pstmt.setString(4, mVO.getAddress1());

			pstmt.setString(5, mVO.getAddress2());

			pstmt.setString(6, mVO.getTel());

			result = pstmt.executeUpdate();

			pstmt.close();


		} catch (Exception e) {

			System.out.println(e.toString());

		}

	}//회원가입
}//class

