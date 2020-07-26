package com.school.school.controller;

import com.school.school.exception.ResourceNotFoundException;
import com.school.school.model.Student;
import com.school.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    // Get All Notes
    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    // Create new Student
    @PostMapping("/students")
    public Student createNote(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }
    
    // Get a Student
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable(value = "id") Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", studentId));
    }
    
    // Update student
    @PutMapping("/students/{id}")
    public Student updateNote(@PathVariable(value = "id") Long studentId,
                                            @Valid @RequestBody Student studentDetails) {

    	Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", studentId));

    	student.setName(studentDetails.getName());
    	student.setCourseid(studentDetails.getCourseid());
    	student.setAge(studentDetails.getAge());

    	Student updatedStudent = studentRepository.save(student);
        return updatedStudent;
    }
    
    // Delete student
    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long studentId) {
    	Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", studentId));

        studentRepository.delete(student);

        return ResponseEntity.ok().build();
    }
}