<%@page import="VO.MemberVO"%>
<%@page import="DAO.UserReservationDAO"%>
<%@page import="VO.ReservationManagerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     %>
<%
	   String date=request.getParameter("pick_up_date");
	  String count=request.getParameter("people");
	  String exNum=request.getParameter("exNum");
	  MemberVO sessionMember=(MemberVO)session.getAttribute("mVO");
		String userid=sessionMember.getUserId(); 
	  
	 

	  UserReservationDAO urDAO=UserReservationDAO.getInstance();
	  ReservationManagerVO rVO=new ReservationManagerVO();
	  rVO.setRez_count(Integer.parseInt(count));
	  rVO.setVisit_date(date);
	  rVO.setEx_num(Integer.parseInt(exNum));
	  rVO.setUserid(userid);
	  rVO.setRez_status('t');
	  
	  urDAO.insertReservation(rVO); 
	  
	  response.sendRedirect("reservation_clear.jsp");
	 %>  