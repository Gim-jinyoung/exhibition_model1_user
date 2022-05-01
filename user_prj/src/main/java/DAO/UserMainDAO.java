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
import VO.ExhibitionHallVO;
import VO.ExhibitionVO;

public class UserMainDAO {
	private static UserMainDAO uehDAO;
	
	public UserMainDAO(){

	}
	
	public static UserMainDAO getInstance() {
		if(uehDAO==null) {
			uehDAO=new UserMainDAO();
		}
		return uehDAO;
	}
	

	public List<ExhibitionVO> selectExRepresent() throws SQLException{//대표전시
		DbcpConnection dc=new DbcpConnection();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ExhibitionVO exVO=null;
		List<ExhibitionVO> exVOList=null;
		
		try {
			con=dc.getConnection();
			
			StringBuilder selectExRepresent=new StringBuilder();
			selectExRepresent
			.append("	select *	")
			.append("	from(select row_number() over( order by watch_count desc)as rank,ex_num, ex_name, exhibition_poster, ex_intro, watch_count from exhibition)")
			.append("	where rank like 1	");
			
			pstmt=con.prepareStatement(selectExRepresent.toString());
			rs=pstmt.executeQuery();
		
			exVOList=new ArrayList<ExhibitionVO>();
		while(rs.next()) {
			exVO=new ExhibitionVO();
			exVO.setEx_num(rs.getInt("ex_num"));
			exVO.setEx_name(rs.getString("ex_name"));
			exVO.setEx_intro(rs.getString("ex_intro"));
			exVO.setEx_poster(rs.getString("exhibition_poster"));
			exVOList.add(exVO);
		}
		}finally {
			dc.dbClose(rs, pstmt, con);
		}
		return exVOList;
	}
	public List<ExhibitionHallVO> selectExLocAll()throws SQLException{//지역별 지도
		List<ExhibitionHallVO> list=new ArrayList<ExhibitionHallVO>();
		DbcpConnection dc=new DbcpConnection();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		try {
			con=dc.getConnection();
			StringBuilder selectExLocAll=new StringBuilder();
			selectExLocAll
			.append("	select  ex_hall_name, ex_hall_num, longitude, latitude	")
			.append("	from  exhibition_hall	");
			
			pstmt=con.prepareStatement(selectExLocAll.toString());
			rs=pstmt.executeQuery();
			
		ExhibitionHallVO exhVO=null;
		while(rs.next()) {
			exhVO=new ExhibitionHallVO();
			exhVO.setEx_name(rs.getString("ex_hall_name"));
			exhVO.setEx_hall_num(rs.getInt("ex_hall_num"));
			exhVO.setLongitude(rs.getDouble("longitude"));
			exhVO.setLatitude(rs.getDouble("latitude"));
			list.add(exhVO);
		}
	}finally {
		dc.dbClose(rs, pstmt, con);
	}
		
		return list;
	}
	
	public List<ExhibitionVO> viewExList() throws SQLException{//전시리스트
		List<ExhibitionVO> list=new ArrayList<ExhibitionVO>();
		DbcpConnection dc=new DbcpConnection();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dc.getConnection();
			
			StringBuilder viewExList=new StringBuilder();
			
			viewExList
			.append("	select ex_num,ex_name,exhibition_poster,ex_intro,ex_hall_num, ex_status	")
			.append("	from exhibition	")
			.append("	where ex_status like 't' ")
			.append("	order by watch_count ");
			
			pstmt=con.prepareStatement(viewExList.toString());
			rs=pstmt.executeQuery();
			ExhibitionVO exVO=null; 
			
			while(rs.next()) {
				exVO=new ExhibitionVO();
				exVO.setEx_num(rs.getInt("ex_num"));
				exVO.setEx_hall_num(rs.getInt("ex_hall_num"));
				exVO.setEx_name(rs.getString("ex_name"));
				exVO.setEx_poster(rs.getString("exhibition_poster"));
				exVO.setEx_intro(rs.getString("ex_intro"));				
				exVO.setEx_status(rs.getString("ex_status"));				
				list.add(exVO);
			}

		}finally {
			dc.dbClose(rs, pstmt, con);
		}
		return list;	
		}

}
