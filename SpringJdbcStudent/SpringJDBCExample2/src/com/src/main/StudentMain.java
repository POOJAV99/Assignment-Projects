package com.src.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.src.dao.StudentDao;
import com.src.student.Student;


public class StudentMain {
    public static void main(String[] args)
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao=(StudentDao) context.getBean("studentdao");
		/*int result=dao.updateStudent(new Student(10,"pooja","TN",99999999));
		if(result>0)
		{
			System.out.println("values updated successfully");
		}
		else
		{
			System.out.println("unable to update");
		}*/
		
		
		/*int result=dao.setStudent(new Student(30,"laksana","andhra",77777777));
		if(result>0)
		{
			System.out.println("values inserted successfully");
		}
		else
		{
			System.out.println("unable to delete");
		}*/
        
		/*int result=dao.deleteStudent(new Student(20));
		if(result>0)
		{
			System.out.println("values deleted successfully");
		}
		else
		{
			System.out.println("unable to delete");
		}*/
		
		List<Student> s=dao.displayStudent(new Student());
		for(Student students:s)
		{
			System.out.println(students);
		}
    }
}
