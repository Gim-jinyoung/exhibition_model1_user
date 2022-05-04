<%@page import="VO.ExhibitionHallVO"%>
<%@page import="VO.ExhibitionVO"%>
<%@page import="java.util.List"%>
<%@page import="DAO.UserMainDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	 
	%>

<!DOCTYPE html>
<html>
<head>

<!-- /.website title -->
<title>VTC Theme | Home page</title>
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

</head>


<body data-spy="scroll" data-target="#navbar-scroll">
<%
					UserMainDAO umDAO = new UserMainDAO();
					List<ExhibitionVO> list = umDAO.selectExRepresent();
					int num=0,hall_num=0;
					String name="",poster="",intro="";
					for(ExhibitionVO ehVO:list){
						num=ehVO.getEx_num();
						name=ehVO.getEx_name();
						poster=ehVO.getEx_poster();
						intro=ehVO.getEx_intro();
						hall_num=ehVO.getEx_hall_num();
						

					}
					%>
	<!-- /.preloader -->
	<div id="preloader"></div>
	<div id="top"></div>

	<!-- /.parallax full screen background image -->
	<div class="fullscreen landing parallax"
		data-img-width="2000"
		data-img-height="1333" data-diff="100">

		<div class="overlay"  style="background-image:url('./img/<%=poster %>')"; >
		
			<div class="container"  >
				<div class="row">
					<div class="col-md-7" >

						<!-- /.logo -->
						<div class="logo wow fadeInDown" >
							<a href="index.jsp">Exhibition</a>
						</div>
						<div class="head-btn wow fadeInLeft" style="width: 1300px;">
							<%
							
							Object value= null; 
							if((Object)session.getAttribute("mVO")!=null){
							value=(Object)session.getAttribute("mVO");
							}
							 %>
							 <%
							if(value==null){
								%>
								<a href="login.jsp" class="btn btn-default" id="login_btn"
								style="float: right;">로그인/회원가입</a>
								<%
							}else{
								%>
								<a href="my_account_pass.jsp"
										class="btn btn-primary" id="my_info_btn" style="float: right;">내
										정보</a>  
										
										<a href="index_logout.jsp"
										class="btn btn-default" id="logout_btn" style="float: right">로그아웃</a>
									<%
							}
							 
							 %>
							 

							<!-- /.main title -->
							<h1 class="wow fadeInLeft">
								<span class="color"><a
									href="exhibition_detail.jsp?ex_num=<%=num%>&ex_hall_num=<%=hall_num%>"><%=num%>.
										<%=name%> </a></span>
							</h1>

							<!-- /.header paragraph -->
							<div class="landing-text wow fadeInUp">
								<p><%=intro%></p>
							</div>

						</div>
					</div>
				</div>
			</div>


		</div>
		</div>


	<!-- NAVIGATION -->
	<div id="menu">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-backyard">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand site-name" href="#top">Exhibition</a>
			</div>

			<div id="navbar-scroll"
				class="collapse navbar-collapse navbar-backyard navbar-right">
				<ul class="nav navbar-nav">
					<li><a href="list.jsp">전체 전시 보기</a></li>
					<li><a href="list.jsp">지역별 전시 보기</a></li>
					<li><a href="reservation.jsp">예약하기</a></li>
					<li><a href="board.jsp">게시판</a></li>

				</ul>
			</div>
		</div>
	</div>

	<!-- /.Cars section -->
	<div class="container">
		<form class="d-flex" action="list.search.jsp?pageNum=1" method="get">
				<button class="btn btn-outline-success" type="submit"
					style="float: right; height: 50px">Search</button>
				<input class="form-control me-2" type="search" placeholder="전시명을 입력하세요" name="ex_name"
					aria-label="Search" style="float: right; width: 200px" >
			</form>
	</div>
	<div id="carssection">

		<div class="container">
			<div class="text-center">

				<h2 class="wow fadeInLeft">전시 지역 선택</h2>
				<div class="title-line wow fadeInRight"></div>
			</div>
			<div class="row carssections">
			<div id="map" style="width:100%;height:350px;"></div><br/><br/>				

				
			</div>
		</div>
	</div>



	<!-- /.contact section -->
	<div id="contact">
		
	</div>








	<!-- /.footer -->
	<footer id="footer">
		<div class="footer-top">
			<div class="container">
				<div class="">
					<div class="col-md-4 col-sm-6">
						<h4>고객 센터</h4>
						<p>
							<strong>3조</strong> <br>전화 번호 :081) 123-1234 <br>상담 가능
							시간: AM 10:00~PM 05:00 <br>관련 이메일: exhibition@naver.com
						</p>
						<hr class="hidden-md hidden-lg">
					</div>


					<!-- /.col-md-4 -->

					<div class="col-md-4 col-sm-6">
						<h4>사업자 등록번호</h4>
						<div class="newsletter-box">
							<div class="newsletter">
								<div class="newsletter-content">
									<p>123-1234-1234</p>
								</div>

								<div class="clear"></div>
							</div>
						</div>
					</div>
					<!-- /.col-md-4 -->

				</div>
			</div>
		</div>
	</footer>


	<!-- /.javascript files -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-datetimepicker.min.js"></script>
	<script src="js/custom.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?sensor=false&libraries=places"></script>
	<script src="js/google.js"></script>
	<script src="js/booking.js"></script>
	<script src="js/bootstrap-hover-dropdown.js"></script>
	<script src="js/jquery.validate.min.js"></script>

	<script src="js/snap.svg-min.js"></script>
	<script src="js/hovers.js"></script>


	<script>
		new WOW().init();
		$('#date_time').datetimepicker({
			format : 'dd/MM/yyyy hh:mm:ss',
			language : 'en-US',
			pickDate : true, // disables the date picker
			pickTime : true
		});
	</script>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c9dda8d4f453a27430fc00656a00008f"></script>
       <script>
            (function () {
                function init() {
                    var speed = 250,
                            easing = mina.easeinout;
                    [].slice.call(document.querySelectorAll('#carssections > div')).forEach(function (el) {
                        var s = Snap(el.querySelector('svg')), path = s.select('path'),
                                pathConfig = {
                                    from: path.attr('d'),
                                    to: el.getAttribute('data-path-hover')
                                };

                        el.addEventListener('mouseenter', function () {
                            path.animate({'path': pathConfig.to}, speed, easing);
                        });

                        el.addEventListener('mouseleave', function () {
                            path.animate({'path': pathConfig.from}, speed, easing);
                        });
                    });
                }
                init();
            })();
        </script>
        <script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(37.53844 , 126.99921), // 지도의 중심좌표
        level: 1 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
 
// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
var positions = [];
var hallNum = [];
	<%

	List<ExhibitionHallVO> list2 = umDAO.selectExLocAll();
	for(ExhibitionHallVO temp : list2){	
		num	=	temp.getEx_hall_num();
		name = temp.getEx_name();
		Double longitude = temp.getLongitude();
		Double latitude = temp.getLatitude();

	%>
		
	
		var tempData = 
		{
		        content: '<div style="color: black;"><a href="list_loc.jsp?ex_hall_num=<%=num%>&pageNum=1"><%=name%><br/>전시 리스트</div></a>', 
		        latlng: new kakao.maps.LatLng(<%=latitude%>,<%=longitude%> )
		}
		
		
		positions.push(tempData);
		
		
	<%
	}
	%>

	for (var i = 0; i < positions.length; i ++)  {
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng // 마커의 위치
        
       
    });

    // 마커에 표시할 인포윈도우를 생성합니다 
    var infowindow = new kakao.maps.InfoWindow({
        content: positions[i].content // 인포윈도우에 표시할 내용
    
   
    });

   	 
    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
   	 

}

// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeOverListener(map, marker, infowindow) {
    return function() {
        infowindow.open(map, marker);
    };
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
function makeOutListener(infowindow) {
    return function() {
        infowindow.close();
    };
}

</script>

</body>
</html>