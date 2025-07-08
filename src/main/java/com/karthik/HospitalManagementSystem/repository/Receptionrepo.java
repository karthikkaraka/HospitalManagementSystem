package com.karthik.HospitalManagementSystem.repository;

import com.karthik.HospitalManagementSystem.model.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Receptionrepo extends JpaRepository<Receptionist,Long> {

}
