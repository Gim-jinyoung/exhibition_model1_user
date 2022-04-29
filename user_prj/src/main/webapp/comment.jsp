<%@page import="DAO.BoardDAO"%>
<%@page import="VO.BoardrVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     errorPage="/error.jsp"%>
<%
String desc= request.getParameter("ta");
String userId=(String)session.getAttribute("id");
String bd_id=request.getParameter("bd_id");
if(desc == null){
	%>잘못된 접근입니다. <%
}
if(userId == null){
	userId ="test@test.com";
}
if(bd_id == null){
	%>잘못된 접근입니다. <%
}

BoardrVO bVO=new BoardrVO();
bVO.setCm_description(desc);
bVO.setUserid(userId);
bVO.setBd_id(Integer.parseInt(bd_id));

BoardDAO bDAO=BoardDAO.getInstance();
bDAO.insertComment(bVO);

response.sendRedirect("boardDetail.jsp?value="+bd_id);


%>