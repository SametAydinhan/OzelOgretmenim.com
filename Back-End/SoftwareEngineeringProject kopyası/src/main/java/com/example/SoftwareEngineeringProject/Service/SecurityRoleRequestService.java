package com.example.SoftwareEngineeringProject.Service;


import com.example.SoftwareEngineeringProject.Entity.User;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Data
@Service
public class SecurityRoleRequestService {

    public String getUserAuthorities(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String role = authentication.getAuthorities().toString();
        return  role;
    }


}
