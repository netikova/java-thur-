<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.exam.student.StuDao"%>
<%@page import="com.exam.member.MemberDaoJdbc"%>

<%!
     StuDao StuDao = new StuDao();
%>  
    
    
<%   request.setCharacterEncoding("UTF-8");       
     String stu_no = request.getParameter("stu_no");        
     int num = StuDao.delete(stu_no);

          
     response.sendRedirect(request.getContextPath() + "/Stulist.jsp");
%>