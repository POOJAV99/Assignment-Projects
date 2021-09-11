package com.bookassignment;

import java.sql.Connection;
import java.util.List;

public interface BookDAOImpl {
	public static final String jdbcurl="jdbc:mysql://localhost:3306/javasql";
	public static final String driverclass="com.mysql.cj.jdbc.Driver";
	public static final String username="pooja";
	public static final String password="Pooja";
	Connection getConnection();
	void insertBooks(Book b);
	Book selectBook(int id);
	List<Book> selectAllBook();
	boolean deleteBook(int id);
	boolean updateStudent(Book b);
}
