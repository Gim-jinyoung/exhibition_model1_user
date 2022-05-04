<%@page import="DAO.IdPassFindDAO"%>
<%@page import="VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html>
 <script>
          

        
<%

request.setCharacterEncoding("UTF-8");
String name=request.getParameter("name");
String userId=request.getParameter("userId");
String tel=request.getParameter("tel");

MemberVO mVO=new MemberVO(userId,tel,"","","","","",name,' ');
IdPassFindDAO ipfDAO=IdPassFindDAO.getInstance();
String passfind=ipfDAO.pw_search(mVO);
if( passfind != null ){
session.setAttribute("userId", userId);
}
//String userId, String tel, String zipcode, String address1, String address2, String password,
//String isSubscribeDate, String name, char isDeleted
%>
if(<%=passfind != null%>){

location.href ="newpass.jsp";

}else{
	alert("잘못된정보입니다.")
	history.back();
}



</script>