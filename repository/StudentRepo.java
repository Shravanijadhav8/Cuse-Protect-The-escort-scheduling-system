package com.shravani.cuseprotect.repository;

import com.shravani.cuseprotect.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {
    @Query("{id :?0}")
   Optional<Student> findById(String id);

    Optional<Student> findByName(String name);

    Optional<Student> findBysuID(Integer suID);

    //Optional<Student> deleteByID(String id);

    //void delete(Integer suID);

    // Optional<Student> addStudentName(String name);
}
