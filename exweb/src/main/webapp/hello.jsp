<!-- jsp는 자바 안에서 html작성이 불편하기 때문에
html안에 java를 작성하기 위해 사용한다. 주석처리도 다르다. -->
<%@page import="java.util.HashMap"%>
<%@page import="com.exam.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<%@ include file="menu.jsp"%>
<h1>JSP(Java Server Page)</h1>
HTML 문서 내에 JAVA 코드를 삽입 = HTML의 탈을 쓴 서블릿
hello.jp 파일을 요청하면, 톰캣은 hello.jp 파일을 서블릿으로 변환하여 실행
<%-- 
JSP 구성요소
- 디렉티브 : page(현재JSP페이지에 대한 설정), include(다른JSP파일포함), taglib(태그라이브러리사용)
    <%@ 디렉티브명 속성명="속성값" 속성명="속성값" %>
- 스크립트요소  
   - 스크립트릿 : <% 서블릿의 service()내부에 들어갈 자바코드 %>
   - 표현식 : <%= 현재위치에 결과값을 출력할 자바코드 %>
   - 선언 : <%! 서블릿의 service()외부에 들어갈 자바코드 %>  
   - 주석 : <% 자바코드 %>  
- 액션태그 : 자주 사용하는 자바코드를 대체할 수 있는 태그
- EL
- 커스텀태그 
--%>
<h2>스크립트릿</h2>
<%  //서블릿의 service() 메서드 내부에 작성하는 것처럼 자유롭게 자바 코드 작성
    String local = "지역변수";
    System.out.println(local);
    //변수 선언 없이 사용가능한 JSP 기본객체들
//    request(요청객체), response(응답객체), session(세션객체), application(서블릿컨텍스트객체)
//    out(응답출력스트림), config(ServletConfig객체) 
//    pageContext(현재JSP파일에대한모든정보를포함) 
//    page(현재JSP객체), exception(발생한예외)

      out.println("브라우저에출력할내용");
      out.println( session == request.getSession() );      
      out.println( application == request.getServletContext() );
      out.println( config == getServletConfig() );
      pageContext.setAttribute("pa","pv"); //현재JSP파일에서만 사용가능한 데이터저장
      // pageContext에는 다른 JSP 기본객체들이 모두 저장되어 있다
      out.println( request == pageContext.getRequest() );
      out.println( response == pageContext.getResponse() );
      out.println( session == pageContext.getSession() );
      out.println( application == pageContext.getServletContext() );
      out.println( page == this);   
%>

<h2>표현식</h2>
<% out.print(local); %>
<%=local %>
<h2>선언부</h2>
<%=global %>
<%! String global = "전역변수"; %> <!-- 바깥쪽에 선언해주는 표현 방식으로 !를 써준다. -->
<h2>액션태그</h2>
<%
    MemberVo v = (MemberVo)pageContext.getAttribute("m");
    if(v==null){
    	v = new MemberVo();
    	pageContext.setAttribute("m", v);
    }
    v.setMemId("a001");
    out.print(v.getMemId()); 
%>
<%-- <jsp:useBean id="m" class="com.exam.member.MemberVo" scope="page"></jsp:useBean>
<jsp:setProperty property="memId" name="m" value="a001" />
<jsp:getProperty property="memId" name="m"/> --%>
<%
    //forward : 현재 서블릿(JSP) 실행을 중단하고 다른 서블릿(JSP)를 실행
    //include : 다른 서블릿(JSP)의 실행 결과를 현재 위치에 포함
/*     request.getRequestDispatcher("menu.jsp").forward(request, response);	
    request.getRequestDispatcher("menu.jsp").include(request, response);	 */
