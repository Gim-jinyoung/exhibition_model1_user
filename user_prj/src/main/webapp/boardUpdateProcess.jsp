<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@page import="DAO.BoardDAO"%>
<%@page import="VO.BoardrVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
  %>
<%
File saveDirectory=new File("C:/Users/user/git/user_prj/user_prj/src/main/webapp/ImageFile");

//2.업로드 될 파일의 크기 설정
int fileSize=1024*1024*10; //10MByte

//3. 파일 업로드 컴포넌트 생성
MultipartRequest mr=new MultipartRequest(request, saveDirectory.getPath(),fileSize,"UTF-8", new DefaultFileRenamePolicy());

BoardDAO bDAO=BoardDAO.getInstance();
	BoardrVO bVO=new BoardrVO();
	
	String bd_id=mr.getParameter("hid");
String title=mr.getParameter("title");
String desc=(mr.getParameter("ta"));
String catNum=mr.getParameter("Exhibition");
String userId=(String)session.getAttribute("id");
if(mr.getFilesystemName("img") != ""){
String fileSystemName=mr.getFilesystemName("img");
bVO.setImgfile(fileSystemName);
}
		 if(userId == null){
			  userId="kang@naver.com";
		  }
		 
			bVO.setTitle(title);
			bVO.setDescription(desc);
			bVO.setCat_num(Integer.parseInt(catNum));
			bVO.setBd_id(Integer.parseInt(bd_id));
			bVO.setUserid(userId);
			boolean result=bDAO.updateBoard(bVO);
			
			if(result){
			response.sendRedirect("boardDetail.jsp?value="+bd_id);
			}
		%>