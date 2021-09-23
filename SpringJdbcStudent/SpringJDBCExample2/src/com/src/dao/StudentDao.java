package com.src.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.src.student.Student;

public class StudentDao implements StudentInterface{
   @SuppressWarnings("unused")
   private JdbcTemplate jdbctemp;
   
    public void setJdbctemp(JdbcTemplate jdbctemp) {
	this.jdbctemp = jdbctemp;
}

	@Override
	public int setStudent(Student s) {
		String query="insert into student values("+s.getStuid()+",'"+s.getStuname()+"','"+s.getStuadd()+"',"+s.getPhno()+")";
		return jdbctemp.update(query);
	}

	@Override
	public int updateStudent(Student s) {
		String query="update student set studentname='"+s.getStuname()+"',studentaddress='"+s.getStuadd()+"',studentphno="+s.getPhno()+" where studentid="+s.getStuid()+"";
		return jdbctemp.update(query);
	}

	@Override
	public int deleteStudent(Student s) {
		String query="delete from student where studentid="+s.getStuid()+"";
		return jdbctemp.update(query);
	}

	@Override
	public List<Student> displayStudent(Student s) {
		return jdbctemp.query("select * from student",new RowMapper<Student>(){
		    public Student mapRow(ResultSet rs,int row) throws SQLException {
		    	Student s=new Student();
		    	s.setStuid(rs.getInt(1));
		    	s.setStuname(rs.getString(2));
		    	s.setStuadd(rs.getString(3));
		    	s.setPhno(rs.getLong(4));
		    	return s;
		       }
		   });
		
	}

	

}
