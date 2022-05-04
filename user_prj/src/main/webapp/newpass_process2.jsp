<%@page import="DAO.MyinfoDAO"%>
<%@page import="DAO.IdPassFindDAO"%>
<%@page import="VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
  <script>
<%
request.setCharacterEncoding("UTF-8");
String userId=((MemberVO)session.getAttribute("mVO")).getUserId();
String password = request.getParameter("password");
MemberVO mVO=new MemberVO(userId,"","","","",password,"","",' ');

MyinfoDAO miDAO=MyinfoDAO.getInstance();
boolean passfind=miDAO.updateNewPw(mVO);

System.out.print(session.getAttribute("mVO"));


//String userId, String tel, String zipcode, String address1, String address2, String password,
//String isSubscribeDate, String name, char isDeleted





%>
 if(<%=passfind  %>){

	location.href ="passclear.jsp";

 }



	 
</script>