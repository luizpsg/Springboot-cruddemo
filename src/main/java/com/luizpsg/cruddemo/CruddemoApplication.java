package com.luizpsg.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luizpsg.cruddemo.dao.StudentDAO;
import com.luizpsg.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

  @Bean
  public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
    return runner -> {
      // createStudent(studentDAO);

      // createMultipleStudents(studentDAO);

      // readStudent(studentDAO);

      // queryForStudents(studentDAO);

      // queryForStudentsByLastName(studentDAO);

      // updateStudent(studentDAO);

      // deleteStudent(studentDAO);

      // deleteAllStudents(studentDAO);
    };
  }


  private void deleteAllStudents(StudentDAO studentDAO) {
      
      System.out.println("Deleting all students ...");
      int numRowsDeleted = studentDAO.deleteAll();
      System.out.println("Number of rows deleted: " + numRowsDeleted);
  }

  private void deleteStudent(StudentDAO studentDAO) {
    
    int studentId = 1;
    System.out.println("Deleting student with id: " + studentId);

    studentDAO.delete(studentId);
  }

  private void updateStudent(StudentDAO studentDAO) {

    // retrieve student based on the id: primary key
    int studentId = 1;
    System.out.println("Getting student with id: " + studentId);
    Student myStudent = studentDAO.findById(studentId);

    // change first name to "Pistorius"
    System.out.println("Updating student ...");
    myStudent.setFirstName("Jorge");
    
    // update the student
    studentDAO.update(myStudent);

    // display the updated student
    System.out.println("Updated student: " + myStudent);
  }

  private void queryForStudentsByLastName(StudentDAO studentDAO) {
    
    // get a list of students
    List<Student> theStudents = studentDAO.findByLastName("Goncalves");

    // display lists of students
    for(Student tempStudent : theStudents){
      System.out.println(tempStudent);
    }

  }

  private void queryForStudents(StudentDAO studentDAO) {
    
    // get a list of students
    List<Student> theStudents = studentDAO.findAll();

    // display lists of students
    for(Student tempStudent : theStudents){
      System.out.println(tempStudent);
    }
  }

  private void readStudent(StudentDAO studentDAO) {
    
    // create a student object

    System.out.println("Creating a new student object ...");
    Student tempStudent = new Student("Luiz Paulo", "Goncalves", "luiz@luizpsg.com");

    // save the student

    System.out.println("Saving the student ...");
    studentDAO.save(tempStudent);

    // display the if of the saved student

    int theId = tempStudent.getId();
    System.out.println("Saved student. Generated id: " + theId);

    // retrieve student based on the id: primary key

    System.out.println("Retrieving student with id: " + theId);
    Student myStudent = studentDAO.findById(theId);

    // display the student
    System.out.println("Retrieved student: " + myStudent);
  }

  private void createMultipleStudents(StudentDAO studentDAO) {
    // create multiple students

    System.out.println("Creating 3 students object ...");
    Student tempStudent1 = new Student("Jorge", "Nho", "jorge@luizpsg.com");
    
    Student tempStudent2 = new Student("Vivian", "Almeida", "vivi@luizpsg.com");

    Student tempStudent3 = new Student("Braulio", "Nildo", "braunildo@luizpsg.com");

    // save the student objects
    System.out.println("Saving the students ...");
    studentDAO.save(tempStudent1);
    studentDAO.save(tempStudent2);
    studentDAO.save(tempStudent3);

  }

  private void createStudent(StudentDAO studentDAO) {
    
    // create the student object

    System.out.println("Creating a new student object ...");
    Student tempStudent = new Student("Luiz Paulo", "Goncalves", "luiz@luizpsg.com");

    // save the student object
    System.out.println("Saving the student ...");
    studentDAO.save(tempStudent);

    // display id of the saved student
    System.out.println("Saved student. Generated id: " + tempStudent.getId());

  }

}
