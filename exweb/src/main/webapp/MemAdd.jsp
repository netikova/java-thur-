<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.exam.member.MemberVo"%>
<%@page import="com.exam.member.MemberDaoJdbc"%>

<%!MemberDaoJdbc memberDao = new MemberDaoJdbc(); //선언부%>

<%
request.setCharacterEncoding("UTF-8");
MemberVo vo = new MemberVo();
vo.setMemId(request.getParameter("memId"));
vo.setMemPass(request.getParameter("memPass"));
vo.setMemName(request.getParameter("memName"));
vo.setMemPoint(Integer.parseInt(request.getParameter("memPoint")));
int num = memberDao.insertMember(vo);

//resp.sendRedirect("이동할 사이트 주소"); 명령을 사용하여,
// 웹브라우저에게 특정 사이트로 이동하라는 명령을 담은 응답을 전송 
response.sendRedirect(request.getContextPath() + "/MemList.jsp");
%>