<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Integer cusid=(Integer) session.getAttribute("cusid");
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
	String url=application.getInitParameter("url");
    String username=application.getInitParameter("username");
    String password=application.getInitParameter("password");
    Connection con=DriverManager.getConnection(url,username,password);
    String query="select * from accountinfo where customerid=?";
    PreparedStatement ps=con.prepareStatement(query);
    ps.setInt(1, cusid);
    
    ResultSet rs=ps.executeQuery();
    if(rs.next())
    {
    	%>
    	<table border=1>
    	<tr>
    	<th>account id:</th>
    	<td><%out.print(rs.getInt(1));%></td>
    	</tr>
    	<tr>
    	<th>account type:</th>
    	<td><%out.print(rs.getString(3));%></td>
    	</tr>
    	<tr>
    	<th>account open date:</th>
    	<td><%out.print(rs.getString(5));%></td>
    	</tr>
    	<tr>
    	<th>account status:</th>
    	<td><%out.print(rs.getString(6));%></td>
    	</tr>
    	</table>
    	<%
    }
    else
    {
    	out.print("Nothing to view");
    }
}
catch (ClassNotFoundException | SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
%>
</body>
</html>