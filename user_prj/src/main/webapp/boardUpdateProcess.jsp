<%@page import="DAO.BoardDAO"%>
<%@page import="VO.BoardrVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="/error.jsp"
  %>
<%
BoardDAO bDAO=BoardDAO.getInstance();
	BoardrVO bVO=new BoardrVO();
	String bd_id=request.getParameter("hid");
String title=request.getParameter("title");
String desc=(request.getParameter("ta"));
String catNum=request.getParameter("Exhibition");
String userId=(String)session.getAttribute("id");
System.out.println("-----"+bd_id);
		 if(userId == null){
			  userId="kang@naver.com";
		  }
		 
			bVO.setTitle(title);
			bVO.setDescription(desc);
			bVO.setCat_num(Integer.parseInt(catNum));
			bVO.setBd_id(Integer.parseInt(bd_id));
			bVO.setUserid(userId);
			boolean result=bDAO.updateBoard(bVO);
			
			if(result){
			response.sendRedirect("boardDetail.jsp?value="+bd_id);
			}
		%>