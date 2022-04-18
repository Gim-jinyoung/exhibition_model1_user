package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbConnection.DbConnection;
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
	public ExhibitionVO selectExRepresent() throws SQLException{//대표전시
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ExhibitionVO exVO=null;
		
		DbConnection dc=DbConnection.getInstance();
		try {
			con=dc.getConn();
			StringBuilder selectExRepresent=new StringBuilder();
			selectExRepresent
			.append("	select   ex_num, ex_name, exhibition_poster,ex_intro	")
			.append("	from     exhibition	")
			.append("	order by watch_count 	");
			
			pstmt=con.prepareStatement(selectExRepresent.toString());
			rs=pstmt.executeQuery();
		
		while(rs.next()) {
			exVO=new ExhibitionVO();
			exVO.setEx_num(rs.getInt("ex_num"));
			exVO.setEx_name(rs.getString("ex_name"));
		}
		}finally {
			dc.close(rs, pstmt, con);
		}
		return exVO;
	}
	public List<ExhibitionVO> selectExLocAll()throws SQLException{//지역별 지도
		List<ExhibitionVO> list=new ArrayList<ExhibitionVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dc=DbConnection.getInstance();
		
		try {
			con=dc.getConn();
			StringBuilder selectExLocAll=new StringBuilder();
			selectExLocAll
			.append("	select  ex.ex_num, ex.ex_name, exh.ex_hall_num, exh.ex_loc, exh.adress1, exh.adress2	")
			.append("	from    exhibition ex inner join exhibition_hall exh	")
			.append("	on   ex.ex_hall_num = exh.ex_hall_num	");
			
			pstmt=con.prepareStatement(selectExLocAll.toString());
			rs=pstmt.executeQuery();
		ExhibitionVO exVO=null;
		ExhibitionHallVO exhVO=null;
		while(rs.next()) {
			exVO.setEx_num(rs.getInt("ex_num"));
			exVO.setEx_name(rs.getString("ex_name"));
			exVO.setEx_poster(rs.getString("exhibition_poster"));
			exVO.setEx_intro(rs.getString("ex_intro"));
			list.add(exVO);
		}
	}finally {
		dc.close(rs, pstmt, con);
	}
		return list;
	}
	
	public List<ExhibitionVO> viewExList() throws SQLException{//전시리스트
		List<ExhibitionVO> list=new ArrayList<ExhibitionVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dc=DbConnection.getInstance();
		try {
			con=dc.getConn();
			
			StringBuilder viewExList=new StringBuilder();
			
			viewExList
			.append("	select ex_num,ex_name,exhibition_poster,ex_intro	")
			.append("	from exhibition	");
			
			pstmt=con.prepareStatement(viewExList.toString());
			rs=pstmt.executeQuery();
			ExhibitionVO exVO=null; 
			
			while(rs.next()) {
				exVO=new ExhibitionVO();
				exVO.setEx_num(rs.getInt("ex_num"));
				exVO.setEx_name(rs.getString("ex_name"));
				exVO.setEx_poster(rs.getString("exhibition_poster"));
				exVO.setEx_intro(rs.getString("ex_intro"));				
				list.add(exVO);
			}

		}finally {
			dc.close(rs, pstmt, con);
		}
		return list;	
		}

	
	public static void main(String[] args) {
		try {
			System.out.println(UserMainDAO.getInstance().selectExRepresent());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
