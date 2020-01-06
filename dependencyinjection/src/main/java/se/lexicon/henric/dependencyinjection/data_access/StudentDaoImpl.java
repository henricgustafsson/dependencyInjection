package se.lexicon.henric.dependencyinjection.data_access;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import se.lexicon.henric.dependencyinjection.models.Student;
import se.lexicon.henric.dependencyinjection.util.ErrorStrings;


@Component
public class StudentDaoImpl implements StudentDao{

	
	List<Student> students;
	ErrorStrings errorMessages;
	
	public StudentDaoImpl(List<Student> students) {
		if(students == null) {
			this.students = new ArrayList<Student>();
		}
		this.students = students;
	}
	
	@Autowired
	public void setErrorMessages(ErrorStrings errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	public Student save(Student student) {
		if(students == null || student == null) {
			students = new ArrayList<Student>();
		}
		
		if(student !=null) {
			students.add(student);
			return student;
		}
		throw new InvalidParameterException(errorMessages.getInvalidParamString());
	}

	public Student find(int id) throws NoSuchFieldException {
		
		Student student =null;
	
		for(Student s : students) {
			if(s.getId() == id) {
				
				student = s;
				return student;
			}		
		}
		
		throw new NoSuchFieldException(errorMessages.getNoSuchFieldExceptionNoResult("with id: "+id));
		 
		
	}

	public List<Student> findAll() throws NoSuchFieldException {
		if(students != null) {
			return students;
		}
		throw new NoSuchFieldException(errorMessages.getNoSuchFieldExceptionNoResult());
	}

	public void Delete(int id) throws NoSuchFieldException {
		
		for(Student s : students) {
			if(s.getId() == id) {
				
				students.remove(s);
				return;
			}		
			
			throw new NoSuchFieldException(errorMessages.getNoSuchFieldExceptionNoResult("with id: "+id));
		}
		
	}

}
