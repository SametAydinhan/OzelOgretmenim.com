package com.example.SoftwareEngineeringProject.Controller;

import com.example.SoftwareEngineeringProject.Entity.User;
import com.example.SoftwareEngineeringProject.Exception.IdNotFoundException;
import com.example.SoftwareEngineeringProject.Request.LoginRequest;
import com.example.SoftwareEngineeringProject.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    private User loginUser(@RequestBody LoginRequest loginRequest) throws IdNotFoundException {
        return  userService.loginUser(loginRequest.getUsername(),loginRequest.getPassword());
    }

}
