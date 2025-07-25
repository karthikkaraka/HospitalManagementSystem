package com.karthik.HospitalManagementSystem.repository;

import com.karthik.HospitalManagementSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {

}
