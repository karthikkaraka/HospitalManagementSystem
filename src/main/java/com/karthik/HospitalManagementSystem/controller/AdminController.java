package com.karthik.HospitalManagementSystem.controller;
import com.karthik.HospitalManagementSystem.model.Doctor;
import com.karthik.HospitalManagementSystem.model.Nurse;
import com.karthik.HospitalManagementSystem.model.Receptionist;
import com.karthik.HospitalManagementSystem.model.User;
import com.karthik.HospitalManagementSystem.service.AdminService;
import com.karthik.HospitalManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hospitalmanagementsystem/api/")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    UserService service;
    @Autowired
    AdminService admser;
    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }
    @PostMapping("/register")
    public User register(@RequestBody User user)
    {
        System.out.println("role:"+user.getRole());
        return service.registeruser(user);
    }
    //hiring doctors, receptionists,and nurses
    @PostMapping("/register/doctor")
    public Doctor registerdoctor(@RequestBody Doctor doctor)
    {
        System.out.println(doctor.getUser());
        return admser.registerDoctor(doctor);
    }
    @PostMapping("/register/nurse")
    public Nurse registernurse(@RequestBody Nurse nurse)
    {
        return admser.registerNurse(nurse);
    }
    @PostMapping("/register/receptionist")
    public Receptionist registerreception(@RequestBody Receptionist reception)
    {
        return admser.registerReceptionist(reception);
    }
    //updating the data of doctors reeptionist and nurses
    @PutMapping("updatedoctor")
    public Doctor updatedoctor(@RequestBody Doctor doctor)
    {
        System.out.println("entered for an update");
        return admser.updatedoctor(doctor);
    }
    @PutMapping("updateReceptionist")
    public Receptionist updatereception(@RequestBody Receptionist reception)
    {
        return admser.updatereception(reception);
    }
    @PutMapping("updateNurse")
    public Nurse updatenurse(@RequestBody Nurse nurse)
    {
        return admser.updateNurse(nurse);
    }
    //deleting the receptionists doctors and nurses
    @DeleteMapping("deletedoctor/{id}")
    public String deletedoctor(@PathVariable Long id)
    {
        return admser.deletedoctor(id);
    }
    @DeleteMapping("deletenurse/{id}")
    public String deletenurse(@PathVariable Long id)
    {
        return admser.deletenurse(id);
    }
    @DeleteMapping("deletereceptionist/{id}")
    public String deletereception(@PathVariable Long id)
    {
        return admser.deletereceptionist(id);
    }
}
