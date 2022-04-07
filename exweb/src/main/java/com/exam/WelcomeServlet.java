package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome.do")
public class WelcomeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		GET방식으로 전송된 한글 파라미터 값 인코딩 설정:
//		    톰캣 설정 파일 server.xml에서
//		    <Connector port="8000" URIEncoding="UTF-8" ...>
//          톰캣8버전부터 "UTF-8"이 디폴트값이므로 생략가능
//		POST방식으로 전송된 한글 파라미터 값 인코딩 설정:
//         파라미터값을 읽기 전에, 요청객체의 문자인코딩방식을 설정	
//         요청객체.setCharacterEndcoding("문자인코딩방식")
		
		
		req.setCharacterEncoding("UTF-8");
		//크롬이 보내온 정보를 어떻게 해석할거냐
		String u = req.getParameter("user");
		
		resp.setCharacterEncoding("UTF-8");
		//크롬에서 받아온 정보를 어떤걸로 인코딩해서 보여줄거냐
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>" + u + " 님 환영합니다</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}

// http://localhost:8000/exweb/add.do?x=123&y=456
// 로 요청을 보내면,
// 123 + 456 = 579 
// 라고 출력되도록 서블릿을 구현








