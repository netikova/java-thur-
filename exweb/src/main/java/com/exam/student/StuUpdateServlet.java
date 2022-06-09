package com.exam.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/student/update.do")
public class StuUpdateServlet extends HttpServlet {		
	StuDao StuDao = new StuDao();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		StuVo vo = new StuVo();
        vo.setStu_no(req.getParameter("stu_no"));
        vo.setStu_name(req.getParameter("stu_name"));
        vo.setStu_score(Integer.parseInt(req.getParameter("stu_score")));       
        int num = StuDao.insert(vo);		
      
        
        
        //resp.sendRedirect("이동할 사이트 주소"); 명령을 사용하여,
        // 웹브라우저에게 특정 사이트로 이동하라는 명령을 담은 응답을 전송
//       resp.sendRedirect("http://localhost/member/list.do");
        resp.sendRedirect(req.getContextPath() + "/student/list.do");
/*
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");		
		PrintWriter out = resp.getWriter();		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>회원추가</h1>");
		
		out.println( num + "명의 회원이 추가되었습니다.");
		
		
		out.println("</body>");
		out.println("</html>");		
*/		

	}

}




