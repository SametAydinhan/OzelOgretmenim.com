package com.example.SoftwareEngineeringProject.Controller;

import com.example.SoftwareEngineeringProject.Entity.Tutor;
import com.example.SoftwareEngineeringProject.Entity.User;
import com.example.SoftwareEngineeringProject.Repository.NoticeRepository;
import com.example.SoftwareEngineeringProject.Repository.TutorRepository;
import com.example.SoftwareEngineeringProject.Service.TutorService;
import com.example.SoftwareEngineeringProject.Service.UserService;
import com.example.SoftwareEngineeringProject.Exception.IdNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tutor")
public class TutorController {

        private final TutorService tutorService;
        private final UserService userService;

        private final TutorRepository tutorRepository;

        private final NoticeRepository noticeRepository;

    public TutorController(TutorService tutorService, UserService userService, TutorRepository tutorRepository, NoticeRepository noticeRepository) {
        this.tutorService = tutorService;
        this.userService = userService;
        this.tutorRepository = tutorRepository;
        this.noticeRepository = noticeRepository;
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


    @PutMapping("/update/{tutorId}")
    public Tutor updateTutor(@PathVariable int tutorId, @RequestBody Tutor tutor) throws IdNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        Optional<Tutor> tempTutor = tutorRepository.findTutorByUserId(user.getId());

        if (tempTutor.isPresent()) {
            Tutor existingTutor = tempTutor.get();
            if (existingTutor.getId() == tutorId) {
                tutor.setId(existingTutor.getId()); // Ensure the ID matches
                return tutorService.updateTutor(tutorId, tutor);
            } else {
                throw new IdNotFoundException("Tutor Found but not updated");
            }
        } else {
            throw new IdNotFoundException("Tutor Not Found");
        }
    }


    @Transactional
    @DeleteMapping("/delete/{tutorId}")
    public void deleteTutors(@PathVariable int tutorId) throws IdNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();


        Optional<Tutor> tempTutor = tutorRepository.findTutorByUserId(user.getId());
        if(tempTutor.isPresent()){
            Tutor existenceTutor = tempTutor.get();
            if(existenceTutor.getId() == tutorId){

                noticeRepository.deleteByTutorId(tutorId);
                tutorRepository.deleteById(tutorId);
            }

            else {
                throw new IdNotFoundException("Tutor Found But Not Deleted");
            }
        }

        else {
            throw new IdNotFoundException("Tutor Not Found");
        }
    }







}
