package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;

@WebServlet("/photo.do")
public class PhotoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String s = req.getParameter("ani");
		
		
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
		
		if (s.equals("bear")) {
			out.println("  <img src='https://picsum.photos/id/1020/200/300' /> ");
		} else if (s.equals("eagle")) {
			out.println("  <img src='https://picsum.photos/id/1024/200/300' /> ");
		} else if (s.equals("dog")) {
			out.println("  <img src='https://picsum.photos/id/1025/200/300' /> ");
		} else {
			out.println("  <h1>알 수 없는 동물입니다</h1>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}
}

// http://localhost:8000/exweb/login.do?id=아이디&pw=비밀번호
// 로 요청을 보내면,
// 아이디가 "user" 이고 
//		비밀번호가 "1234" 이면, "사용자 화면" 출력
//		비밀번호가 "1234"가 아니면, "로그인 실패" 출력
// 아이디가 "admin" 이고 
//		비밀번호가 "qwer" 이면, "관리자 화면" 출력
//		비밀번호가 "qwer"가 아니면, "로그인 실패" 출력
// 다른 아이디면, "등록되지 않은 사용자" 출력 









