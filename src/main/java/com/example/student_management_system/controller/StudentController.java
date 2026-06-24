package com.example.student_management_system.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management_system.model.Student;
import com.example.student_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/students")
public class StudentController {
@Autowired
private StudentRepository repo;

   
@GetMapping("/students")
public List<Student> getStudents() {
    return repo.findAll();
}
    

  @PostMapping("/students")
public Student addStudent(@RequestBody Student student) {
    return repo.save(student);
}
    
  


 @GetMapping("/students/{id}")
public Student getStudentById(@PathVariable int id) {
    return repo.findById(id).orElse(null);
}



@PutMapping("/students/{id}")
public String updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {

    Student student = repo.findById(id).orElse(null);

    if (student == null) {
        return "Student not found!";
    }

    student.setName(updatedStudent.getName());
    student.setEmail(updatedStudent.getEmail());

    repo.save(student);

    return "Student updated successfully!";
}

@DeleteMapping("/students/{id}")
public String deleteStudent(@PathVariable int id) {

    if (repo.existsById(id)) {
        repo.deleteById(id);
        return "Student deleted successfully!";
    }

    return "Student not found!";
}



}
    

