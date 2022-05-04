<%@page import="VO.MyReservationVO"%>
<%@page import="DAO.MyReservationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     %>
<!DOCTYPE html>
<html>
    <head>

        <!-- /.website title -->
        <title>예약 취소</title>
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

    <body data-spy="scroll" data-target="#navbar-scroll">

      

        
        
        
        <!-- /.Cars section -->
        <div id="sign-in" style="float: left">
            <div class="container">
                <div class="col-sm-6">
                    <div class="text-center">
                        <h2 class="wow fadeInLeft">전시설명/예약정보</h2>
                        <br/>
                        <h2 class="wow fadeInLeft">예약을 취소하시겠습니까?</h2>
                        <div class="title-line wow fadeInRight"></div>
                    </div>
					
                    <div class="row sign-in">
                        <form action="my-account.jsp" method="post">
                            <%String rez_num=request.getParameter("rez_num");
                            	pageContext.setAttribute("rez_num",rez_num);
                            %>
                            <div class="text-center">
                              <a href="reservation_cancel_process.jsp?rez_num=${rez_num }" ><input type="button"  class="btn btn-warning "  style="width:80px " value="예"></a> 
                              &nbsp;&nbsp;&nbsp;&nbsp; 
                              <a href="index.jsp"><input type="button"  class="btn btn-warning" value="아니요" style="width:80px "></a>  
                            </div>
                        </form>

                    </div>
                </div>
            
</div>
</div>

        
   


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