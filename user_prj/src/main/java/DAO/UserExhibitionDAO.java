package DAO;

import java.io.Console;
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
import VO.ExhibitionHallVO;
import VO.ExhibitionVO;

public class UserExhibitionDAO {
private static UserExhibitionDAO umDAO;

	private UserExhibitionDAO() {
		
	}
	public static UserExhibitionDAO getInstance() {
		if(umDAO==null) {
			umDAO=new UserExhibitionDAO();
		}
		return umDAO;
	}

	
	public List<ExhibitionVO> selectAllExList(String ex_name)throws SQLException{
		List<ExhibitionVO> list=new ArrayList<ExhibitionVO>();
		
		DbcpConnection dc=new DbcpConnection();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
			
			StringBuilder selectAllExList=new StringBuilder();
			selectAllExList
			.append("	select ex_num, ex_name, exhibition_poster, ex_intro,ex_info,add_img,ex_hall_num,ex_status	")
			.append("	from exhibition	")
			.append("	where ex_name like ? and ex_status like't' ");
			String temp = selectAllExList.toString();
			
			pstmt=con.prepareStatement(selectAllExList.toString());
			pstmt.setString(1, ex_name);
			rs=pstmt.executeQuery();
			ExhibitionVO exVO=null; 
			
			while(rs.next()) {
				exVO=new ExhibitionVO();
				exVO.setEx_num(rs.getInt("ex_num"));
				exVO.setEx_name(rs.getString("ex_name"));
				exVO.setEx_poster(rs.getString("exhibition_poster"));
				exVO.setEx_intro(rs.getString("ex_intro"));				
				exVO.setEx_info(rs.getString("ex_info"));				
				exVO.setAdd_Img(rs.getString("add_img"));				
				exVO.setEx_hall_num(rs.getInt("ex_hall_num"));				
				exVO.setEx_status(rs.getString("ex_status"));				
				list.add(exVO);
			}

		}finally {
			dc.dbClose(rs,pstmt,con);
		}
		return list;
	}

	public List<ExhibitionVO> selectLocalExList(int ex_hall_num)throws SQLException{
		List<ExhibitionVO> list=new ArrayList<ExhibitionVO>();
		
		DbcpConnection dc=new DbcpConnection();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
				
		try {
			con=dc.getConnection();
			StringBuilder selectLocalExList=new StringBuilder();
			
			selectLocalExList
			.append("	select  ex_num, ex_name,ex_hall_num,exhibition_poster,ex_intro	")
			.append("	from    exhibition	")
			.append("	where  ex_hall_num like ?	");
			pstmt=con.prepareStatement(selectLocalExList.toString());
			pstmt.setInt(1, ex_hall_num);
			rs=pstmt.executeQuery();
		ExhibitionVO exVO=null;
		while(rs.next()) {
			exVO=new ExhibitionVO();
			exVO.setEx_num(rs.getInt("ex_num"));
			exVO.setEx_hall_num(rs.getInt("ex_hall_num"));
			exVO.setEx_name(rs.getString("ex_name"));
			exVO.setEx_poster(rs.getString("exhibition_poster"));
			exVO.setEx_intro(rs.getString("ex_intro"));
			list.add(exVO);
		}
	}finally {
		dc.dbClose(rs, pstmt, con);
	}
		return list;
	}
}
