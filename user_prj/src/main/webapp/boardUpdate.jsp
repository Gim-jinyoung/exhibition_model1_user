<%@page import="VO.BoardrVO"%>
<%@page import="java.util.List"%>
<%@page import="DAO.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- /.website title -->
<title>게시판 글 수정</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js" defer></script>
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
				<h2 class="wow fadeInLeft">글쓰기</h2>
				<div class="title-line wow fadeInRight"></div>
			</div>
			<div class="row account-details">

				<!-- /.account-control -->
				<form action="boardUpdateProcess.jsp" method="post"  id="frm" name="frm" enctype="multipart/form-data">
				<div
					class="panel panel-default sidebar-menu wow  fadeInLeft animated">
				</div>
					<div class="panel-heading">
                                            <%
                                            
                                String bdId=request.getParameter("bd_id");
                                            if(bdId == null){
                                            	%>잘못된 접근입니다. <%
                                            }
								BoardDAO bDAO=BoardDAO.getInstance();
								List<BoardrVO> catList=bDAO.selectCategory();
								BoardrVO detail=bDAO.selectBoardDetail(Integer.parseInt(bdId));
								
								pageContext.setAttribute("detail", detail);
								pageContext.setAttribute("catList", catList);
								%>
						<h3 class="panel-title">제목</h3>
						<input class="form-control" type="text" id="title" name="title" value="${detail.title }">
						<input class="form-control" type="hidden" name="hid" value="${detail.bd_id }">
					</div>
					<div class="panel-body">
						<ul class="nav nav-pills nav-stacked">
						<li>카테고리</li>
                                    <li>  <select class="form-control input-lg" name="Exhibition" id="Exhibition">
								<c:forEach var="catList" items="${pageScope.catList }">
								<option value="${ catList.cat_num}" ${catList.cat_num eq param.Exhibition?" selected='selected'":""}><c:out value="${catList.cat_name }"/></option>
								</c:forEach>
                                            </select></li>
                                    
                                    
                                </ul>
					</div>
					<textarea id="summernote1" name="ta" >${detail.description }</textarea>
					<input type="file" name="img" id="img" />
					<br /> <input type="button" value="전송" id="btn"
						class="btn btn-warning btn-block btn-lg" />
						</form>
						
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
						<p>
							<strong>3조</strong> <br>전화 번호 :081) 123-1234 <br>상담 가능
							시간: AM 10:00~PM 05:00 <br>관련 이메일: exhibition@naver.com
						</p>
						<hr class="hidden-md hidden-lg"/>
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
		  height: 400,                 // 에디터 높이
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '내용을 작성해주세요',	//placeholder 설정
		  toolbar: [
			    // 글꼴 설정
			    ['fontname', ['fontname']],
			    // 글자 크기 설정
			    ['fontsize', ['fontsize']],
			    // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
			    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
			    // 글자색
			    ['color', ['forecolor','color']],
			    // 표만들기
			    ['table', ['table']],
			    // 글머리 기호, 번호매기기, 문단정렬
			    ['para', ['ul', 'ol', 'paragraph']],
			    // 줄간격
			    ['height', ['height']],
			    // 그림첨부, 링크만들기, 동영상첨부
			    ['insert',['picture']],
			  ],
        
	});
	
	$("#btn").click(function(){
		 if($("#title").val()==""){
			  alert("제목 입력은 필수입니다.");
			  return;
		  }
		  if($("#summernote1").val()==""){
			  alert("내용을 입력해 주세요.");
			  return;
		  }
		  if($("#img").val() != ""){
		  var fileName=$("#img").val();
			let ext=fileName.toLowerCase().substring(fileName.lastIndexOf(".")+1);
			var compareExt="png,jpg,gif,bmp".split(",");
			var flag=false;
			for(var i=0; i<compareExt.length; i++){
				if(compareExt[i] == ext){
					flag=true;
					break;
				}//end if
			}//end for
				if(!flag){
					alert(fileName+"은 업로드 불가능 합니다.\n이미지만 업로드 가능합니다. \n 가능 확장자 png,jpg,gif,bmp");
					return;
				}//end if
		  }
		$("#frm").submit();
		
	});//click
	
		  
	}); 
</script>

</body>
</html>