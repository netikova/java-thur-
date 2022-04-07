package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//자동완성을 해야 import가 정확한 위치에 가게된다.
//요청을 받았을때 실행되는 서블릿으로 등록하고,
//"/bye.do" 주소로 요청이 오면 실행

//웹브라우저에서 요청을 보낼 때, 추가적인 정보를 전송 가능
// 요청주소?파라미터명=파라미터값
// http://localhost:8000/exweb/param.do?a=123
// 서블릿에서는 요청객체.getParameter("파라미터명") 명령으로
// 파라미터값을 읽어서 사용 가능

@WebServlet("/order.do")
public class orderServlet extends HttpServlet {
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); //POST방식으로 전송되는 한글 파라미터 인코딩
		//String aval = req.getParameter("a"); //파라미터의 값이 1개일때	
		
		//String[] bvals = req.getParameterValues("b"); //파라미터의 값이 여러개일때
		
		String name = req.getParameter("user"); 		
		String[] order = req.getParameterValues("ord");
		
		
		 
		
		
		//출력스트림을 가져오기 전에 응답객체의 문자인코딩 설정
		resp.setCharacterEncoding("UTF-8");
		//응답내용이 HTML 문서 텍스트임을 클라이언트에게 알려줌
		resp.setContentType("text/html");
		//응답내용의 문자인코딩과 문서형식을 동시에 설정 가능
		//resp.setContentType("text/html;charset=UTF-8");		
		
		PrintWriter out = resp.getWriter();
//		out.println("<h1>Bye Bye</h1>");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");		
		
//		int foodCount = 0;
//		if(foods != null) {
//			foodCount = foods.length;
//			for(int i = 0; i < foods.length; i++) {
//				out.println("<li>" + foods[i] + "<li>");
//			}
//		}
		
		
		out.println(name +"님은 총" + order.length +"개의 음식을 주문했습니다.");
		for(int i = 0; i<order.length; i++) {
		 //String food = order[i];
		 switch(order[i]) 
		 {
		   case "p001": 
			   out.println("<li>피자</li>"); 
			   break;
		   case "p002": 
			   out.println("<li>햄버거</li>"); 
			   break;
		   case "p003": 
			   out.println("<li>돈까스</li>"); 
			   break;
		   case "p101": 
			   out.println("<li>딸기쥬스</li>"); 
		       break;
		   case "p102": 
			   out.println("<li>키위</li>"); 
			   break;
		   	   
		 }
		}
		// out.println(order);
		
		

		
		out.println("</body>");
		out.println("</html>");
		
		// http://localhost:8000/exweb/welcome.do?user=abc
		// 로 요청을 보내면, 브라우저 화면에 큰 제목으로
		// abc 님 환영합니다
		// 라고 출력되도록 구현
	}

}




