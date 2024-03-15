package com.swiftlearn.leaningproject.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//  this class annotated as repository which enhance the database communication of Student model as
//  specified below with the JpaRepository<Student, Integer>
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//    this methode use email to find student in student table, and it will return Student data Type
//    remember the Student class has Email property thus why this method is magically invoked
    Student findByEmail(String email);

//    to provide more understanding these are the possible other methode can be initialized
//    NB: all the properties after the "findBy" part in the bottom methods are present in the
//    Student class(ie are properties of Student class)
    Student findByPhone(String phone);
    Student findByName(String name);
    Student findByGrade(String grade);

//  using custom query in spring boot
//  the method below is unlike the other ones because it uses custom query, the other one utilize
//  pre generated query
    @Query("SELECT s FROM Student s WHERE s.email LIKE %:domain")
    List<Student> findByDomain(@Param("domain") String domain);


}
