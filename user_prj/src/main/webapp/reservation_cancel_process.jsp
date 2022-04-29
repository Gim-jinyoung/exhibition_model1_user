<%@page import="DAO.MyReservationDAO"%>
<%@page import="VO.MyReservationVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     errorPage="/error.jsp"%>
<%			
				String rezNum=request.getParameter("rez_num");
				if(rezNum == null){
					%>잘못된 접근입니다. <%
				}//end if
				String userid=(String)session.getAttribute("id");
				if(userid == null){
					userid="kang@naver.com";
				}//end if
				
				MyReservationVO mrVO=new MyReservationVO();
				mrVO.setRez_num(Integer.parseInt(rezNum));
				mrVO.setUserid(userid);
				
				MyReservationDAO mrDAO=MyReservationDAO.getInstance();
				boolean result=mrDAO.deleteReservation(mrVO);
				
				
				if(result==true){
					response.sendRedirect("reservation_cancel_clear.jsp");
					
				}
				%>
				