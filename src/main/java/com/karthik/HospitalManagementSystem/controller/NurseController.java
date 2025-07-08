package com.karthik.HospitalManagementSystem.controller;

import com.karthik.HospitalManagementSystem.model.Patient;
import com.karthik.HospitalManagementSystem.model.Vitals;
import com.karthik.HospitalManagementSystem.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('NURSE')")
@RequestMapping("hospitalmanagementsystem/api/")
public class NurseController {
    @Autowired
    NurseService nurseService;
    @GetMapping("getallpatients/nurse")
    public List<Patient> getallPatients()
    {
        return nurseService.getallPatients();
    }
    @PostMapping("setvitals")
    public Vitals setvitals(@RequestBody Vitals vitals)
    {
        return nurseService.setVitals(vitals);
    }
    @PutMapping("updatevitals/{id}")
    public Vitals updatevitals(@PathVariable Long id,@RequestBody Vitals vitals)
    {
        return nurseService.updatevitals(id,vitals);
    }
}
