package com.bookassignment;

import java.util.List;
import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		int choice=0;
		System.out.println("Enter a number:");
		Scanner sc=new Scanner(System.in);
		BookaDAO bkdao=new BookaDAO();
		do
		{
		System.out.println("Welcome to Book management system");
        System.out.println("Choose from following option :");
        System.out.println("1. Add Book");
        System.out.println("2. Get Book");
        System.out.println("3. All Book details");
        System.out.println("4. Delete Book");
        System.out.println("5. Update Book");
        System.out.println("6. Exit");
        choice=sc.nextInt();
        switch(choice)
        {
        case 1:
        {
        	System.out.println("Enter bookid,bookname,Authorname,publication");
        	Book b=new Book();
        	b.setBookid(sc.nextInt());
        	b.setBookname(sc.next());
        	b.setAuthorname(sc.next());
        	b.setPublication(sc.nextInt());
        	bkdao.insertBooks(b);
        	System.out.println("Value added sucessfully");
        	break;
        }
        case 2:
        {
        	System.out.println("Enter bookid");
        	Book b=bkdao.selectBook(sc.nextInt());
        	System.out.println(b.getBookid()+" | "+b.getBookname()+" | "+b.getAuthorname()+" | "+b.getPublication());
        	break;
        }
        case 3:
        {
        	List<Book> books=bkdao.selectAllBook();
        	for(Book bs:books)
        	{
        		System.out.println(bs);
        	}
        	break;
        }
        case 4:
        {
        	System.out.println("Enter bookid");
        	boolean b=bkdao.deleteBook(sc.nextInt());
        	if(b)
        	{
        		System.out.println("book deleted sucessfully");
        	}
        	else
        	{
        		System.out.println("no book with that id");
        	}
        	break;
        }
        case 5:
        {
        	System.out.println("Enter bookid,bookname,Authorname,publication");
        	Book b=new Book();
        	b.setBookid(sc.nextInt());
        	b.setBookname(sc.next());
        	b.setAuthorname(sc.next());
        	b.setPublication(sc.nextInt());
        	boolean b1=bkdao.updateStudent(b);
        	if(b1)
        	{
        		System.out.println("Book updated successfully");
        	}
        	else
        	{
        		System.out.println("Invalid id given");
        	}
        	break;
        }
        case 6:
        {
        	System.out.println("Good Bye");
        	break;
        }
        default:
        {
        	System.out.println("Invalid input");
        }
        }
        

	}while(choice!=6);

}
}
