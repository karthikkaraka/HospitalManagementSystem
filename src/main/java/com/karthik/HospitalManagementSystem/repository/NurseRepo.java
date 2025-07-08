package com.karthik.HospitalManagementSystem.repository;

import com.karthik.HospitalManagementSystem.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface NurseRepo extends JpaRepository<Nurse,Long> {
    public Optional<Nurse> findById(Long id);
}
