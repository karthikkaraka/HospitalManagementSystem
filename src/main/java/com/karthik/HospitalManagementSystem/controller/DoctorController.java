package com.karthik.HospitalManagementSystem.controller;

import com.karthik.HospitalManagementSystem.model.Appointment;
import com.karthik.HospitalManagementSystem.model.Diagnosis;
import com.karthik.HospitalManagementSystem.model.Patient;
import com.karthik.HospitalManagementSystem.repository.DoctorRepo;
import com.karthik.HospitalManagementSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('DOCTOR')")
@RequestMapping("hospitalmanagementsystem/api/")
public class DoctorController {
    @Autowired
    DoctorService docser;
    @Autowired
    DoctorRepo docrep;
    @GetMapping("getappointments/doctor")
    public List<Appointment> getallappointments(Authentication auth)
    {
         String name = auth.getName();
        return docser.getappointments(name);
    }
    @PostMapping("writediagnosis")
    public Diagnosis writeemedicalReport(@RequestBody Diagnosis dia)
    {
        System.out.println("entered");
        return docser.writemedrep(dia);
    }
    @GetMapping("getdiagnosis/{id}")
    public List<Diagnosis> getdiagnosis(@PathVariable Long id )
    {
        return docser.getMedicalrecord(id);

    }
}
