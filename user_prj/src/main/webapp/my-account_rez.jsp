<%@page import="VO.MemberVO"%>
<%@page import="VO.MyReservationVO"%>
<%@page import="DAO.MyReservationDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head> 
        <!-- /.website title -->
        <title>예약정보</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

        <meta charset="UTF-8" />
        <!-- CSS Files -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
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
        <link href="css/stacktable.css" rel="stylesheet" media="screen">
        <link href="css/css-index-yellow.css" rel="stylesheet" media="screen"> 

        <!-- Google Fonts -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic" />

    </head>

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

                       

                    </div>
                </div> 
            </div> 
        </div>
        
        
              <!-- NAVIGATION -->
        <div id="menu">
               <div class="container"> 
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


        <!-- /.pricing section -->
        <div id="myaccount">
          <div class="container">
            
</div>
            <div class="container">
                <div class="text-center ">
                    <!-- /.pricing title -->
                    <h2 class="wow fadeInLeft">내 정보</h2>
                    <div class="title-line wow fadeInRight"></div>
                </div>
                <div class="row account-details">

                    <!-- /.account-control -->
                    <div class="col-sm-3 account-control padding-b-50 padding-t-50">
                        <div class="panel panel-default sidebar-menu wow  fadeInLeft animated">
                            <div class="panel-heading">
                                <h3 class="panel-title">Menu</h3>
                            </div>
                            <div class="panel-body">
                                <ul class="nav nav-pills nav-stacked">
                              		 <li> <a href="#void">비밀번호 입력</a></li>
                                    <li class="active"><a href="#void">예약상황</a></li>
                                    <li><a href="my_account_modify.jsp">내 정보 수정</a></li>
                                    
                                    
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-9 account-data padding-b-50 padding-t-50">
                        <div id="tab2" class="box-old-booking box-section animated fadeInUp">
                            <h2 style="padding-bottom: 17px;">예약 상황</h2>

								<form action="my-account_rez_child.jsp" name="frm" id="frm">
                            <table id="mybooking-list" class="table booking-list stacktable large-only">
                                <tbody>
                                    <tr>
                                        
                                        <th style="width:130px">예약 번호</th>
                                        <th style="width:200px">전시이름</th>
                                        <th style="width:150px">방문 날짜</th> 
                                        <th style="width:130px">방문 인원</th> 
                                        <th style="width:150px">예약 날짜</th> 
                                        <th>예약 상황</th> 
                                        
                                    </tr>
                                     <%
                             
                                     MyReservationDAO mrDAO=MyReservationDAO.getInstance();
                                     MemberVO sessionMember=(MemberVO)session.getAttribute("mVO");
                     				String userid=sessionMember.getUserId();
     								List<MyReservationVO> rezList=mrDAO.selectAllReservation(userid);
                             	
								pageContext.setAttribute("rezList", rezList);
								int num=0;
								
								%>
								<c:forEach var="rezList" items="${pageScope.rezList }">
								<input type="hidden" value="${rezList.rez_num }" name="hid" id="hid" />
                                    <tr >
                                        <td><%=num+=1 %></td>
                                        <td ><a href="#void" onclick="${rezList.rez_status eq 'f'?'':'detail()'}" > <input type="text" value="${rezList.ex_name}" style="color:${rezList.rez_status eq 'f'?'#A5A5A5':''}; border:0px" readonly="readonly" disabled="disabled"/></a></td>
                                        <td>${rezList.visit_date } </td>
                                        <td>${rezList.rez_count }</td>
                                        <td>
                                            ${rezList.rez_date }
                                        </td>
                                        <td style="width:100px"><input type="text" value="${rezList.rez_status eq 'f'?'예약 취소':'예약 완료'}" style="border:0px"/> </td>
                                        
                                    </tr> 

</c:forEach>
                                    
                                </tbody>
                            </table>
                            </form>
                         
                            <div class="text-center">
							<a href="my-account_rez.jsp"><input type="button" id="find_direction"  value="확인" style="width:260px; background-color: #F0AD4E;color:#ffffff; border:0px"></a> 
							</div>	                        
                        </div>
                    </div>
                </div>
            </div>
        </div>




      
        
     <!-- /.footer -->
        <footer id="footer">
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
	<script type="text/javascript">

   
    function detail(){
    		var rezNum=
    		"my-account_rez_child.jsp?hid="+$("#hid").val();
    		window.open(rezNum,"detail","width=600px, height=500px");
    }
    </script>


    </body>
</html>