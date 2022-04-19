package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import DbConnection.DbConnection;
import DbConnection.DbcpConnection;
import VO.BoardrVO;
import VO.CategoryVO;
import VO.ExhibitionHallVO;
import VO.ExhibitionVO;

public class UserExhibitionDetailDAO {
private static UserExhibitionDetailDAO uehdDAO;

	public UserExhibitionDetailDAO() {
	
	}

	
	public static UserExhibitionDetailDAO getInstance() {
		if(uehdDAO==null) {
			uehdDAO=new UserExhibitionDetailDAO();
		}
		return uehdDAO;
	}
	

	public ExhibitionVO selectExhibition(int ex_num)throws SQLException{		
		DbcpConnection dc=new DbcpConnection();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ExhibitionVO exVO=null;
		
		try {
			con=dc.getConnection();
			
			StringBuilder selectExhibition=new StringBuilder();
			
			selectExhibition
			.append("	select ex_num, ex_name,exhibition_poster,ex_intro,ex_info,ex.add_img	")
			.append("	from exhibition	")
			.append(" 	where ex_num like '").append(ex_num).append("'");
			pstmt=con.prepareStatement(selectExhibition.toString());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				exVO=new ExhibitionVO();
				exVO.setEx_num(rs.getInt("ex_num"));
				exVO.setEx_name(rs.getString("ex_name"));
				exVO.setEx_poster(rs.getString("exhibition_poster"));
				exVO.setEx_intro(rs.getString("ex_intro"));				
				exVO.setEx_info(rs.getString("ex_info"));				
				exVO.setAdd_Img(rs.getString("add_img"));	
			}

		}finally {
			dc.dbClose(rs, pstmt, con);
		}
		return exVO;
	}
	
	public List<BoardrVO> selectRelBoard(int ex_num)throws SQLException{
		List<BoardrVO> list=new ArrayList<BoardrVO>();
		DbcpConnection dc=new DbcpConnection();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		try {
			con=dc.getConnection();
			
			StringBuilder selectRelBoard=new StringBuilder();
			
			selectRelBoard
			.append("	select e.ex_num,b.bd_id, c.cat_num, b.title,b.userid,b.input_date,views,c.cat_name	")
			.append("	from BOARD b,CATEGORY c,exhibition e,reservation r	")
			.append("	where b.userid=r.userid	and r.ex_num=e.ex_num	and b.cat_num=c.cat_num	and e.ex_num=").append(ex_num);
			
			pstmt=con.prepareStatement(selectRelBoard.toString());
			rs=pstmt.executeQuery();
			BoardrVO boVO=null;
		while(rs.next()) {
			boVO=new BoardrVO();
			boVO.setBd_id(rs.getInt("bd_id"));
			boVO.setTitle(rs.getString("title"));
			boVO.setUserid(rs.getString("userid"));
			boVO.setViews(rs.getInt("views"));
			boVO.setCat_name(rs.getString("cat_name"));
			list.add(boVO);
		}
	}finally {
		dc.dbClose(rs, pstmt, con);
	}
		return list;
	}
	
	public ExhibitionHallVO mapSelect(ExhibitionHallVO exhVO)throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DbConnection dc=DbConnection.getInstance();
		
		try {
			con=dc.getConn();
			StringBuilder mapSelect=new StringBuilder();
			
			mapSelect
			.append(" 	select EX_LOC ,EX_NAME, ADRESS1 ,ADRESS2 	")
			.append("	from EXHIBITION_HALL	")
			.append("	where ex_hall_num like=?	");
			
			pstmt=con.prepareStatement(mapSelect.toString());
			pstmt.setInt(1, exhVO.getEx_hall_num());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				exhVO=new ExhibitionHallVO();
				exhVO.setEx_loc(rs.getString("ex_loc"));
				exhVO.setEx_name(rs.getString("ex_name"));
				exhVO.setAdress1(rs.getString("adress1"));
				exhVO.setAdress2(rs.getString("adress2"));
			}
		}finally {
			dc.close(rs, pstmt, con);
		}
		return exhVO;
	}

}
