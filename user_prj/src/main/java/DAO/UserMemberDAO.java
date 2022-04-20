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
		
		//1.JNDI사용객체 생성
		Context ctx=new InitialContext();
		//2.DBCP를찾아 DataSource 얻기
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dbcp");
		//3.커넥션 얻기
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
	public void insertMember(MemberVO mVO)throws SQLException, NamingException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		String sql;

		//어디서 어떤게 안돼요?

		try {
			con=getConnect();
			sql = "insert into member (userid,tel,password,name,address1,address2,zipcode) ";

			sql+= "values (?,?,?,?,?,?,?)"; //? (바인드변수) 몇개?5개입니다
			
			

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,mVO.getUserId());

			pstmt.setString(2, mVO.getPassword());

			pstmt.setString(3, mVO.getName());

			pstmt.setString(4, mVO.getAddress1());

			pstmt.setString(5, mVO.getAddress2());

			pstmt.setString(6, mVO.getTel()); //값을 몇개넣었어요?6개입니다.
			
			pstmt.setString(7, mVO.getZipcode()); //값을 몇개넣었어요?6개입니다.

			pstmt.executeUpdate();

			pstmt.close();


		}finally {
			//7.연결끊기
				dbClose(rs, pstmt, con);
			}

}//회원가입
	public void dbClose(ResultSet rs,PreparedStatement pstmt,Connection con)throws SQLException {
		if(rs !=null) {rs.close();}
		if(pstmt !=null) {pstmt.close();}
		if(con !=null) {con.close();}
	}//dbClose

}//class

