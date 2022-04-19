<%@page import="DAO.UserLoginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %> 
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="mVO" class="VO.MemberVO" scope="page"/> 
<jsp:setProperty name="mVO" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Web Site</title>
<script type="text/javascript">

	<%  
		UserLoginDAO userDAO=new UserLoginDAO();
		int result = userDAO.login( mVO );
		
		if (result == 1){ // 
			%>
			location.href ='index.jsp'; // main 페이지로 사용자를 보냄
			<%
		}else{
			%>
			alert("아이디나비밀번호가 존재하지않습니다.");	
			history.back(); // 이전 페이지로 사용자를 돌려 보냄.
			<%
		}
		
	%>

</script>
</head> 
<body>
</body>
</html>