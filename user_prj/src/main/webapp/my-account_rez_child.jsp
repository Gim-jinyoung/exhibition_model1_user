<%@page import="VO.MemberVO"%>
<%@page import="DAO.MyReservationDAO"%>
<%@page import="VO.MyReservationVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
       %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--공통 CSS-->
<link rel="stylesheet" type="text/css" href="http://211.63.89.140:80/jsp_prj/common/main_20220321.css"/>
<title>Insert title here</title>
         <style type="text/css">
#total{
	position:absolute;
	width:500px; height:400px; background:#FFFFFF;   background-color: #F0AD4E ;
	color: #ffffff; text-align: center;
}
.content{background-color: #ffffff; color: #000000;}
table{margin-left: 80px}
</style>
<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<!--  bootstrap CDN-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<script type="text/javascript">

});//ready

</script>
</head>
<body>

<div id="total" >
<h2><strong>예약 상세 페이지</strong></h2>
<div class="content">
<div id="header">
</div>
<br/>
<%
MemberVO sessionMember=(MemberVO)session.getAttribute("mVO");
String userid=sessionMember.getUserId();

MyReservationVO mrVO=new MyReservationVO();
MyReservationDAO mrDAO=MyReservationDAO.getInstance();
String rezNum=request.getParameter("hid");

mrVO.setRez_num(Integer.parseInt(rezNum));
mrVO.setUserid(userid);
MyReservationVO rezDetail=mrDAO.selectReservationDetail(mrVO);

pageContext.setAttribute("rezDetail", rezDetail);
%> 
<table>
<tr>
	<th>사용자: </th><td>${rezDetail.userid }</td>
</tr>
<tr>
	<th>예약 번호: </th><td>${rezDetail.rez_num }</td>
</tr>
<tr>
	<th>전시 명: </th><td>${rezDetail.ex_name }</td>
</tr>
<tr>
	<th>전시 장: </th><td>${rezDetail.ex_hall_name }</td>
</tr>
<tr>
	<th>방문 날짜: </th><td>${rezDetail.visit_date }</td>
</tr>
<tr>
	<th>관람 인원: </th><td>${rezDetail.rez_count }</td>
</tr>


</table>
<br/>
	<a href="reservation_cancel.jsp?rez_num=${rezDetail.rez_num }"><input type="button"  value="예약 취소" style="margin-left: 50px;"  class="btn btn-light"></a>
    <input type="button"   value="닫기" onclick="self.close()" class="btn btn-outline-danger">
    <br/><br/>
</div>
</div>
</body>
</html>