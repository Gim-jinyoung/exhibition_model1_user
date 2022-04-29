<%@page import="DAO.MyinfoDAO"%>
<%@page import="VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
request.setCharacterEncoding("UTF-8");

String userId=request.getParameter("userId");
String name=(String)session.getAttribute("name");
String tel=(String)session.getAttribute("tel");
String address1=(String)session.getAttribute("address1");
String address2=(String)session.getAttribute("address2");


String password=request.getParameter("password");
MemberVO mVO=new MemberVO(userId,tel,"",address1,address2,password,"",name,' ');
//String userId, String tel, String zipcode, String address1, String ad dress2, String password,
	//String isSubscribeDate, String name, char isDeleted
MyinfoDAO miDAO=MyinfoDAO.getInstance();



session.getAttribute("mVO");


int result =miDAO.checkPass(mVO);

%>
	<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Web Site</title>
<script type="text/javascript">

	<%  
		
		
		
		if (result==1){ // 
			%>
		<%
			session.setAttribute("mVO",mVO);
			%>
			location.href ="http://localhost/user_prj/my-account_rez.jsp"; // 비밀번호가맞을때 내정보로 보냄
			<%
			/* session.setAttribute("userId",userId);
			session.setAttribute("password",password);
			session.setAttribute("userId", userId);
			session.setAttribute("password", password);
			session.setAttribute("name",name);
			session.setAttribute("tel",tel);
			session.setAttribute("address1",address1);
			session.setAttribute("address2",address2);  */
			%>
			<%
		}else{
			
			%>
			alert("비밀번호가틀립니다.");	
			history.back(); // 이전 페이지로 사용자를 돌려 보냄.
			<%
		}
		
	%>

</script>
</head> 
<body>
</body>
</html>