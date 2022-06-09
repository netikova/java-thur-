<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.exam.member.MemberDaoJdbc"%>

<%!MemberDaoJdbc memberDao = new MemberDaoJdbc();%>
<%
request.setCharacterEncoding("UTF-8");       
String memId = request.getParameter("memId");        
int num = memberDao.delMember(memId);

//resp.sendRedirect("이동할 사이트 주소"); 명령을 사용하여,
// 웹브라우저에게 특정 사이트로 이동하라는 명령을 담은 응답을 전송
response.sendRedirect(request.getContextPath() + "/Memlist.jsp");
%>