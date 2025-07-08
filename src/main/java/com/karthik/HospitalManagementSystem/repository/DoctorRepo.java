package com.karthik.HospitalManagementSystem.repository;

import com.karthik.HospitalManagementSystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {
    @Query("SELECT d FROM Doctor d WHERE d.user.id = :id ")
    Doctor findDoctor(@Param("id") Long id);
}
