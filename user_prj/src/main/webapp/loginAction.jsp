<%@page import="VO.MemberVO"%>
<%@page import="DAO.UserLoginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>

<% request.setCharacterEncoding("UTF-8"); %>
<%
request.setCharacterEncoding("UTF-8");
String userId=request.getParameter("userId");
String password=request.getParameter("password");

//String userId, String tel, String zipcode, String address1, String ad dress2, String password,
	//String isSubscribeDate, String name, char isDeleted
MemberVO mVO=new MemberVO(userId,"","","","",password,"","",' ');
UserLoginDAO ulDAO=UserLoginDAO.getInstance();
try{
int result = ulDAO.login( mVO );
if( result == 1 ){
	
 session.setAttribute("mVO",mVO);
System.out.println("로그인--------"+mVO);
 
}


%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Web Site</title>
<script type="text/javascript">

	<%  
		
		
		
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
}catch(Exception e){
	e.printStackTrace();
}
	%>

</script>
</head> 
<body>
</body>
</html>