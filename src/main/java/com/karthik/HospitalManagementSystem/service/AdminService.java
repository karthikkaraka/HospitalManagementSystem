package com.karthik.HospitalManagementSystem.service;

import com.karthik.HospitalManagementSystem.model.Doctor;
import com.karthik.HospitalManagementSystem.model.Nurse;
import com.karthik.HospitalManagementSystem.model.Receptionist;
import com.karthik.HospitalManagementSystem.model.User;
import com.karthik.HospitalManagementSystem.repository.DoctorRepo;
import com.karthik.HospitalManagementSystem.repository.NurseRepo;
import com.karthik.HospitalManagementSystem.repository.Receptionrepo;
import com.karthik.HospitalManagementSystem.repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    DoctorRepo docrepo;
    @Autowired
    NurseRepo nurrepo;
    @Autowired
    Receptionrepo receprepo;
   @Autowired
    Userrepo repo;

    public Doctor registerDoctor(Doctor doctor) {
        Long id = doctor.getUser().getId();
        User user = repo.findById(id).orElseThrow(()-> new RuntimeException("usernotfound"));
        doctor.setUser(user);
        return docrepo.save(doctor);
    }

    public Nurse registerNurse(Nurse nurse) {
        Long id = nurse.getUser().getId();
        User user = repo.findById(id).orElseThrow(()-> new RuntimeException("usernotfound"));
        nurse.setUser(user);
        return nurrepo.save(nurse);
    }

    public Receptionist registerReceptionist(Receptionist reception) {
      Long id = reception.getUser().getId();
        User user = repo.findById(id).orElseThrow(()-> new RuntimeException("usernotfound"));
        System.out.println(user.getUsername());
        reception.setUser(user);
        return receprepo.save(reception);
    }

    public Doctor updatedoctor(Doctor doctor) {
        Doctor originaldoc  = docrepo.findById(doctor.getId()).orElseThrow(()->new RuntimeException("doctor not found"));
        originaldoc.setSpecialization(doctor.getSpecialization());
        originaldoc.setAvailblity(doctor.getAvailblity());
        return docrepo.save(originaldoc);
    }

    public Receptionist updatereception(Receptionist reception) {
        Receptionist originalreception = receprepo.findById(reception.getId()).orElseThrow(()->new RuntimeException("receptionist not found"));
        if(originalreception!=null)
        {
            originalreception.setShift(reception.getShift());
            originalreception.setPhonenum(reception.getPhonenum());
            originalreception.setEmail(reception.getEmail());
           return  receprepo.save(originalreception);
        }
        else{
            return reception;
        }

    }

    public Nurse updateNurse(Nurse nurse) {
        Nurse originalnurse = nurrepo.findById(nurse.getId()).orElseThrow(()->new RuntimeException("receptionist not found"));
        if(originalnurse!=null)
        {
            originalnurse.setEmail(nurse.getEmail());
            originalnurse.setPhonenum(nurse.getPhonenum());
            originalnurse.setShift(nurse.getShift());
            originalnurse.setWardnoandfloorno(nurse.getWardnoandfloorno());
            return nurrepo.save(originalnurse);
        }
        else{
            return nurse;
        }
    }

    public String deletedoctor(Long id) {
        Doctor originaldoctor = docrepo.findById(id).orElse(null);
        Long originaldoctorid = originaldoctor.getId();
        if(originaldoctor!=null)
        {
            docrepo.delete(originaldoctor);
        }
     return "deleted the record of id:"+originaldoctorid;
    }

    public String deletenurse(Long id) {
        Nurse originalnurse = nurrepo.findById(id).orElse(null);
        Long originalnurseid = originalnurse.getId();
        if(originalnurse!=null)
        {
            nurrepo.delete(originalnurse);
        }
        return "deleted the record of id:"+originalnurseid;
    }

    public String deletereceptionist(Long id) {
        Receptionist originalreception = receprepo.findById(id).orElse(null);
        Long originalreceptionid = originalreception.getId();
        if(originalreception!=null)
        {
            receprepo.delete(originalreception);
        }
        return "deleted the record of id:"+originalreceptionid;
    }
}
