<!-- jsp는 자바 안에서 html작성이 불편하기 때문에
html안에 java를 작성하기 위해 사용한다. 주석처리도 다르다. -->
<%@page import="java.util.Date"%>
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
/*     int score = 80;
    pageContext.setAttribute("score", 80); */
%>
pageContext,request,session,servletContext에 속성 저장
 <c:set scope="page" var="score" value="80"></c:set>
 속성제거
 <c:remove scope="page" var="score" />
 조건문
<c:if test="${score>60}">통과</c:if> <!-- 접두어 c로 설정 --> 
<c:choose>
     <c:when test="${score>=90}">최우수</c:when>
     <c:when test="${score>=80}">우수</c:when>
     <c:otherwise>보통</c:otherwise>
</c:choose>
반복문
<%-- <% for(int num = 1; num <= 10; num +=2) out.print(num); %> --%>\

<c:forEach var="num" begin="1" end="10" step="2">${num}</c:forEach>
<ul>
<%-- <%for (int no:arr) out.print("<li>"+no+"</li>");%> --%>
<%-- <c:forEach var="no" items="${ar}"> <li>${no}</li></c:forEach> --%>
<c:forEach var="no" items="${ar}" varStatus="st">
    <li>
    ${no} == ${st.current} 현재값
    ${st.index} 몇번째반복인지(0부터)
    ${st.count} 몇번째반복인지(1부터)
    ${st.first} 첫번째반복인지여부
    ${st.last} 마지막반복인지여부
    ${st.begin} 태그의begin속성값
    ${st.end} 태그의 end속성값
    ${st.step} 태그의 step속성값
        </li>
</c:forEach>
</ul>
<c:forTokens var="tk" items="${'a,b:c,d'}" delims=",:">[${tk}]</c:forTokens> 
<!-- delims = 구별 값 -->
출력
<% pageContext.setAttribute("str", "<h1>제목</h1>"); %> 
<!-- 태그로 해석이 안되고 글자 그대로 표현하기 위해서 명령문을 이용한다. -->
${str}
<c:out value="${str}"></c:out>

주소처리
<a href="menu.jsp">메뉴JSP로이동</a>
<a href="<%=request.getContextPath() %>/menu.jsp">메뉴JSP로이동</a>
<a href="<%=request.getContextPath() %>/exweb/menu.jsp">메뉴JSP로이동</a>
<a href="${pageContext.request.contextPath}/menu.jsp">메뉴JSP로이동</a>
경로가 /로 시작하면 컨텍스트패스를 앞에 자동으로 붙여준다
<a href="<c:url value='/menu.jsp'/>">메뉴JSP로 이동</a>
다른 서블릿 또는 JSP 를 포함
<c:import url="menu.jsp"></c:import>

JSP파일의 내용을 이곳에 복사한 후 하나의 서블릿으로 변환
<%@ include file="menu.jsp" %>
다른 서블릿 또는 JSP를 실행한 결과(출력내용)를 이곳에 포함
<jsp:include page="menu.jsp" />
다른 서블릿 또는 JSPfmf실행한 결과를 포함 
(프로젝트 외부의 사이트 내용 포함 가능)
<c:import url="menu.jsp"/>
<%-- <c:import url="http://google.com"/> --%>

<%-- <% response.sendRedirect(request.getContextPath() + "/menu.jsp"); %> --%>
<%-- <c:redirect url="/menu.jsp"/> --%>

<%-- <c:param/> 태그를 사용하여 주소처리 태그에 파라미터 추가 가능 --%>

예외처리
<c:catch var="e">
    <% int x = 5/0; %>
</c:catch>
예외발생 : ${e.message}

<h2>국제화/포맷팅</h2>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% pageContext.setAttribute("d", new Date()); %>
현재 시간 : ${d}
자바 Date 객체를 원하는 형태의 문자열로 변환 
<fmt:formatDate value="${d}" pattern="yyyy/MM/dd HH:mm:ss"/>
날짜 시간 문자열을 자바 Date 객체로 변환
<fmt:parseDate value="2020/08/15 13:24:56" pattern="yyyy/MM/dd HH:mm:ss" var="d2"/>
${d2}

<% pageContext.setAttribute("n", 1234.56); %>
숫자값을 문자열로 변환
<fmt:formatNumber value="${n}" pattern="###,###.###" />
<fmt:formatNumber value="${n}" pattern="000,000.000" />
숫자문자열을 숫자값으로 변환
<fmt:parseNumber value="12,345,67" pattern="###,###.###" var="n2" /> 
${n2}

JSTL 국제화 태그들이 사용할 로케일 지정 
(미지정시 Accept-Language 요청 헤더 값 사용)
"언어코드_국가코드" 또는 "언어코드-국가코드" 또는 "국가코드"
<fmt:setLocale value="en_US" />

메시지를 저장한 프로퍼티 파일명이
"클래스패스/폴더명/번들명_언어_국가.properties"인 경우
basename은 "폴더명.번들명"
<fmt:setBundle basename="msg" var="mb" />
<fmt:message bundle="${mb}" key="str" />

함수
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<br> ${fn:length("aBcD")} <%="aBcD".length() %>
<br> ${fn:contains("aBcD","Bc")} <%="aBcD".contains("Bc") %>    
<br> ${fn:containsIgnoreCase("aBcD","bC")}  <%="aBcD".toLowerCase().contains("bC".toLowerCase()) %>
<br> ${fn:startsWith("aBcD","aB")} <%="aBcD".startsWith("aB") %>
<br> ${fn:endsWith("aBcD","cD")} <%="aBcD".endsWith("cD") %>
<br> ${fn:escapeXml("<h1>제목</h1>")} <c:out value="<h1>제목</h1>" />
<br> ${fn:indexOf("aBcD","Bc")} <%="aBcD".indexOf("Bc") %>
<br> ${fn:join(ar,"::")} <%=String.join("::", "3,6,9".split(",") )%>
<br> ${(fn:split("a,B:c,D",",:"))[2]} <%="a,B:c,D".split("[,:]")[2] %>
<br> ${fn:replace("aBcDBc","Bc","efg")} <%="aBcDBc".replace("Bc","efg") %>
<br> ${fn:substring("aBcD", 1, 2)} <%="aBcD".substring(1,2) %>
<br> ${fn:substringAfter("aBcD", "Bc")}
<br> ${fn:substringBefore("aBcD", "Bc")}
<br> ${fn:toLowerCase("aBcD")} <%="aBcD".toLowerCase() %>
<br> ${fn:toUpperCase("aBcD")} <%="aBcD".toUpperCase() %>
<br> [${fn:trim("   aB cD  ")}] [<%="   aB cD  ".trim() %>]

</body>
</html>