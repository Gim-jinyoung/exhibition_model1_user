<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here.</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<meta charset="UTF-8" />
<!-- CSS Files -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="fonts/icon-7-stroke/css/pe-icon-7-stroke.css"
	rel="stylesheet">
<link href="fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet" media="screen">
<link href="css/owl.theme.css" rel="stylesheet">
<link href="css/owl.carousel.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">

<!-- Colors -->
<!-- <link href="css/css-index-blue.css" rel="stylesheet" media="screen"> -->
<!-- <link href="css/css-index-green.css" rel="stylesheet" media="screen"> -->
<!-- <link href="css/css-index-purple.css" rel="stylesheet" media="screen"> -->
<!-- <link href="css/css-index-red.css" rel="stylesheet" media="screen"> -->
<!-- <link href="css/css-index-orange.css" rel="stylesheet" media="screen"> -->
<link href="css/css-index-yellow.css" rel="stylesheet" media="screen">

<!-- Google Fonts -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic" />

	
<style type="text/css">
#backDiv{width:350px; height: 300px; margin: 0px auto; position: relative; style="border: 0px auto; text-align: center;"}
body{background: #ffffff  no-repeat;}
#idBox{position: absolute; top:80px; left:50px}
</style>
<script type="text/javascript">
window.onload=function(){
	document.getElementById("dupBtn").addEventListener("click",searchId);
}
function searchId(){
	var obj=document.cFrm;

	var output="<strong>"+obj.id.value+"</strong>는 사용가능합니다."+
	"<a href='#void' onclick=\"sendId('"+obj.id.value+"')\">사용</a>";
	
		

	document.getElementById("dupResult").innerHTML=output;
	
}
function sendId(id){
	//입력받은 아이디를 부모창으로 전송하고, 자식창을 닫는다.
	opener.window.document.pFrm.id.value=id;
	self.close();
}
</script>
</head>
<body>
<div id="backDiv">
<div id="idBox">
<form name="cFrm">
<label>아이디</label>
<%-- 자식창에 존재하는 JSP에서 부모창이 넘기는 파라메터를 받아서 value속성에 값으로 넣는다
value="${param.파라메터명}" --%>
<input type="text" name="id" id="id" class="inputBox" value="${param.id}"/><br/><br/>
<input type="button" value="중복확인" class="btn btn-warning btn-block btn-lg" id="dupBtn" />
<div><span id="dupResult"></span><br/></div>
</form>
</div>
</div>
</body>
</html>