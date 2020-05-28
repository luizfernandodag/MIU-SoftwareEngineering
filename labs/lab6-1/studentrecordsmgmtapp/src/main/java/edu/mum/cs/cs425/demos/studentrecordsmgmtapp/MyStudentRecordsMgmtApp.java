package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

public class MyStudentRecordsMgmtApp {

	public static void main(String[] args) {
		Student[] students = { new Student("110001", "Dave", dateFromString("11/18/1951")),
				new Student("110002", "Anna", dateFromString("12/07/1990")),
				new Student("110003", "Erica", dateFromString("01/31/1974")),
				new Student("110004", "Carlos", dateFromString("08/22/2009")),
				new Student("110005", "Bob", dateFromString("03/05/1990")), };

		System.out.println("Print List of Students:");
		printListOfStudents(students);
		
		System.out.println("\nGet List of Platium Alumni Students:");
		getListOfPlatinumAlumniStudents(students);
	}

	public static void printListOfStudents(Student[] studs) {
		Arrays.sort(studs, Comparator.comparing(Student::getName));
		for (Student s : studs) {
			System.out.println(s);
		}
	}

	@SuppressWarnings("deprecation")
	public static void getListOfPlatinumAlumniStudents(Student[] studs) {
		Arrays.sort(studs, Comparator.comparing(Student::getDateOfAdmission).reversed());
		for (Student s : studs) {
			if (s.getDateOfAdmission() == null)
				continue;

			if (new Date().getYear() - s.getDateOfAdmission().getYear() >= 30)
				System.out.println(s);
		}
	}

	private static Date dateFromString(String dateStr) {
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date;
		try {
			date = format.parse(dateStr);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}
}
