<%@page import="VO.MemberVO"%>
<%@page import="kr.co.sist.util.img.ImageResize"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.SQLException"%>
<%@page import="DAO.BoardDAO"%>
<%@page import="VO.BoardrVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
      %>
	  <%
	  
	
		//<form enctype="multipart/form-data">라면 FileUpload Component를 사용하여 값을 받는다.
		//1. 업로드 될 파일의 경로 얻기
		File saveDirectory=new File("E:/project2/ImageFile");

		//2.업로드 될 파일의 크기 설정
		int fileSize=1024*1024*10; //10MByte

		//3. 파일 업로드 컴포넌트 생성
		MultipartRequest mr=new MultipartRequest(request, saveDirectory.getPath(),fileSize,"UTF-8", new DefaultFileRenamePolicy());

	  	BoardDAO bDAO=BoardDAO.getInstance();
		  	BoardrVO bVO=new BoardrVO();
		  	
		  	
		  String title=mr.getParameter("title");
		  String desc=(mr.getParameter("ta"));
		  String catNum=mr.getParameter("Exhibition");
		  MemberVO sessionMember=(MemberVO)session.getAttribute("mVO");
			String userId=sessionMember.getUserId();
		  String fileSystemName=mr.getFilesystemName("img");
		 
		  if(fileSystemName == null){
			  fileSystemName="null";
		  }
		
		 
		  bVO.setTitle(title);
		  bVO.setDescription(desc);
		  bVO.setCat_num(Integer.parseInt(catNum));
		  bVO.setUserid(userId);
		  bVO.setImgfile(fileSystemName);
		  
		  	bDAO.insertBoard(bVO);
		  
		  	ImageResize.resizeImage(saveDirectory.getPath()+"/"+fileSystemName, 80, 60);
		  	response.sendRedirect("board.jsp");
		  	
	
	
	%>