<%@page import="DAO.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
			String bd_id=request.getParameter("bd_id");
			BoardDAO bDAO=BoardDAO.getInstance();
			boolean result=bDAO.deleteBoard(Integer.parseInt(bd_id));
			if(result ==true){
				response.sendRedirect("board.jsp");
			}
			%>