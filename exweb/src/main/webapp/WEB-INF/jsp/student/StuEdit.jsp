<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보변경</h1>

	<form action='<%=request.getContextPath() %>/student/edit.do' method='post'>
		학생번호 : <input type='text' name='stu_no' value="${stuVo.stuNo}" readonly="readonly"/><br> 
		학생이름 : <input type='password' name='stu_name' value="${stuVo.stuName}" /><br> 
		학생점수 : <input type='text' name='stu_score' value="${stuVo.stuScore}" /><br>
		<input type='submit' />
	</form>
	

</body>
</html>

