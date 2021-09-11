package com.bookassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookaDAO implements BookDAOImpl {

	@Override
	public Connection getConnection() {
		Connection con=null;
		try {
			Class.forName(driverclass);
			con=DriverManager.getConnection(jdbcurl,username,password);
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public void insertBooks(Book b) {
		String query="insert into bookmanagement values(?,?,?,?)";
		try(Connection con=getConnection())
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,b.getBookid());
			ps.setString(2, b.getBookname());
			ps.setString(3, b.getAuthorname());
			ps.setInt(4, b.getPublication());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Book selectBook(int id) {
		Book b=null;
		String query="select * from bookmanagement where bookid=?";
		try(Connection con=getConnection())
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			    b=new Book();
				b.setBookid(id);
				b.setBookname(rs.getString(2));
				b.setAuthorname(rs.getString(3));
				b.setPublication(rs.getInt(4));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Book> selectAllBook() {
		List<Book> booklist=new ArrayList();
		String query="select * from bookmanagement";
		try(Connection con=getConnection())
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Book b=new Book();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthorname(rs.getString(3));
				b.setPublication(rs.getInt(4));
				booklist.add(b);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return booklist;
	}

	@Override
	public boolean deleteBook(int id) {
		boolean result=false;
		String query="delete from bookmanagement where bookid=?";
		try(Connection con=getConnection())
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			result=ps.executeUpdate()>0;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updateStudent(Book b) {
		boolean result=false;
		String query="update bookmanagement set bookname=?,Authorname=?,publication=? where bookid=?";
		try(Connection con=getConnection())
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, b.getBookname());
			ps.setString(2, b.getAuthorname());
			ps.setInt(3, b.getPublication());
			ps.setInt(4, b.getBookid());
			result=ps.executeUpdate()>0;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
