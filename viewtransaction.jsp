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
Integer cusid = (Integer) session.getAttribute("cusid");
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
	String url=application.getInitParameter("url");
    String username=application.getInitParameter("username");
    String password=application.getInitParameter("password");
    Connection con=DriverManager.getConnection(url,username,password);
    String query="select * from transactioninfo where customerid=?";
    PreparedStatement ps=con.prepareStatement(query);
    ps.setInt(1, cusid);

    %>
        
        <table border=1>
    	<tr>
    	<th>transaction id:</th>
    	<th>transaction type:</th>
    	<th>amount:</th>
    	<th>transaction date:</th>
    	</tr>
    <%
    ResultSet rs=ps.executeQuery();
    while(rs.next())
    {
    	%>
    	<tr>
    	<td><%out.println(rs.getInt(1));%></td>
    	<td><%out.println(rs.getString(3));%></td>
    	<td><%out.println(rs.getInt(4));%></td>
    	<td><%out.println(rs.getString(5));%></td>
    	</tr>
    	<%
    }
}
catch (ClassNotFoundException | SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
%>
</table>
</body>
</html>