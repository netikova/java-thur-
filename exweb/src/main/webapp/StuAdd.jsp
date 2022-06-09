<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.exam.student.StuDao"%>
<%@page import="com.exam.student.StuVo"%>
  
<%!
   StuDao StuDao = new StuDaoJdbc();//선언부    
%>  

<%    
    request.setCharacterEncoding("UTF-8");
	StuVo vo = new StuVo();
    vo.setStu_no(request.getParameter("stu_no"));
    vo.setStu_name(request.getParameter("stu_name"));
    vo.setStu_score(Integer.parseInt(request.getParameter("stu_score")));       
    int num = StuDao.insert(vo);		
    
    response.sendRedirect(request.getContextPath() + "/StuList.jsp");
%> 
      