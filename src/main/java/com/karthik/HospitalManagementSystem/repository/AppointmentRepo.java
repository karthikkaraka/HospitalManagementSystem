package com.karthik.HospitalManagementSystem.repository;

import com.karthik.HospitalManagementSystem.model.Appointment;
import com.karthik.HospitalManagementSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    @Query("SELECT a FROM Appointment a WHERE a.patient.id = :patientId")
    List<Appointment> findByPatient(@Param("patientId") Long patientId);

    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :id")
    List<Appointment> findBydoctor(@Param("id") Long id);


    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorid")
    List<Appointment> findAppointments(@Param("doctorid") Long doctorid);

}
