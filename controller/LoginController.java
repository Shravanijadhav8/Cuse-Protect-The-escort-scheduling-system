
package com.shravani.cuseprotect.controller;

import com.shravani.cuseprotect.exception.StudentNotFound;
import com.shravani.cuseprotect.model.Student;
import com.shravani.cuseprotect.payload.response.MessageResponse;
import com.shravani.cuseprotect.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
//import javax.validation.Valid;

@RestController
public class LoginController {
    @Autowired  //something that needs injection
    public StudentService studentService; //check if any class has this service and then inject it

    @RequestMapping(value="/Login/students/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<?> getStudentByID(@PathVariable("id") String id){
        Student s = studentService.getStudentByID(id);
        if(Objects.isNull(s)){
            return ResponseEntity.badRequest().body(new MessageResponse("Student doesn't exist!"));
        }
        return ResponseEntity.ok(s);
    }

    @RequestMapping(value="/Login/studentName/{name}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<?> getStudentByName(@PathVariable("name") String name){
        Student student =  studentService.getStudentByName(name);
        if(student == null){
            return ResponseEntity.badRequest().body(new MessageResponse("Student with provided name does not exist!"));
        }
        return ResponseEntity.ok(student);
    }

    @RequestMapping(value="/Login/studentsuID/{suID}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<?> getStudentBysuID(@PathVariable("suID") Integer suID){
        Student student =  studentService.getStudentBysuID(suID);
        if(student == null){
            return ResponseEntity.badRequest().body(new MessageResponse("Student with provided suID does not exist!"));
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping("/Login/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        Student student1 = new Student(student.getId(), student.getName(), student.getSuID(), student.getPassword());
        Student studentAdded = studentService.saveStudent(student1);
        return ResponseEntity.ok(studentAdded);
    }

   @DeleteMapping(value = "/Login/removeStudent/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable String id) {
        Student student = studentService.getStudentByID(id);
        if(student != null){
            studentService.removeStudent(id);
        }
       return ResponseEntity.ok(student);
   }

   @PutMapping(value = "/Login/updateStudent")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        Student studentUpdateDetails = studentService.getStudentBysuID(student.getSuID());
        if(studentUpdateDetails != null){
            Student updatedStudent = studentService.updateStudent(student);
            return ResponseEntity.ok(updatedStudent);
        }
        return null;
   }



/*  @RequestMapping(value="/Login/students", method = RequestMethod.POST)
    public ResponseEntity<?> addStudentDetail(@RequestBody StudentSignup studentSignup){
        List<Student> students = studentRepo.findAll();
        for(Student student: students){
            System.out.println("Registered students:"+ studentSignup);
            if(student.equals(studentSignup)){
                System.out.println("STudent already registered");
                return null;            }
        }
        studentRepo.addStudentName(studentSignup.getName());
        return ResponseEntity.ok(students);
        //Student student = new Student(studentSignup.getId(), studentSignup.getName(), studentSignup.getSuID(), studentSignup.getPassword());

    }*/

}

