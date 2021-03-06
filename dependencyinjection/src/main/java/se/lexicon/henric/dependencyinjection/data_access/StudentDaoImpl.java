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

	/** 
	 * Private fields
	 * */
	List<Student> students;
	ErrorStrings errorMessages;
	
	
	/**
	 * Constructor
	 * @PARAM List<Student> students
	 * */
	public StudentDaoImpl(List<Student> students) {
		if(students == null) {
			this.students = new ArrayList<Student>();
		}
		this.students = students;
	}
	
	/**
	 * Setter for private field errorMessages of type ErrorStrings (package:Util)
	 * Autowired to use ErrorStrings as a bean component in config.ErrorMessagesConfig
	 * */
	@Autowired
	public void setErrorMessages(ErrorStrings errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	/**
	 * implementation of interface StudentDao
	 * */
	
	/**
	 * Method for saving student
	 * Implementation of interface StudentDao
	 * 
	 * @PARAM Student student
	 * @RETURN Student student
	 * @THROWS NoSuchFieldException
	 * */
	public Student save(Student student) throws NoSuchFieldException {
		if(students == null || student == null) {
			students = new ArrayList<Student>();
		}
		
		if(student !=null) {
			students.add(student);
			return student;
		}
		throw new InvalidParameterException(errorMessages.getInvalidParamString());
	}

	/**
	 * Method for finding student by ID
	 * Implementation of interface StudentDao
	 * 
	 * @PARAM int id
	 * @RETURN Student student
	 * @THROWS NoSuchFieldException
	 * */
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

	/**
	 * Method for finding student by ID
	 * Implementation of interface StudentDao
	 *
	 * @RETURN List<Student> 
	 * @THROWS NoSuchFieldException
	 * */
	public List<Student> findAll() throws NoSuchFieldException {
		if(students != null) {
			return students;
		}
		throw new NoSuchFieldException(errorMessages.getNoSuchFieldExceptionNoResult());
	}

	/**
	 * Method for deleting student by ID
	 * Implementation of interface StudentDao
	 *
	 * @RETURN VOID
	 * @THROWS NoSuchFieldException
	 * */
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
