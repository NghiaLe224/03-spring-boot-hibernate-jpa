package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO student) {
		return runner ->{
//			createStudent(student);
			createMultipleStudent(student);
//			readStudent(student);
//			queryForStudents(student);
//			queryForStudentsByLastName(student);
//			updateStudent(student);
//			deleteStudent(student);
//			deleteAllStudent(student);
		};
	}

	private void deleteAllStudent(StudentDAO student) {
		int rows = student.deleteAll();
		System.out.println("Delete " + rows);
	}

	private void deleteStudent(StudentDAO student) {
		int id = 1;
		student.delete(1);
	}

	private void updateStudent(StudentDAO student) {
		//select student
		Student student1 = student.findById(1);
		//update student
		student1.setEmail("updatedEmail@gamil.com");
		student.update(student1);
		//sout
		System.out.println("Updated gmail");
	}

	private void queryForStudentsByLastName(StudentDAO student) {
		List<Student> myList = student.findByLastName("Thao");
		for(Student s : myList){
			System.out.println(s);
		}
	}

	private void queryForStudents(StudentDAO student) {
		List<Student> myList = student.findAll();

		for(Student s : myList){
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO student) {
		System.out.println("Creating...");
		Student myStudent = new Student("newRead", "newRead", "newRead@gmail.com");
		System.out.println("Saving...");
		student.save(myStudent);
		System.out.println("Saved student with id " + myStudent.getId());

		Student foundedStudent = student.findById(myStudent.getId());
		int id = foundedStudent.getId();
		System.out.println("found student with id: " + id + ": " + foundedStudent);
	}

	private void createMultipleStudent(StudentDAO student) {
		System.out.println("Creating 3 student...");
		Student myStudent1 = new Student("Le", "Nghia", "abc@gmail.com");
		Student myStudent2 = new Student("Le", "Thao", "def@gmail.com");
		Student myStudent3 = new Student("Nguyen", "Tuan", "ghi@gmail.com");
		//save
		System.out.println("Saving 3 student...");
		student.save(myStudent1);
		student.save(myStudent2);
		student.save(myStudent3);
	}

	private void createStudent(StudentDAO student) {
		//create
		System.out.println("Creating...");
		Student myStudent = new Student("Le", "Nghia", "abc@gmail.com");
		//save
		System.out.println("Saving...");
		student.save(myStudent);
		//display with id
		System.out.println("Saved student with id " + myStudent.getId());
	}

}
