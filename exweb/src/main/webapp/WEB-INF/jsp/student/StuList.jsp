<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.exam.student.StuVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.exam.student.StuDaoJdbc"%>
	
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset='UTF-8'>
		<title>Insert title here</title>
		</head>
		<body>
		<h1>회원목록</h1>
	    <a href='${pageContext.request.contextPath}/student/add.do'>회원추가</a><br>
		회원아이디 : 회원비밀번호 : 회원이름 : 회원포인트<br>	
	  
<c:forEach var="vo" items="${stuList}">  <!-- 태그라이버리를 쓴다고 위에 선언 -->	
		<a href="${pageContext.request.contextPath}/student/edit.do?stu_no=${vo.stuNo}"><c:out value= "${vo.stuNo}"/></a>	   
			    : <c:out value= "${vo.stuName}"/>  : "${vo.stuScore}"
			    <a href = '${pageContext.request.contextPath}/student/del.do?stu_no=${vo.stuNo}'>삭제</a><br>	
</c:forEach>	
			   

		
		</body>
		</html>
	
	
    