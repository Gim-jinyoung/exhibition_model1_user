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

public class UserExhibitionDAO {
private static UserExhibitionDAO umDAO;
	public static UserExhibitionDAO getInstance() {
		if(umDAO==null) {
			umDAO=new UserExhibitionDAO();
		}
		return umDAO;
	}
	
	public List<ExhibitionVO> selectAllExList(String ex_name)throws SQLException{
		List<ExhibitionVO> list=new ArrayList<ExhibitionVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dc=DbConnection.getInstance();
		try {
			con=dc.getConn();
			
			StringBuilder selectAllExList=new StringBuilder();
			
			selectAllExList
			.append("	select ex_num,ex_name,exhibition_poster,ex_intro	")
			.append("	from exhibition	")
			.append("	where ex_name like '").append(ex_name).append("'");
			pstmt=con.prepareStatement(selectAllExList.toString());
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
	
	public List<ExhibitionVO> selectLocalExList(String ex_loc)throws SQLException{
		List<ExhibitionVO> list=new ArrayList<ExhibitionVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dc=DbConnection.getInstance();
		
		try {
			con=dc.getConn();
			StringBuilder selectLocalExList=new StringBuilder();
			selectLocalExList
			.append("	select  ex.ex_num, ex.ex_name, exh.ex_loc	")
			.append("	from    exhibition ex inner join exhibition_hall exh	")
			.append("	on   ex.ex_hall_num = exh.ex_hall_num	")
			.append("	where  exh.ex_loc like '")
			.append(ex_loc).append("'");
			pstmt=con.prepareStatement(selectLocalExList.toString());
			rs=pstmt.executeQuery();
		ExhibitionVO exVO=null;
		while(rs.next()) {
			exVO=new ExhibitionVO();
			exVO.setEx_num(rs.getInt("ex_num"));
			exVO.setEx_name(rs.getString("ex_name"));
			list.add(exVO);
		}
	}finally {
		dc.close(rs, pstmt, con);
	}
		return list;
	}
	public static void main(String[] args) {
		try {
			System.out.println(UserExhibitionDAO.getInstance().selectLocalExList("경기 안산"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
