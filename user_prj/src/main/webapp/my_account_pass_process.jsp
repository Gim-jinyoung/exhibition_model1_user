<%@page import="DAO.MyinfoDAO"%>
<%@page import="VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   %>
<% 
request.setCharacterEncoding("UTF-8");
String userId=((MemberVO)session.getAttribute("mVO")).getUserId();


String password=request.getParameter("password"); //입력된 값 비번
MemberVO mVO=new MemberVO(userId,"","","","",password,"","",' ');
//String userId, String tel, String zipcode, String address1, String ad dress2, String password,
	//String isSubscribeDate, String name, char isDeleted
MyinfoDAO miDAO=MyinfoDAO.getInstance();


int result=miDAO.checkPass(mVO);// 세션에있는 아이디와 폼으로 입력된 비밀번호를 사용해서 pass를 체크한다. 
System.out.println("비밀번호값 : "+mVO.getPassword()+"비밀번호확인값 : "+password);
%>
	<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Web Site</title>
<script type="text/javascript">

	<%if( result == 1){ // %>
			location.href ="my-account_rez.jsp"; // 비밀번호가맞을때 내정보로 보냄
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


<script type="text/javascript">

	
			
	

</script>
</body>
</html>