package com.karthik.HospitalManagementSystem.controller;


import com.karthik.HospitalManagementSystem.model.User;
import com.karthik.HospitalManagementSystem.service.JwtSevice;
import com.karthik.HospitalManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hospitalmanagementsystem/api/")
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    AuthenticationManager authmanager;
    @Autowired
    JwtSevice jwtservice;

    @PostMapping("login")
    public String login(@RequestBody User user)
    {
        System.out.println("entered");
        Authentication auth = authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(auth.isAuthenticated())
        {
            System.out.println("karthik");
            return jwtservice.generateToken(user);
        }
        else{
            return "FAILED";
        }
    }
}
