<%@page import="VO.MemberVO"%>
<%@page import="VO.LocalVO"%>
<%@page import="VO.BoardrVO"%>
<%@page import="java.util.List"%>
<%@page import="DAO.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
  
     %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- /.website title -->
<title>게시판 | 상세보기</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<meta charset="UTF-8" />
<!-- CSS Files -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="fonts/icon-7-stroke/css/pe-icon-7-stroke.css"
	rel="stylesheet">
<link href="css/animate.css" rel="stylesheet" media="screen">
<link href="css/owl.theme.css" rel="stylesheet">
<link href="css/owl.carousel.css" rel="stylesheet">

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

</style>
<!-- jQuery CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"
	defer></script>
<style type="text/css">
a{
    color: #d1b702;
    outline: 0;
    font-weight: bold;
    -webkit-transition: all .8s ease;
    transition: all .8s ease;
} 
</style>


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
			<div class="text-center ">
				<!-- /.pricing title -->
				<h2 class="wow fadeInLeft">상세 게시판</h2>
				<div class="title-line wow fadeInRight"></div>
			</div>
			<div class="row account-details">

				<!-- /.account-control -->
				<div
					class="panel panel-default sidebar-menu wow  fadeInLeft animated">
				</div>
				<div class="panel-heading">
				  <%
								BoardDAO bDAO=BoardDAO.getInstance();
				  				BoardrVO bVO=new BoardrVO();
				  				String bd_id=request.getParameter("value");
				  				if (bd_id ==null){
				  					%> 잘못된 접근입니다.  <%
				  				}
				  			
								BoardrVO boardDetail=bDAO.selectBoardDetail(Integer.parseInt(bd_id));
								List<BoardrVO> boardComment=bDAO.selectcomment(Integer.parseInt(bd_id));
								
								pageContext.setAttribute("boardComment", boardComment);
								pageContext.setAttribute("boardDetail", boardDetail);
				  				bDAO.updateView(Integer.parseInt(bd_id));
								%>
					<h3 class="panel-title">제목</h3>
					<input class="form-control" type="text" readonly="readonly"
						style="background: #ffffff" value="${boardDetail.title}" disabled="disabled"/>
						<div style="border: 1px solid #A5A5A5; margin-top: 10px">
					 <img src="ImageFile/${boardDetail.imgfile }"/> 
					<textarea name="ta" readonly="readonly"  id="textDesc"
						style="background: #ffffff;border: 0px ;resize: none; width: 100%; height1000px;margin-top: 10px;" disabled="disabled">${boardDetail.description}</textarea> 
						</div>
				</div>
				</div>
				<%
				String userid=boardDetail.getUserid();
				MemberVO sessionMember=(MemberVO)session.getAttribute("mVO");
				String sessionId=sessionMember.getUserId();
					
				pageContext.setAttribute("sessionId", sessionId);
				pageContext.setAttribute("bd_id",bd_id);%>
					<i class="fa fa-comment fa" ></i> 댓글
				<div class="card-body">
					<ul class="list-group list-group-flush">
						<li class="list-group-item">
					<form action="comment.jsp" method="get" id="commentFrm" name="commentFrm">
							<div class="form-inline mb-2">
								<label for="replyId"><i
									class="fa fa-user-circle-o fa-2x"></i></label>
							</div> <textarea class="form-control" id="ta" name="ta" style="width: 100%;resize: none;"
								rows="3"></textarea>
								<input type="hidden" value="${bd_id }" name="bd_id"/>
							<button type="button" class="btn btn-dark mt-3" style="margin-top:10px;" id="commentBtn">댓글 작성</button>
					</form>
						</li>
						<c:forEach var="boardComment" items="${pageScope.boardComment }">
						<li><div>
						<input type="text" value="${boardComment.cm_userid }" style="border:none; text-align: center" readonly="readonly" disabled="disabled" />
						<input type="text" style="width: 50%; margin-top: 10px ; border:none" readonly="readonly" disabled="disabled" value="${boardComment.cm_description }"/>
						<input type="text" value="${boardComment.cm_input_date }"  style="border:none; text-align: center" readonly="readonly" disabled="disabled"/>
							<c:if test="${sessionId eq boardComment.cm_userid}"> 
							<a href="commentDelete.jsp?cm_id=${boardComment.cm_id  }&bd_id=${bd_id}"><button type="button" class="btn btn-dark mt-3" style="margin-top:10px;" id="commenDeltBtn">댓글 삭제</button></a>
						</c:if> 
							</div>
						</li>
						</c:forEach>
					</ul>
				</div>
				<br />
				<a href="board.jsp">
				<input type="button" value="확인" id="btn" class="btn btn-warning " style="width: 30%; margin-left: 30% "/>
				</a>
				<c:if test="${sessionId eq boardDetail.userid }">
				<a href="boardDelete.jsp?bd_id=${bd_id }"><input type="button" value="글 삭제"  class="btn btn-warning btn-block btn-lg" style="width: 10%; float:right; "/></a>
				<a href="boardUpdate.jsp?bd_id=${bd_id }"><input type="button" value="글 수정"  class="btn btn-warning btn-block btn-lg" style="width: 10%; float:right;"/></a>
				</c:if>
				
			</div>
			

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
<script type="text/javascript">
	$(document).ready(function() {
		
		
		$('#summernote1').summernote({
			height : 400
		});
		$("#btn").click(function() {
			$("#frm").submit();
		});
		$("#commentBtn").click(function(){
			$("#commentFrm").submit();
		});
		
	});
</script>

</body>
</html>