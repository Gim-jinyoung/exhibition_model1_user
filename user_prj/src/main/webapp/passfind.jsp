<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="/error.jsp"%>
<!DOCTYPE html>
<html>
    <head>

        <!-- /.website title -->
        <title>VTC Theme | FQA Page</title>
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
                        <h2 class="wow fadeInUp" style="margin-bottom: 50px">
                           ???????????? ??????
                        </h2>

                    </div>
                </div> 
            </div> 
        </div>
        
        
            <!-- NAVIGATION -->
        

        <!-- /.Cars section -->
        <div id="sign-in" style="margin-left: 30%">
            <div class="container">
                <div class="col-sm-6">
                    <div class="text-center">
                        <h2 class="wow fadeInLeft">???????????? ??????</h2>
                        <div class="title-line wow fadeInRight"></div>
                    </div>
                    <div class="row sign-in">

                        <form action="passfind_process.jsp" method="post" id="frm" >
                            <div class="form-group">
                                <label for="name">??????</label>
                                <input class="form-control" id="name" type="text" name="name" value="">
                            </div>
                             <div class="form-group">
                                <label for="id">?????????</label>
                                <input class="form-control" id="userId" name="userId" type="text" value="">
                            </div>
                            <div class="form-group">
                                <label for="phone_num">????????????</label>
                                <input class="form-control" id="tel" name="tel" type="text" value="">
                            </div>
                            
                            <div class="text-center">
                              <input type="button" class="btn btn-warning btn-block btn-lg"  id="pass_find" value="next>">
                            </div>
              
                        </form>

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
                            <h4>?????? ??????</h4>
                            <p><strong>3???</strong>
                                <br>?????? ?????? :081) 123-1234  
                                <br>?????? ?????? ??????: AM 10:00~PM 05:00
                                <br>?????? ?????????: exhibition@naver.com
                            </p>
                            <hr class="hidden-md hidden-lg">
                        </div> 

                        
                        <!-- /.col-md-4 -->
                        
                        <div class="col-md-4 col-sm-6">
                            <h4>????????? ????????????</h4>
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



<script type="text/javascript">


$(function(){
	$("#pass_find").click(function(){
		var name=$("#name").val();
		var id=$("#userId").val();
		var phone=$("#tel").val();
		
		if(name==""){
			alert("????????? ???????????????.");
			return;
		}else if(id==""){
			alert("???????????? ???????????????.");
			return;
		}else if(phone==""){
			alert("?????????????????? ???????????????.");
			return;
		}
		$("#frm").submit();
	});
});
</script>
        <script>
            new WOW().init();

        </script>

    </body>
</html>