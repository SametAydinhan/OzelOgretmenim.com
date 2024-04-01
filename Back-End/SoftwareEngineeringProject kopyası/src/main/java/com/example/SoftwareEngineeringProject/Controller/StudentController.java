package com.example.SoftwareEngineeringProject.Controller;


import com.example.SoftwareEngineeringProject.Entity.Student;
import com.example.SoftwareEngineeringProject.Service.StudentService;
import com.example.SoftwareEngineeringProject.Exception.IdNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getAllStudent(){
            return studentService.getAllStudent();
    }



    @GetMapping("/{studentId}")
    public Student findById(@PathVariable int studentId) throws IdNotFoundException {
        return studentService.findById(studentId);
    }


    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }


    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable int studentId,@RequestBody Student student) throws IdNotFoundException {
        return studentService.updateStudent(studentId,student);
    }


    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable int studentId) throws IdNotFoundException {
            studentService.deleteStudent(studentId);
    }








}
