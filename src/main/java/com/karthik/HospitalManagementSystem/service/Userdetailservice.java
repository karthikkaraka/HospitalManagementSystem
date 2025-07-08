package com.karthik.HospitalManagementSystem.service;

import com.karthik.HospitalManagementSystem.model.User;
import com.karthik.HospitalManagementSystem.model.Userprinciple;
import com.karthik.HospitalManagementSystem.repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Userdetailservice implements UserDetailsService {
    @Autowired
     Userrepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repo.findByUsername(username);
        System.out.println( "username:"+username);
    if(user== null)
    {
        throw new UsernameNotFoundException("username not found!!");
    }
    else{
        return new Userprinciple(user);
    }

    }

}
