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
    String query="select * from customerinfo where customerid=?";
    PreparedStatement ps=con.prepareStatement(query);
    ps.setInt(1, cusid);
    
    ResultSet rs=ps.executeQuery();
    if(rs.next())
    {
    	%>
    	<table border=1>
    	<tr>
    	<th>customer id:</th>
    	<td><%out.print(rs.getInt(1));%></td>
    	</tr>
    	<tr>
    	<th>customer name:</th>
    	<td><%out.print(rs.getString(2));%></td>
    	</tr>
    	<tr>
    	<th>customer city:</th>
    	<td><%out.print(rs.getString(3));%></td>
    	</tr>
    	<tr>
    	<th>customer address:</th>
    	<td><%out.print(rs.getString(4));%></td>
    	</tr>
    	<tr>
    	<th>customer mobile:</th>
    	<td><%out.print(rs.getInt(5));%></td>
    	</tr>
    	<tr>
    	<th>PAN:</th>
    	<td><%out.print(rs.getInt(6));%></td>
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