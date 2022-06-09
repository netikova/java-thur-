<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.exam.student.StuVo"%>
<%@page import="com.exam.student.StuDao"%>
<%@page import="java.util.ArrayList"%>
    
<%!
     StuDao StuDao = new StuDao();
%>


<%        
    ArrayList<StuVo> list = StuDao.selectList();
%>    
	
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset='UTF-8'>
		<title>Insert title here</title>
		
		<style>
		table, th, td{border:2px solid #ccc; border-collapse:collapse; padding:10px;}
		th, td{font-size: 20px;}
		th, td{padding:15px; color:blue; text-align:center}
		td{color:red;}
		tr{padding:15px; color:blue;}
		</style>
		</head>
		<body>
	    <h1>회원목록</h1>
		<a href='<%=request.getContextPath()%>/StuAddForm.jsp'><h3>회원추가</h3></a><br>
		<a href='<%=request.getContextPath()%>/StuUpdateForm.jsp'><h3>회원수정</h3></a><br>
<%		
            for(int i = 0 ; i < list.size(); i++) {
			   StuVo vo = list.get(i);
%>
			   <table border='1'>
			<tr>
			<th>학생번호</th>
			<th>학생이름</th>
			<th>학생점수</th>
			</tr>
			<tr>
			<td><%=vo.getStu_no()%></td>
			<td><%=vo.getStu_name()%></td>
			<td><%=vo.getStu_score()%></td>
			<td><a href='<%=request.getContextPath()%>/StuUpdateForm.jsp'>회원수정</a><br></td>
			<td><a href = '<%=request.getContextPath()%>/student/del.do?stu_no=<%=vo.getStu_no()%>'>삭제</a><br></td>
			</tr>
			</table>
<%			
		    }
%>		
            </body>
	     	</html>
   