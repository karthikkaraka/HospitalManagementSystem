package com.karthik.HospitalManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponce {
    private String doctorname;
    private String patientname;
    private Date date_of_appointment;
    private String reason;
}
