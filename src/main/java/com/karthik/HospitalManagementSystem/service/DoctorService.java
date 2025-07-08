package com.karthik.HospitalManagementSystem.service;

import com.karthik.HospitalManagementSystem.model.*;
import com.karthik.HospitalManagementSystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepo docrepo;
    @Autowired
    NurseRepo nurrepo;
    @Autowired
    Receptionrepo receprepo;
    @Autowired
    AppointmentRepo apprepo;
    @Autowired
   PatientRepo patrepo;
    @Autowired
    Userrepo repo;
    @Autowired
    DiagnosisRepo diarepo;
    public List<Appointment> getappointments(String name) {
        User user = repo.findByUsername(name);
        Long id = user.getId();
        Doctor doc = docrepo.findDoctor(id);
        Long doctorid = doc.getId();
        return apprepo.findAppointments(doctorid);
    }


    public Diagnosis writemedrep(Diagnosis dia) {
       Long docid = dia.getDoctor().getId();
       Long patientid = dia.getPatient().getId();
       Doctor doc  = docrepo.findById(docid).orElseThrow(()->new RuntimeException("doctor not found!!!"));
       Patient pat = patrepo.findById(patientid).orElseThrow(()->new RuntimeException("patient not found!!!"));
       Diagnosis diago = new Diagnosis();
       diago.setDoctor(doc);
       diago.setPatient(pat);
       diago.setTreatment(dia.getTreatment());
       diago.setDate(dia.getDate());
       diago.setDiagnosis(dia.getDiagnosis());
       return diarepo.save(diago);

    }

    public List<Diagnosis> getMedicalrecord(Long id) {
        Patient pat = patrepo.findById(id).orElseThrow(null);
        if(pat!=null)
        {
           return diarepo.getMedicalreport(id);
        }
        else{
            return null;
        }

    }
}
