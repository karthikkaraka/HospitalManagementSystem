package com.karthik.HospitalManagementSystem.repository;

import com.karthik.HospitalManagementSystem.model.Vitals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VitalsRepo extends JpaRepository<Vitals,Long> {
    @Query("SELECT v FROM Vitals v WHERE v.patient.id =:id")
    Vitals getVitalsBypatientid(@Param("id") Long id);
}
