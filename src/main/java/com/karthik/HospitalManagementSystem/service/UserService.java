package com.karthik.HospitalManagementSystem.service;

import com.karthik.HospitalManagementSystem.model.User;
import com.karthik.HospitalManagementSystem.repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
Userrepo repo;
BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User registeruser(User user) {
     user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
