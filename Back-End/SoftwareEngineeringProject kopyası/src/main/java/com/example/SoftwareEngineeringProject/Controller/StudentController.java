package com.example.SoftwareEngineeringProject.Controller;


import com.example.SoftwareEngineeringProject.Entity.Student;
import com.example.SoftwareEngineeringProject.Entity.User;
import com.example.SoftwareEngineeringProject.Repository.NoticeRepository;
import com.example.SoftwareEngineeringProject.Repository.StudentRepository;
import com.example.SoftwareEngineeringProject.Repository.TutorRepository;
import com.example.SoftwareEngineeringProject.Service.StudentService;
import com.example.SoftwareEngineeringProject.Exception.IdNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    private final StudentRepository studentRepository;

    private final NoticeRepository noticeRepository;

    private final TutorRepository tutorRepository;

    public StudentController(StudentService studentService, StudentRepository studentRepository, NoticeRepository noticeRepository, TutorRepository tutorRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
        this.noticeRepository = noticeRepository;
        this.tutorRepository = tutorRepository;
    }


    @GetMapping
    public List<Student> getAllStudent(){
            return studentService.getAllStudent();
    }



    @GetMapping("/{studentId}")
    public Student findById(@PathVariable(name="studentId") int studentId) throws IdNotFoundException {
        return studentService.findById(studentId);
    }


    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }



    @PutMapping("/update/{studentId}")
    public Student updateStudent(@PathVariable int studentId, @RequestBody Student student) throws IdNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        Optional<Student> tempStudent = studentRepository.findStudentByUserId(user.getId());

        if (tempStudent.isPresent()) {
            Student existingStudent = tempStudent.get();
            if (existingStudent.getId() == studentId) {
                student.setId(existingStudent.getId()); // Ensure the ID matches
                return studentService.updateStudent(studentId,student);
            } else {
                throw new IdNotFoundException("Tutor Found but not updated");
            }
        } else {
            throw new IdNotFoundException("Tutor Not Found");
        }
    }



    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable int studentId) throws IdNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        Optional<Student> tempStudent = studentRepository.findStudentByUserId(user.getId());
        if(tempStudent.isPresent()){
            Student existingStudent = tempStudent.get();
            if(existingStudent.getId() == studentId){
                studentRepository.deleteById(studentId);
            }

            else {
                throw new IdNotFoundException("Student Found But Not Deleted");
            }
        }

        else {
            throw new IdNotFoundException("Student Not Found");
        }
    }








}
