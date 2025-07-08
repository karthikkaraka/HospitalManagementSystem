package com.karthik.HospitalManagementSystem.repository;

import com.karthik.HospitalManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
