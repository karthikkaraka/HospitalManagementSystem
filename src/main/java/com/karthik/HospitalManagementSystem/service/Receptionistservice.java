package com.karthik.HospitalManagementSystem.service;

import com.karthik.HospitalManagementSystem.dto.AppointmentResponce;
import com.karthik.HospitalManagementSystem.model.Appointment;
import com.karthik.HospitalManagementSystem.model.Doctor;
import com.karthik.HospitalManagementSystem.model.Patient;
import com.karthik.HospitalManagementSystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Receptionistservice {
    @Autowired
    AppointmentRepo apprepo;
    @Autowired
    Userrepo repo;
    @Autowired
    PatientRepo patrepo;
    @Autowired
    DoctorRepo docrepo;
    public Patient addpatient(Patient patient) {
        return patrepo.save(patient);
    }

    public List<Patient> getallparents() {
        return patrepo.findAll();
    }

    public Patient getparent(Long id) {
        Patient patient = patrepo.findById(id).orElse(null);
        if(patient!=null)
        {
            return patient;
        }
        else{
            return null;
        }
    }

    public AppointmentResponce setappointment(com.karthik.HospitalManagementSystem.model.Appointment appointment) {
        Long id = appointment.getDoctor().getId();
        Long patientid = appointment.getPatient().getId();
        Doctor doctor = docrepo.findById(id).orElseThrow(()->new RuntimeException("doctor not found!!"));
       Patient patient = patrepo.findById(patientid).orElseThrow(()->new RuntimeException("Patient not found!!"));


        Appointment newAppointment = new Appointment();
        newAppointment.setDoctor(doctor);
        newAppointment.setPatient(patient);
        newAppointment.setDate_of_appointment(appointment.getDate_of_appointment());
        newAppointment.setReason(appointment.getReason());
        apprepo.save(newAppointment);


       AppointmentResponce appointmentt  = new AppointmentResponce();
       appointmentt.setDoctorname(doctor.getUser().getUsername());
       appointmentt.setPatientname(patient.getName());
       appointmentt.setDate_of_appointment(appointment.getDate_of_appointment());
       appointmentt.setReason(appointment.getReason());
       return appointmentt;
    }

    public List<Appointment> getallappointments() {
        return apprepo.findAll();
    }

    public List<Appointment> getpatientappointmets(Long id) {
        return apprepo.findByPatient(id);
    }

    public List<Appointment> getAppointmentbydoctor(Long id) {
        return apprepo.findBydoctor(id);
    }

    public String deleteappointment(Long id) {
        Appointment app = apprepo.findById(id).orElseThrow(()->new RuntimeException("appointment not found!!!"));
        if(app!=null)
        {
            apprepo.delete(app);
            return "deleted the appointment of patient :"+app.getPatient().getName()+" with doctor :"+app.getDoctor().getUser().getUsername();
        }
        else{
          return  "no such appointment";
        }

    }
}
