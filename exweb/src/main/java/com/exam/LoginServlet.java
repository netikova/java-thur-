package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idVal = req.getParameter("id");
		String pwVal = req.getParameter("pw");
		
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
		
		if ( idVal.equals("user") ) {
			if ( pwVal.equals("1234") ) {
				out.println("  <h1>사용자 화면</h1>");
			}else {
				out.println("  <h1>로그인 실패</h1>");
			}
		}else if ( idVal.equals("admin") ) {
			if ( pwVal.equals("qwer") ) {
				out.println("  <h1>관리자 화면</h1>");
			}else {
				out.println("  <h1>로그인 실패</h1>");
			}
		}else {
			out.println("  <h1>등록되지 않은 사용자</h1>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}
}










