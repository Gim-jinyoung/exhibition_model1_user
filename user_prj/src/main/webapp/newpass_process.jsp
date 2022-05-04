<%@page import="DAO.IdPassFindDAO"%>
<%@page import="VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
  <script>
<%
request.setCharacterEncoding("UTF-8");
String name=request.getParameter("name");
String userId=(String)session.getAttribute("userId");
String tel=request.getParameter("tel");
String password = request.getParameter("password");
MemberVO mVO=new MemberVO(userId,tel,"","","",password,"",name,' ');

IdPassFindDAO ipfDAO=IdPassFindDAO.getInstance();
String passfind=ipfDAO.pw_search(mVO);



boolean newpass=ipfDAO.updateNewPw(mVO);

//String userId, String tel, String zipcode, String address1, String address2, String password,
//String isSubscribeDate, String name, char isDeleted





%>
 if(<%=newpass  %>){

	location.href ="passclear.jsp";

 }



	 
</script>