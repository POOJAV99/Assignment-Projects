package com.src.dao;

import java.util.List;

import com.src.student.Student;

public interface StudentInterface {
	 public int setStudent(Student s);
     public int updateStudent(Student s);
     public int deleteStudent(Student s);
     public List<Student> displayStudent(Student s);
}
