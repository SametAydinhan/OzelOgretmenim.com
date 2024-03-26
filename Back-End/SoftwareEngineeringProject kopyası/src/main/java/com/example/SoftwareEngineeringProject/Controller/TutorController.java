package com.example.SoftwareEngineeringProject.Controller;

import com.example.SoftwareEngineeringProject.Entity.Tutor;
import com.example.SoftwareEngineeringProject.Entity.User;
import com.example.SoftwareEngineeringProject.Request.LoginRequest;
import com.example.SoftwareEngineeringProject.Service.TutorService;
import com.example.SoftwareEngineeringProject.Service.UserService;
import com.example.SoftwareEngineeringProject.exception.IdNotFoundException;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutor")
public class TutorController {

        private final TutorService tutorService;
        private final UserService userService;

    public TutorController(TutorService tutorService, UserService userService) {
        this.tutorService = tutorService;
        this.userService = userService;
    }

    @GetMapping
    public List<Tutor> getAllTutor(){
        return tutorService.getAllTutor();
    }


    @GetMapping("/{tutorId}")
    public Tutor findById(@PathVariable(name = "tutorId") int tutorId) throws IdNotFoundException {
        return tutorService.findById(tutorId);
    }

    @PostMapping("/register")
    public Tutor createTutor(@RequestBody Tutor tutor){
        return tutorService.createTutor(tutor);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody LoginRequest loginRequest) throws IdNotFoundException {
        return userService.loginUser(loginRequest.getUsername(),loginRequest.getPassword());
    }

    @PutMapping("/{tutorId}")
    public Tutor updateTutor(@PathVariable int tutorId,@RequestBody Tutor tutor) throws IdNotFoundException {
        return tutorService.updateTutor(tutorId,tutor);
    }

    @DeleteMapping("/{tutorId}")
    public void deleteTutors(@PathVariable int tutorId) throws IdNotFoundException {
        tutorService.deleteTutor(tutorId);
    }


    @GetMapping("/subject/{subject}")
    public List<Tutor> getBySubject(@PathVariable String subject){
        return tutorService.getBySubject(subject);
    }




}
