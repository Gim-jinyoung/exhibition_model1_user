<%@page import="org.json.simple.JSONObject"%>
<%@page import="VO.MemberVO"%>
<%@page import="DAO.UserMemberDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    
    %>
<%
request.setCharacterEncoding("UTF-8");

String userId = request.getParameter("userId");

MemberVO mVO=new MemberVO(userId,"","","","","","","",' ');
UserMemberDAO umDAO=UserMemberDAO.getInstance();
int idCheck = umDAO.selectCheckID(mVO);
//체크용
/* if(idCheck==0){
	System.out.println("이미존재하는아이디");
} else if(idCheck==1){
	System.out.println("사용 가능한 아이디");
} */

JSONObject jsonObj=new JSONObject();
jsonObj.put("resultFlag", idCheck);
out.print(jsonObj.toJSONString());
%>