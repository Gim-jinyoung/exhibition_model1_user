<%@page import="VO.ExhibitionHallVO"%>
<%@page import="DAO.UserExhibitionDAO"%>
<%@page import="DAO.UserExhibitionDetailDAO"%>
<%@page import="java.util.List"%>
<%@page import="VO.ExhibitionVO"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>
<%
int ex_num= Integer.parseInt(request.getParameter("ex_num"));
int ex_hall_num = Integer.parseInt(request.getParameter("ex_hall_num"));

UserExhibitionDetailDAO uehDAO=UserExhibitionDetailDAO.getInstance();

List<ExhibitionVO> list=uehDAO.selectExhibition(ex_num);

List<ExhibitionHallVO> list_map=uehDAO.mapSelect(ex_hall_num);


int num=0,hall_num=0;
String name="",poster="",intro="",hall_name="",add_img="",info="",status="";
double longitude=0.0,latitude=0.0;

for(ExhibitionVO ehVO:list){
	num=ehVO.getEx_num();
	name=ehVO.getEx_name();
	poster=ehVO.getEx_poster();
	intro=ehVO.getEx_intro();
	add_img=ehVO.getAdd_Img();
	info=ehVO.getEx_info();
	status=ehVO.getEx_status();
}

for(ExhibitionHallVO exhVO:list_map){
	hall_num=exhVO.getEx_hall_num();
	hall_name=exhVO.getEx_name();
	longitude=exhVO.getLongitude();
	latitude=exhVO.getLatitude();
}
%>
	

<!DOCTYPE html>
<html>
    <head>

        <!-- /.website title -->
        <title>전시 상세</title>
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

    </head>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d03047aec60053ce5bf32ac7416d3021"></script>


    <body data-spy="scroll" data-target="#navbar-scroll">


        <!-- /.preloader -->
        <div id="preloader"></div>
        <div id="top"></div>

        <!-- /.parallax full screen background image -->
        <div class="fullscreen landing parallax blog-page" style="background-image:url('images/bg-baner.jpg');" data-img-width="2000" data-img-height="1333" data-diff="100">

            <div class="overlay">
                <div class="container">
                    <div class="col-md-10 col-md-offset-1 text-center">

                        <!-- /.logo -->
                        <div class="logo wow fadeInDown" style="margin-top: 50px"> 
                            <a href="index.jsp">Exhibition</a>
                        </div>

                        <!-- /.main title -->
                      

                    </div>
                </div> 
            </div> 
        </div>
        
        
             <!-- NAVIGATION -->
        <div id="menu">
               <div class="container""> 
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-backyard">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand site-name" href="index.jsp">Exhibition</a>
                    </div>

                    <div id="navbar-scroll" class="collapse navbar-collapse navbar-backyard navbar-right">
                        <ul class="nav navbar-nav">
                               <li><a href="list.jsp">전체 전시 보기</a></li>
                            <li><a href="loc.jsp">지역별 전시 보기</a></li>
                            <li><a href="reservation.jsp">예약하기</a></li>
                                    <li><a href="board.jsp">게시판</a></li>
                        
                        </ul>
                    </div>
                 </div>  
        </div>
         <div id="carssection">
            <div class="container">
              
          <div class="row carssections">

                        <div class="screen wow fadeInUp" data-path-hover="m 180,34.57627 -180,0 L 0,0 180,0 z">
                            <figure >
                                <div class="screen wow fadeInUp" style="position:absolute; left:350px; width: 900px; height: 400px"><strong><%=num %>. <%=name %></strong><br/><%=intro %></div>
                                <img src="./img/<%=poster %>" style="width:300px"/>
                             <a href="reservation.jsp"><input type="button"  value="예약" style="width:260px; background-color: #F0AD4E;color:#ffffff; border:0px ;margin-left: 500px"></a> 
                                <a href="review.jsp?cat_num=<%=num%>"><input type="button"   value="후기" style="width:260px; margin-left: 15px ;background-color: #F0AD4E;color:#ffffff; border:0px"></a> 
                            
                            </figure>
                        </div>   
                        </div>
                        </div>
                        </div>
                        <!-- 전시 상세 -->
             	<div class="container" style="width: 1200px; height: 1500px; background-color: #ffffff ;border:1px solid #E5E5E5">
             	
             	<img src="./img/<%=add_img %>" style="width:100%; height:500px; "/><br/><br/>
             	<div id="output"></div><%=info %>

             	<div id="map" style="width:70%;height:350px; margin-left: 150px; margin-top: 100px"></div>
             	</div>
             	
           <!-- /.footer -->
        <footer id="footer" >
            <div class="footer-top">
                <div class="container">
                    <div class="">
                        <div class="col-md-4 col-sm-6">
                            <h4>고객 센터</h4>
                            <p><strong>3조</strong>
                                <br>전화 번호 :081) 123-1234  
                                <br>상담 가능 시간: AM 10:00~PM 05:00
                                <br>관련 이메일: exhibition@naver.com
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
                                    
                                    <div class="clear"> </div>
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
            <script src="js/jquery.validate.min.js"></script> 



        <script>
            new WOW().init();

        </script>
        <script>
        
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(<%=latitude%>,<%=longitude%>), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(<%=latitude%>,<%=longitude%>); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);    
</script>
    </body>
</html>