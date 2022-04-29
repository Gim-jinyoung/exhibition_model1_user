<%@page import="DAO.BoardDAO"%>
<%@page import="VO.BoardrVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
      errorPage="/error.jsp"%>
	  <%
	  	BoardDAO bDAO=BoardDAO.getInstance();
		  	BoardrVO bVO=new BoardrVO();
		  String title=request.getParameter("title");
		  String desc=(request.getParameter("ta"));
		  String catNum=request.getParameter("Exhibition");
		  String userId=(String)session.getAttribute("id");
		  if(userId == null){
			  userId="kang@naver.com";
		  }
		  if(title == null){
			  %>잘못된 접근입니다. <%
		  }
		 if(desc == null){
			 %>잘못된 접근입니다. <%
		 }
		  if(catNum == null){
			  %>잘못된 접근입니다. <%
		  }
		  bVO.setTitle(title);
		  bVO.setDescription(desc);
		  bVO.setCat_num(Integer.parseInt(catNum));
		  bVO.setUserid(userId);
	
		  	bDAO.insertBoard(bVO);
		  
		  	response.sendRedirect("board.jsp");
	%>