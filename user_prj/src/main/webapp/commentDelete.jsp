<%@page import="DAO.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     %>

<%
			String cm_id=request.getParameter("cm_id");
			String bd_id=request.getParameter("bd_id");
			BoardDAO bDAO=BoardDAO.getInstance();
			boolean result=bDAO.deleteComment(Integer.parseInt(cm_id));
			if(result ==true){
				response.sendRedirect("boardDetail.jsp?value="+bd_id);
			}
			%>