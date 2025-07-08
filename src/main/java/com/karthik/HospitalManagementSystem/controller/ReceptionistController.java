package com.karthik.HospitalManagementSystem.controller;

import com.karthik.HospitalManagementSystem.dto.AppointmentResponce;
import com.karthik.HospitalManagementSystem.model.Appointment;
import com.karthik.HospitalManagementSystem.model.Patient;
import com.karthik.HospitalManagementSystem.service.Receptionistservice;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hospitalmanagementsystem/api/")
@PreAuthorize("hasRole('RECEPTIONIST')")
public class ReceptionistController {
    @Autowired
    Receptionistservice recpser;

    @PostMapping("addpatient")
    public Patient addpatient(@RequestBody Patient patient)
    {
       return recpser.addpatient(patient);
    }
    @GetMapping("getallpatients")
    public List<Patient> getallpatients()
    {
        return recpser.getallparents();
    }
    @GetMapping("getpatient/{id}")
    public Patient getpatient(@PathVariable Long id)
    {
        return recpser.getparent(id);
    }

    //appointment management
    @PostMapping("setappointment")
    public AppointmentResponce setappointment(@RequestBody com.karthik.HospitalManagementSystem.model.Appointment appointment)
    {
        return recpser.setappointment(appointment);
    }
    @GetMapping("getappointments")
    public List<Appointment> getallAppointments()
    {
        return recpser.getallappointments();

    }
    @GetMapping("getappointment/patient/{id}")
    public List<Appointment> getpatientappoitments(@PathVariable Long id)
    {
       return recpser.getpatientappointmets(id);
    }
    @GetMapping("getappointment/doctor/{id}")
    public List<Appointment> getAppointmentsbydoctor(@PathVariable Long id)
    {
       return recpser.getAppointmentbydoctor(id);
    }
    @DeleteMapping("deleteappointment/{id}")
    public String deleteappointment(@PathVariable Long id)
    {
        return recpser.deleteappointment(id);
    }
}
