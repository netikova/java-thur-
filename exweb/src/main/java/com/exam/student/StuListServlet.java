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

// 웹블라우저에서 "http://localhost:8000/exweb/student/list.do"로 접속하면 
// 학생목록이 출력되도록 구현

@WebServlet("/student/list.do")
public class StuListServlet extends HttpServlet {		
	StuDao memberDao = new StuDao();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// "http://localhost:8000/exweb/member/list.do"로 요청을 보내면,
		// 웹브라우저에 회원목록이 출력되도록 구현
		ArrayList<StuVo> list = memberDao.selectList();		
		
/*		req.setCharacterEncoding("UTF-8"); //POST방식으로 전송되는 한글 파라미터 인코딩
		String aval = req.getParameter("a"); //파라미터의 값이 1개일때	
		
		String[] bvals = req.getParameterValues("b"); //파라미터의 값이 여러개일때				
*/
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
		out.println("<h1>회원목록</h1>");
		out.println("회원번호 : 회원이름 : 회원포인트<br>");	
		 for(int i = 0 ; i < list.size(); i++) {
			   StuVo vo = list.get(i);
			    out.println(vo.getStu_no() +" : "+vo.getStu_name()+ " : " +vo.getStu_score()+  "<br>");			
		    }
		
		out.println("</body>");
		out.println("</html>");
		
		// http://localhost:8000/exweb/welcome.do?user=abc
		// 로 요청을 보내면, 브라우저 화면에 큰 제목으로
		// abc 님 환영합니다
		// 라고 출력되도록 구현
	}

}




