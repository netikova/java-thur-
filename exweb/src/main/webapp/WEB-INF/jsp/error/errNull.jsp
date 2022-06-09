<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500</title>
</head>
<body>
    <h1>넌 내게 NULL을 줬어</h1>
    <%=exception %>
    ${pageContext.exception}
</body>
</html>