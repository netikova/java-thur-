package com.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// user=XXX 파라미터를 한번이라도 받은 경우, 
// 그 브라우저에는 "사용자 : XXX" 라고 출력
// user=XXX 파라미터를 한번도 받지 못한 경우,
// 그 브라우저에는 "사용자 : 알수 없는 사용자" 라고 출력

// user=XXX 파라미터를 이용하여 접속한 적이 있는 사용자들의 수를
// 현재까지 "누적 사용자 수 : 00명"으로 출력

@WebServlet("/count.do")
public class AttrServlet2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = req.getServletContext();
        AtomicInteger  userCnt = (AtomicInteger)context.getAttribute("cnt");
        if(userCnt == null) {
        	userCnt = new AtomicInteger(0);
        	context.setAttribute("cnt", userCnt);
        }
        //유저가 있을때 userCnt 값을 증가시키고 context에 저장 한다.
        
		HttpSession session = req.getSession();
        
		String un = req.getParameter("user");
		if(un != null && un.length()>0) {
		   userCnt.incrementAndGet();
		   
		   context.setAttribute("cnt", userCnt);
		   session.setAttribute("us", un); //us라는 이름으로 저장
		}
		
		String u = (String) session.getAttribute("us");		
		if(u == null) {
			u = "알수없는사용자";
		}
        
	
		
		
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
		
		out.println("	<h1>사용자: " + u + "</h1>");
		
		out.println("   <h1>누적사용자: " + userCnt + "</h1>");
		
		out.println("</body>");
		out.println("</html>");
	}
}

