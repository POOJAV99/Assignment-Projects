<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String m=request.getParameter("msg");
if(m!=null)
{
   out.print(m);
}
%>
<form action="login.jsp">
enter customername:<input type="text" name="uname"/></br>
enter customerpassword:<input type="password" name="pwd"/><input type="submit" value="login"/></br>
</form>
</body>
</html>