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
Integer amt=Integer.parseInt(request.getParameter("amount"));
boolean result=false;
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url=application.getInitParameter("url");
    String username=application.getInitParameter("username");
    String password=application.getInitParameter("password");
    Connection con=DriverManager.getConnection(url,username,password);
    
    String query="select * from accountinfo where customerid=?";
    PreparedStatement ps=con.prepareStatement(query);
    ps.setInt(1, cusid);
    ResultSet rs=ps.executeQuery();
    
    String query1="update accountinfo set accountbalance=? where customerid=?";
	PreparedStatement ps1=con.prepareStatement(query1);
	if(rs.next())
	{
	ps1.setInt(1, rs.getInt(4)+amt);
	ps1.setInt(2,cusid);
    }
	result=ps1.executeUpdate()>0;
	if(result)
	{
		out.println("balance updated");
		%>
		<br/>
		<a href="viewbalance.jsp">View balance</a>
		
		<%
	}
	else
	{
		out.println("please enter atlest 1rs");
	}
	
} 
catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

%>
</body>
</html>