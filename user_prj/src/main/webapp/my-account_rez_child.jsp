<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://211.63.89.140:8080/html_prj/common/main_20220321.css"/>
<title>Insert title here</title>
<style type="text/css">
#header{background-color: #F0AD4E; width: 500px; height: 50px;text-align: center;padding-top: 20px ; }
#content{width: 500px; height: 400px; vertical-align: middle;}
span{ color: #ffffff; font-weight: bold; }
table{margin-left: 100px; text-align: left;}
input{width:200px;height: 50px; background-color: #F0AD4E;color:#ffffff; border:0px; }
input:hover {
	background-color: #A29879
}
</style>
<!--  jQuery CDN-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
function reservationCancel() {
	window.opener.location.href="reservation_cancel.jsp";
	self.close();
}
</script>
</head>
<body>

<div id="content">
<div id="header">
<span >예약 상세 페이지</span>
</div>
<br/>
<table>
<tr>
	<th>사용자 테이블</th><td>userid</td>
</tr>
<tr>
	<th>예약 번호</th><td>1234</td>
</tr>
<tr>
	<th>전시 명</th><td>전시1</td>
</tr>
<tr>
	<th>전시 장 : </th><td>전시장1</td>
</tr>
<tr>
	<th>방문 날짜</th><td>2021-04-07</td>
</tr>
<tr>
	<th>관람 인원</th><td>3명</td>
</tr>
<tr>
	<th>총 가격</th><td>1500원</td>
</tr>

</table>
<br/><br/>
	<input type="button"  value="예약 취소" style="margin-left: 50px;" onclick="reservationCancel()">
    <input type="button"   value="닫기" onclick="self.close();" >
</div>

</body>
</html>