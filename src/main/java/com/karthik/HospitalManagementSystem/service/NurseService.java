package com.karthik.HospitalManagementSystem.service;

import com.karthik.HospitalManagementSystem.model.Nurse;
import com.karthik.HospitalManagementSystem.model.Patient;
import com.karthik.HospitalManagementSystem.model.Vitals;
import com.karthik.HospitalManagementSystem.repository.NurseRepo;
import com.karthik.HospitalManagementSystem.repository.PatientRepo;
import com.karthik.HospitalManagementSystem.repository.VitalsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {
    @Autowired
    VitalsRepo vitrepo;
    @Autowired
    PatientRepo patrepo;
    @Autowired
    NurseRepo nurrepo;
    public List<Patient> getallPatients() {
        return patrepo.findAll();
    }
    public Vitals setVitals(Vitals vitals) {
        Long patientid = vitals.getPatient().getId();
        Long nurid = vitals.getNurse().getId();
        Patient pat = patrepo.findById(patientid).orElseThrow(()->new RuntimeException("no patient found!!!"));
        Nurse nurse = nurrepo.findById(nurid).orElseThrow(()->new RuntimeException("no patient found!!!"));
        if(pat!=null&&nurse!=null)
        {
            Vitals vit = new Vitals();
            vit.setNurse(nurse);
            vit.setPatient(pat);
            vit.setId(vitals.getId());
            vit.setPulse(vitals.getPulse());
            vit.setTemperature(vitals.getTemperature());
            vit.setBloodPressure(vitals.getBloodPressure());
            vit.setRecordedAt(vitals.getRecordedAt());
            vit.setRespirationRate(vitals.getRespirationRate());
           return vitrepo.save(vit);
        }
        else{
            return null;
        }
    }

    public Vitals updatevitals(Long id, Vitals vitals) {
        Patient pat = patrepo.findById(id).orElseThrow(()->new RuntimeException("patient not Found"));
        if(pat!=null)
        {
            Nurse nur = nurrepo.findById(vitals.getNurse().getId()).orElseThrow(()->new RuntimeException("Nurse not Found"));
           vitals.setPatient(pat);
           vitals.setNurse(nur);
          return vitrepo.save(vitals);
        }
        else{
            return null;
        }
    }
}
