<%@page import="DAO.MyinfoDAO"%>
<%@page import="VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<script>
<%
request.setCharacterEncoding("UTF-8");
String userId=request.getParameter("userId");
String address1=request.getParameter("address1");
String address2=request.getParameter("address2");
String name=request.getParameter("name");

MemberVO mVO=new MemberVO(userId,"","",address1,address2,"","",name,' ');
//String userId, String tel, String zipcode, String address1, String ad dress2, String password,
	//String isSubscribeDate, String name, char isDeleted
MyinfoDAO miDAO=MyinfoDAO.getInstance();
System.out.print("주소변경"+mVO);
boolean newadd=miDAO.updateaddr(mVO);
%>

if(<%=newadd  %>){

	location.href ="my_account_modify_success.jsp";

 }





</script>