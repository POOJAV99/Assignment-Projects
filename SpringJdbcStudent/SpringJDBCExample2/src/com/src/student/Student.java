package com.src.student;

public class Student {
	private int stuid;
	private String stuname;
	private String stuadd;
	private long phno;
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStuadd() {
		return stuadd;
	}
	public void setStuadd(String stuadd) {
		this.stuadd = stuadd;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", stuname=" + stuname + ", stuadd=" + stuadd + ", phno=" + phno + "]";
	}
	public Student(int stuid, String stuname, String stuadd, long phno) {
		super();
		this.stuid = stuid;
		this.stuname = stuname;
		this.stuadd = stuadd;
		this.phno = phno;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int stuid) {
		super();
		this.stuid = stuid;
	}
	

}
