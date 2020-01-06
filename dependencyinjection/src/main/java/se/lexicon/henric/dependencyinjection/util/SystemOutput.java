package se.lexicon.henric.dependencyinjection.util;

import org.springframework.stereotype.Component;

import se.lexicon.henric.dependencyinjection.models.Student;

@Component
public class SystemOutput {

	public void printString(String s){
		System.out.println(s);
	}
	
	public String nullCheckAndPrintStudentRepresentation(Student student){
		if(student != null) {
			return student.toString();
		}
		return "Internal error, please try again";
	}
}