%>
<%-- <jsp:forward page="menu.jsp"></jsp:forward> --%>
<jsp:include page="menu.jsp"></jsp:include>
<h1>EL(Expression Language)</h1>
JSP 표현식과 유사
${123} ${"문자열1"} ${'문자열2'} ${3+4}
EL에서 xxx라고 쓰면, 변수이름이 아니라 pageContext,request,session,application에 저장된 속성을 의미
<%
    String s = "야채피자";
    pageContext.setAttribute("pcs", s);
    int[] arr = {3,6,9};
    pageContext.setAttribute("ar", arr);
    HashMap map = new HashMap();
    map.put("k", "v");
    pageContext.setAttribute("ma", map);
%>
<%=s %> ${pcs} <br>
배열의 1번칸의 값 : <%=arr[1] %> ${ar[1]} <br>
맵에 "k"라는 이름으로 저장된 값 : <%=map.get("k") %> ${ma.get("k")} ${ma.k} ${ma["k"]} <br>
객체의 getXxx() 속성값 : <%=v.getMemId() %> ${m.getMemId()} ${m.memId} ${m["memId"]} <br>
<%
    pageContext.setAttribute("pa", 12);
    request.setAttribute("ra", 23);
    session.setAttribute("sa", 56);
    application.setAttribute("aa", 78);
%>
<%=pageContext.getAttribute("pa") %> <%-- 전부 다 같은 의미 --%> ${pageScope.pa} ${pageScope['pa']} ${pa}<br>
<%=request.getAttribute("ra") %> <%-- 전부 다 같은 의미 --%> ${requestScope.ra} ${requestScope['ra']} ${ra}<br>
<%=session.getAttribute("sa") %> <%-- 전부 다 같은 의미 --%> ${sessionScope.sa} ${sessionScope['sa']} ${sa}<br>
<%=application.getAttribute("aa") %> <%-- 전부 다 같은 의미 --%> ${applicationScope.aa} ${applicationScope['aa']} ${aa}<br>
xxxScope을 생략하면, pageScope > requestScope > sessionScope > applicationScope 순서로 탐색하여 먼저 발견되는 속성값을 사용
EL 사용시, null 값은 오류를 발생시키지 않고 화면에 출력이 없음
<%-- <%=request.getAttribute("xxx") %>이런이름으로 저장한적이 없어서 null
<%=request.getAttribute("xxx").equals("yyy") %>null값을 비교하는 문이라 에러 --%>
${requestScope.xxx}
${requestScope.xxx.yyy}
EL에서 별도의 변수선언 없이 사용 가능한 기본객체 (JSP기본객체와 다르다)
<br>
파라미터값: <%=request.getParameter("x") %> ${param.x} ${param['x']}
<%-- 파라미터값: <%=request.getParameterValues("x")[0] %> ${paramValues.x[0]} ${paramValues['x'][0]} --%>
헤더값 : <%=request.getHeader("User-Agent") %> ${header.User-Agent} ${header['User-Agent']}
헤더값이 여러개인 경우 : headerValues 사용
쿠키값 : 
<%=request.getCookies()[0].getName() %> ${cookie.JSESSIONID.name}
<%=request.getCookies()[0].getValue() %> ${cookie.JESSIONID.value}
초기화파라미터값 : <%=config.getInitParameter("x") %> ${initParam.x}
EL에서 JSP 기본객체를 사용하고 싶은 경우, pageContext를 통해서 사용
<%=request.getContextPath() %>
${pageContext.request.contextPath} <%--EL로 작성할 때는 속성의 첫글자는 소문자로 작성하여야 한다. --%>
<h1>JSTL(JSP Standard Tag Library)</h1>
프로젝트에 JSTL 라이브러리 추가
현재 JSP 파일에서 사용하고 싶은 태그라이브러리를 taglib 디렉티브로 지정
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    int score = 80;
    pageContext.setAttribute("score", 80);
%>
<c:if test="${score>60}">통과</c:if> <!-- 접두어 c로 설정 -->
<c:choose>
     <c:when test="${score>=90}">최우수</c:when>
     <c:when test="${score>=80}">우수</c:when>
     <c:otherwise>보통</c:otherwise>
</c:choose>

<c:forEach var="num" begin="1" end="10" step="2">${num}</c:forEach>

</body>
</html>