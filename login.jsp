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
      String u=request.getParameter("uname");
     Integer p=Integer.parseInt(request.getParameter("pwd"));
     try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    		String url=application.getInitParameter("url");
    	    String username=application.getInitParameter("username");
    	    String password=application.getInitParameter("password");
    	    Connection con=DriverManager.getConnection(url,username,password);
    	    String query="select * from customerinfo where customername=? and customerpassword=?";
    	    PreparedStatement ps=con.prepareStatement(query);
    	    ps.setString(1, u);
    	    ps.setInt(2, p);
    	    
    	    ResultSet rs=ps.executeQuery();
    	    if(rs.next())
    	    {
    	    	session.setAttribute("cusid", rs.getInt(1));
    	    	out.println("Welcome to "+u+"!!");
    	    	%>
    	    	<table border=1>
    	    	<tr>
    	    	<td><a href="viewprofile.jsp">View profile</a></td>
    	    	</tr>
    	    	<tr>
    	    	<td><a href="viewaccountinfo.jsp">View account information</a></td>
    	    	</tr>
    	    	<tr>
    	    	<td><a href="viewtransaction.jsp">View transaction</a></td>
    	    	</tr>
    	    	<tr>
    	    	<td><a href="viewbalance.jsp">View balance</a></td>
    	    	</tr>
    	    	<tr>
    	    	<td><a href="amounttodeposit.jsp">Deposit</a></td>
    	    	</tr>
    	    	<tr>
    	    	<td><a href="amounttowithdraw.jsp">Withdraw</a></td>
    	    	</tr>
    	    	</table>
    	    	<%
    	    }
	    else
	    {
	    	String message="Invalid username and password";
	    	response.sendRedirect("index.jsp?msg="+message);
	    }
}
catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
%>
</body>
</html>