<%@page import="java.util.List"%>
<%@page import="DAO.UserExhibitionDAO"%>
<%@page import="VO.ExhibitionVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.UserMainDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	%>
	<jsp:useBean id="DAO" class="DAO.UserMainDAO"/>
<!DOCTYPE html>
<html>
<head>
<!-- /.website title -->
<title>VTC Theme | My account</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<meta charset="UTF-8" />
<!-- CSS Files -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="fonts/icon-7-stroke/css/pe-icon-7-stroke.css"
	rel="stylesheet">
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
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic" />

</head>

<body data-spy="scroll" data-target="#navbar-scroll">
	<!-- /.preloader -->
	<div id="preloader"></div>
	<div id="top"></div>


	<!-- /.parallax full screen background image -->
	<div class="fullscreen landing parallax blog-page"
		style="background-image: url('images/bg-baner.jpg');"
		data-img-width="2000" data-img-height="1333" data-diff="100">

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
		<div class="container"">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-backyard">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand site-name" href="index.jsp">Exhibition</a>
			</div>

			<div id="navbar-scroll"
				class="collapse navbar-collapse navbar-backyard navbar-right">
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
			<form class="d-flex" action="list.search.jsp" method="get">
				<button class="btn btn-outline-success" type="submit"
					style="float: right; height: 50px">Search</button>
				<input class="form-control me-2" type="search" placeholder="전시명을 입력하세요" name="ex_name"
					aria-label="Search" style="float: right; width: 200px" >
			</form>
		</div>
		<div class="container">
			<div class="text-center ">
				<!-- /.pricing title -->
				<h2 class="wow fadeInLeft">전시 리스트</h2>
				<div class="title-line wow fadeInRight"></div>
			</div>



			<div class="col-sm-9 account-data padding-b-50 padding-t-50">
				<div id="tab2" class="box-old-booking box-section animated fadeInUp">
					<h2 style="padding-bottom: 17px;">목록</h2>

					<!-- /.Cars section -->
					<div id="carssection">
						<div class="container">

						<div class="row carssections">
							<%
							int pageSize = 2;
							String pageNum=request.getParameter("pageNum");
							if(pageNum==null){
								pageNum="1";
							}
							int currentPage=Integer.parseInt(pageNum);
							int startRow = (currentPage * 2) - 1; 
							
							int ex_hall_num=Integer.parseInt(request.getParameter("ex_hall_num"));
							UserExhibitionDAO exDAO=UserExhibitionDAO.getInstance();
							List<ExhibitionVO> list=exDAO.selectLocalExList(ex_hall_num,startRow,pageSize);
							int hall_num=0;
							for(int i=0; i<list.size();i++){	
								hall_num=list.get(i).getEx_hall_num();
							%>
								<div class="screen wow fadeInUp"
									data-path-hover="m 180,34.57627 -180,0 L 0,0 180,0 z">
									<figure>
										<div class="screen wow fadeInUp"
											style="position: absolute; left: 350px; width: 900px; height: 400px">
											<strong><%=list.get(i).getEx_name()%></strong><br/><%=list.get(i).getEx_intro()%> 
										</div>
										<%-- <a href="exhibition_detail.jsp?ex_num=<%=list.get(i).getEx_num()%>"> --%>
										<a href="exhibition_detail.jsp?ex_num=<%=list.get(i).getEx_num()%>&ex_hall_num=<%=list.get(i).getEx_hall_num()%>">
										<img src="./img/<%=list.get(i).getEx_poster() %>" style="width: 300px"/></a>
											 
									</figure>
								</div>
							<%
							}
							%>

				
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

				<div class="text-center">
		<nav aria-label="Page navigation example">
			<ul class="pagination">

			<%
			int cnt=exDAO.getTotalCount();
			System.out.print(cnt);
			if(cnt!=0){
				int pageCount=cnt/pageSize+(cnt%pageSize==0?0:1);
				int pageBlock=2;
				int startPage=((currentPage-1)/pageBlock)*pageBlock+1;
				
				int endPage=startPage+pageBlock-1;
				if(endPage>pageCount){
					endPage=pageCount;
				}
			
				
			%>
			<% if(startPage>pageBlock){ %>
			
				<li class="page-item"><a class="page-link" href="list_loc.jsp?ex_hall_num=<%=hall_num %>&pageNum=<%=startPage-pageBlock%>"
					aria-label="Previous"><span aria-hidden="true">&laquo;</span>
				</a></li>
				<%} %>
				<%for(int i=startPage;i<=endPage;i++){ %>
				<li class="page-item"><a class="page-link" href="list_.jsp?ex_hall_num=<%=hall_num %>&pageNum=<%=i%>"><%=i%></a></li>
				<%} %>
				<%if(endPage<pageCount){ %>
				<li class="page-item"><a class="page-link" href="list_loc.jsp?ex_hall_num=<%=hall_num %>&pageNum=<%=startPage+pageBlock %>"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
					<%} %>
				<%} %>
			</ul>
		</nav>
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
	<script src="js/jquery.validate.min.js"></script>

	<script>
		new WOW().init();
	</script>


</body>
</html>