<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

        <meta charset="UTF-8" />
        <!-- CSS Files -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
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
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>새 비밀번호 확인</title>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top" style="width: 500px">
		<div class="w3-container w3-card-4">
			<form action="../member/find_id.do" method="post">
				
				<div>
					<p>
						<label>새 비밀번호</label>
						<input class="w3-input" type="password"  name="pass1">
					</p>
					<p>
						<label>새 비밀번호확인</label>
						<input class="w3-input" type="password" name="pass2" >
					</p>
					<p class="w3-center">
						
					<input type="button"  class="btn btn-warning" value="새로 변경" onclick="vaild(this.form)"/>
					
						
					</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">

function vaild(x){
	var alphaDigit= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"

		if (x.pass1.value=="") {
		    alert("비밀번호를 입력하셔야 합니다.")
		    x.pass1.focus();
		    return;
		    }
	 	if (x.pass2.value==""){
		    alert("비밀번호를 확인 입력해 주셔야 합니다.")
		    x.pass2.focus();
		    return;
		    }
		if (x.pass1.value != x.pass2.value) {
		    alert("비밀번호가 서로 일치하지 않습니다.");
		    x.pass1.value=x.pass2.value="";
		    x.pass1.focus();
		    return;
		    } 
		if (x.pass1.value.indexOf(" ") >= 0) {
		    alert("비밀번호에는 공백이 들어가면 안됩니다.");
		    x.pass1.value=x.pass2.value="";
		    x.pass1.focus();
		    return;
		    }
		if(x.pass1.value==x.pass2.value){
			location.href="http://localhost/user_prj/passclear.jsp"
		}
		
}//vaild

</script>