package com.shravani.cuseprotect.service;

import com.shravani.cuseprotect.model.Student;
import com.shravani.cuseprotect.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    public StudentRepo studentRepo;

   @Override
    public Student getStudentByID(String id) {
        Optional<Student> availableStudent = studentRepo.findById(id);
        System.out.println(id);
        if(availableStudent.isPresent()){
            Student studentDetail = availableStudent.get();
            return studentDetail;
        }
        return null;
    }

    @Override
    public Student addStudentByName(String name) {
        return null;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentByName(String name) {
        Optional<Student> availableStudent = studentRepo.findByName(name);
        System.out.println(name);
        if(availableStudent.isPresent()){
            Student studentDetail = availableStudent.get();
            return studentDetail;
        }
        return null;
    }

    @Override
    public Student getStudentBysuID(Integer suID) {
        Optional<Student> availableStudent = studentRepo.findBysuID(suID);
        System.out.println(suID);
        if(availableStudent.isPresent()){
            Student studentDetail = availableStudent.get();
            return studentDetail;
        }
        return null;
    }

    @Override
    public void removeStudent(String id) {
        studentRepo.deleteById(id);
    }

   @Override
    public Student updateStudent(Student student) {
       Optional<Student> availableStudent = studentRepo.findBysuID(student.getSuID());
       if(availableStudent.isPresent()){
           availableStudent.get().setName(student.getName());
          // availableStudent.get().setSuID(student.getSuID());
           availableStudent.get().setPassword(student.getPassword());
           studentRepo.save(availableStudent.get());
       }
       return student;
    }
}
