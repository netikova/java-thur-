package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청을 받았을때 실행되는 서블릿으로 등록하고,
//"/bye.do" 주소로 요청이 오면 실행
@WebServlet("/bye.do")
public class ByeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ByeServlet 실행!");
		
		//출력스트림을 가져오기 전에 응답객체의 문자인코딩 설정
		resp.setCharacterEncoding("UTF-8");
		//응답내용이 HTML 문서 텍스트임을 클라이언트에게 알려줌
		resp.setContentType("text/html");
		//응답객체에 응답내용을 쓸 수 있는 출력스트림 가져오기
		PrintWriter out = resp.getWriter();
		//응답객체에 출력한 내용이 클라이언트(웹브라우저)에게 전송된다
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>Bye Bye</h1>");
		out.println("	<h2>안녕히 가세요</h2>");
		out.println("</body>");
		out.println("</html>");
	}
}

