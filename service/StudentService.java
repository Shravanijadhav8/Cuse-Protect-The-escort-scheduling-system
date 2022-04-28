package com.shravani.cuseprotect.service;

import com.shravani.cuseprotect.model.Student;
import com.shravani.cuseprotect.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
public interface StudentService {
    //@Autowired
   // public StudentRepo studentRepo;

   /* public Optional<Student> getStudentByID(String id){ //optional will make it abstract class
        //find the student by id and return here
        //Optional<Student> student = new Student(findById);
        return studentRepo.findById(id);
    }*/
  // Student addStudent(Student student);

   public Student getStudentByID(String id);

   Student addStudentByName(String name);

   Student saveStudent(Student student);

   Student getStudentByName(String name);

   Student getStudentBysuID(Integer suID);

   void removeStudent(String id);

   Student updateStudent(Student student);



   // Student removeStudent(String id);

  /* public Student saveStudent(Student student){

      return studentRepo.save(student);
   }*/
}
