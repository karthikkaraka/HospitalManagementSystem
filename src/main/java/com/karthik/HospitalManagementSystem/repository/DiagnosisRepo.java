package com.karthik.HospitalManagementSystem.repository;

import com.karthik.HospitalManagementSystem.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DiagnosisRepo extends JpaRepository<Diagnosis,Long> {
    @Query("SELECT d FROM Diagnosis d WHERE d.patient.id = :id")
    List<Diagnosis> getMedicalreport(@Param("id") Long id);


}
