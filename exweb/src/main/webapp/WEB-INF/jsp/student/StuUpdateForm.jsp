<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>학생수정</h1>
		
	<form action='<%=request.getContextPath()%>/StuUpdate.jsp' method='post'>
	학생번호 : <input type='text' name='stu_no' /><br>
	학생이름 : <input type='text' name='stu_name' /><br>
	학생점수 : <input type='text' name='stu_score' /><br>
	<input type='submit'/>
	</form>
		
	
</body>
</html>