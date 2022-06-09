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


@WebServlet("/student/addform.do")
public class StuAddFormServlet extends HttpServlet {		
		
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// "http://localhost:8000/exweb/member/list.do"로 요청을 보내면,
		// 웹브라우저에 회원목록이 출력되도록 구현
		
		req.getRequestDispatcher("/WEB-INF/jsp/student/StuAddForm.jsp").forward(req, resp);
///*		req.setCharacterEncoding("UTF-8"); //POST방식으로 전송되는 한글 파라미터 인코딩
//		String aval = req.getParameter("a"); //파라미터의 값이 1개일때	
//		
//		String[] bvals = req.getParameterValues("b"); //파라미터의 값이 여러개일때				
//*/
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html");		
//		PrintWriter out = resp.getWriter();		
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset='UTF-8'>");
//		out.println("<title>Insert title here</title>");
//		out.println("<style>");
//		out.println("table, th, td{border:2px solid #ccc; border-collapse:collapse; padding:10px;}");
//		out.println("th, td{font-size: 20px;}");
//		out.println("th, td{padding:15px; color:blue; text-align:center}");
//		out.println("td{color:blue;}");
//		out.println("tr{padding:15px; color:blue;}");
//		out.println("</style>");
//		out.println("</head>");
//		/*out.println("<body>");
//		out.println("<h1>학생추가</h1>");
//		
//		out.println("<form action='" + req.getContextPath() + "/student/add.do' method='post'>");
//		out.println("학생번호 : <input type='text' name='stu_no' /><br>");
//		out.println("학생이름 : <input type='text' name='stu_name' /><br>");
//		out.println("학생점수 : <input type='text' name='stu_score' /><br>");
//		out.println("<input type='submit'/>");
//		out.println("</form>");
//		
//		out.println("</body>");*/
//		
//		
//		out.println("<body>");
//		out.println("<h1>학생추가</h1>");
//		
//		out.println("<form action='" + req.getContextPath() + "/student/add.do' method='post'>");
//		out.println("<table border='1'>");
//		out.println("<tr>");
//		out.println("<td>"+"학생번호 :" +"<td>" + "<input type='text' name='stu_no' /><br>"+"</td>");
//		out.println("</tr>");
//		out.println("<tr>");
//		out.println("<td>"+"학생이름 :" +"<td>" + " <input type='text' name='stu_name' /><br>"+"</td>");
//		out.println("</tr>");
//		out.println("<tr>");
//		out.println("<td>"+"학생점수 :" +"<td>" + "  <input type='text' name='stu_score' /><br>"+"</td>");
//		out.println("</tr>");
//		out.println("<tr>");
//		out.println("<input type='submit'/>");
//		out.println("</tr>");
//		out.println("</form>");
//		out.println("</table>");
//		out.println("</body>");
//		
//		
//		
//		out.println("</html>");		

	}

}




