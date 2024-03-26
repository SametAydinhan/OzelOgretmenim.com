package com.example.SoftwareEngineeringProject.Controller;


import com.example.SoftwareEngineeringProject.Entity.Notice;
import com.example.SoftwareEngineeringProject.Entity.User;
import com.example.SoftwareEngineeringProject.Service.NoticeService;
import com.example.SoftwareEngineeringProject.Service.UserService;
import com.example.SoftwareEngineeringProject.exception.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;
    private final UserService userService;



    public NoticeController(NoticeService noticeService, UserService userService) {
        this.noticeService = noticeService;
        this.userService = userService;
    }


    @GetMapping
    public List<Notice> getAllNotice(){
        return noticeService.getAllNotice();
    }


    @PostMapping
    public Notice createNoticeForLoggedInUser(@RequestBody Notice notice) throws IdNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = authentication.getName();

        Optional<User> loggedInUserOptional = userService.findByUsername(loggedInUsername);

        if (!loggedInUserOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with username: " + loggedInUsername);
        }

        User loggedInUser = loggedInUserOptional.get();
        int userId = loggedInUser.getId();

        return noticeService.createNotice(notice, userId);
    }

    @GetMapping("/{noticeId}")
    public Notice findById(@PathVariable int noticeId) throws IdNotFoundException {
            return noticeService.findById(noticeId);
    }

    @PutMapping("/{noticeId}")
    public Notice updateNotice(@PathVariable int noticeId,@RequestBody Notice notice) throws IdNotFoundException {
        return noticeService.updateNotice(noticeId,notice);
    }

    @DeleteMapping("/{noticeId}")
    public void deleteNotice(@PathVariable int noticeId) throws IdNotFoundException {
         noticeService.deleteNotice(noticeId);
    }


    @GetMapping("/filter")
    public List<Notice> findByParameter(@RequestParam(name = "city",required = false) String city,@RequestParam(name = "gender",required = false) String gender,@RequestParam(name = "subject",required = false) String subject){
            return  noticeService.findByParameters(city, gender, subject);
    }

}
