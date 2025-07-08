package com.karthik.HospitalManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="doctor_id")
    private Doctor doctor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_id")
    private Patient patient;
    private Date date;
    private String diagnosis;
    private String treatment;
}
