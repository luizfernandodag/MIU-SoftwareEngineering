package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	private String studentId;
	private String name;
	private Date dateOfAdmission;

	public Student() {
	}

	public Student(String studentId, String name, Date dateOfAdmission) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.dateOfAdmission = dateOfAdmission;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	
	public String toString()
	{
		String dateFormat = new SimpleDateFormat("MM/dd/yyyy").format(dateOfAdmission);
		return String.format("studentId: %s name: %s dateOfAdmission: %s", studentId, name, dateFormat);
	}

}
