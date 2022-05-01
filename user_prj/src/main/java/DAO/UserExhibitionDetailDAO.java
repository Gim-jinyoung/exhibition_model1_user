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
	

	public List<ExhibitionVO> selectExhibition(int ex_num)throws SQLException{
		List<ExhibitionVO> list=new ArrayList<ExhibitionVO>();
		DbcpConnection dc=new DbcpConnection();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		try {
			con=dc.getConnection();
			
			StringBuilder selectExhibition=new StringBuilder();
			
			selectExhibition
			.append("	select ex_num, ex_name,exhibition_poster,ex_intro,ex_info,add_img, ex_hall_num	")
			.append("	from exhibition	")
			.append(" 	where ex_num like ?	");
			pstmt=con.prepareStatement(selectExhibition.toString());
			pstmt.setInt(1, ex_num);
			rs=pstmt.executeQuery();
			
			ExhibitionVO exVO=null;
			while(rs.next()) {
				exVO=new ExhibitionVO();
				exVO.setEx_num(rs.getInt("ex_num"));
				exVO.setEx_hall_num(rs.getInt("ex_hall_num"));
				exVO.setEx_name(rs.getString("ex_name"));
				exVO.setEx_poster(rs.getString("exhibition_poster"));
				exVO.setEx_intro(rs.getString("ex_intro"));				
				exVO.setEx_info(rs.getString("ex_info"));				
				exVO.setAdd_Img(rs.getString("add_img"));	
				list.add(exVO);
			}

		}finally {
			dc.dbClose(rs, pstmt, con);
		}
		return list;
	}
	
	public List<BoardrVO> selectRelBoard(int cat_num)throws SQLException{
		List<BoardrVO> list=new ArrayList<BoardrVO>();
		
		DbcpConnection dc=new DbcpConnection();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		try {
			con=dc.getConnection();
			
			StringBuilder selectRelBoard=new StringBuilder();
			
			selectRelBoard
			.append("	select bd_id,title,recommend,views,input_date,userid,cat_num 	")
			.append("	from board	 ")
			.append("	where cat_num=? 	")
			.append("	order by bd_id desc 	");
			
			
			pstmt=con.prepareStatement(selectRelBoard.toString());
			pstmt.setInt(1, cat_num);
			rs=pstmt.executeQuery();
			BoardrVO boVO=null;
			
		while(rs.next()) {
			boVO=new BoardrVO();
			boVO.setCat_num(rs.getInt("cat_num"));
			boVO.setBd_id(rs.getInt("bd_id"));
			boVO.setTitle(rs.getString("title"));
			boVO.setUserid(rs.getString("userid"));
			boVO.setInput_date(rs.getString("input_date"));
			boVO.setRecommend(rs.getInt("recommend"));
			boVO.setViews(rs.getInt("views"));
			
			list.add(boVO);
		}
	}finally {
		dc.dbClose(rs, pstmt, con);
	}
		return list;
	}
	
	public List<ExhibitionHallVO> mapSelect(int ex_num)throws SQLException{
		List<ExhibitionHallVO> list=new ArrayList<ExhibitionHallVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DbConnection dc=DbConnection.getInstance();
		
		try {
			con=dc.getConn();
			StringBuilder mapSelect=new StringBuilder();
			
			mapSelect
			.append(" 	select ex_hall_name, ex_hall_num, longitude, latitude	")
			.append("	from EXHIBITION_HALL	")
			.append("	where ex_hall_num like ?	");
			
			pstmt=con.prepareStatement(mapSelect.toString());
			pstmt.setInt(1, ex_num);
			rs=pstmt.executeQuery();
			ExhibitionHallVO exhVO=null;
			while(rs.next()) {
				exhVO=new ExhibitionHallVO();
				exhVO.setEx_hall_num(rs.getInt("ex_hall_num"));
				exhVO.setEx_name(rs.getString("ex_hall_name"));
				exhVO.setLongitude(rs.getDouble("longitude"));
				exhVO.setLatitude(rs.getDouble("latitude"));
				list.add(exhVO);
			}
		}finally {
			dc.close(rs, pstmt, con);
		}
		return list;
	}
}
